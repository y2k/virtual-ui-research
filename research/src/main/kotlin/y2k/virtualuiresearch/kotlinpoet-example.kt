package y2k.virtualuiresearch

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import y2k.virtualuiresearch.asm.ClassRecord
import y2k.virtualuiresearch.common.canonicalName
import y2k.virtualuiresearch.common.simpleName
import java.io.File

fun main(args: Array<String>) {
    val components = listOf(
        ComponentDesc(
            ClassName.bestGuess("android.widget.TextView"),
            ClassName.bestGuess("android.view.View"),
            listOf(
                PropertyDescription("setFile", File::class.asTypeName()),
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            ),
            false,
            false
        ),
        ComponentDesc(
            ClassName.bestGuess("android.widget.LinearLayout"),
            ClassName.bestGuess("android.view.ViewGroup"),
            listOf(
                PropertyDescription("setFile", File::class.asTypeName()),
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            ),
            true,
            false
        )
    )

    printComponents(components)
}

fun printComponents(components: List<ComponentDesc>) {
    val fileSpecBuild = FileSpec
        .builder(libraryPackage, "dsl")

    components.forEach {
        fileSpecBuild.addFunction(createTypeDsl(it.type, it.group))
        fileSpecBuild.addType(createType(it, emptySet()))
    }

    println(fileSpecBuild.build())
}

data class ComponentDesc(
    val type: TypeName,
    val parentType: TypeName?,
    val properties: List<PropertyDescription>,
    val group: Boolean,
    val isAbstract: Boolean,
    val typeBound: TypeName? = null
)

data class PropertyDescription(val methodName: String, val type: TypeName, val hasOverloads: Boolean = false)

fun createType(comp: ComponentDesc, nonNullMethods: Set<ClassRecord>): TypeSpec {
    val clazz = comp.type.simpleName
    val className = ClassName.bestGuess("${clazz}_")
    val viewBuilder = TypeSpec
        .classBuilder(className)
        .addModifiers(KModifier.OPEN)

    if (comp.type is ParameterizedTypeName) {
        viewBuilder.addTypeVariable(TypeVariableName("T", comp.type.typeArguments[0]))
    }

    if (comp.type.canonicalName == "android.view.View") {
        viewBuilder.superclass(ClassName.bestGuess("VirtualNode"))
    } else if (comp.parentType != null && comp.parentType.canonicalName !in listOf("java.lang.Object")) {
        val sc = ClassName.bestGuess(comp.parentType.simpleName + "_")
        if (comp.parentType is ParameterizedTypeName) {
            val psc = sc.parameterizedBy(comp.parentType.typeArguments[0])
            viewBuilder.superclass(psc)
        } else {
            viewBuilder.superclass(sc)
        }
    }

    comp.properties
        .map { mkCompProps(comp.type, it.methodName, it.type, it.hasOverloads, nonNullMethods) }
        .forEach { viewBuilder.addProperties(it) }

    mkCreateEmpty(comp.type, comp.isAbstract)
        ?.let(viewBuilder::addFunction)

    return viewBuilder.build()
}

private fun mkCreateEmpty(clazz: TypeName, isAbstract: Boolean): FunSpec? =
    if (isAbstract) null
    else FunSpec.builder("createEmpty")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("context", ClassName.bestGuess("android.content.Context"))
        .addCode("return %T(context)", clazz)
        .build()

private fun mkCompProps(
    inputViewClass: TypeName,
    methodName: String,
    methodType: TypeName,
    hasOverloads: Boolean,
    nonNullMethods: Set<ClassRecord>
): List<PropertySpec> {
    val name =
        if (hasOverloads) toPropertyName(methodName) + methodType.simpleName
        else toPropertyName(methodName)

    val privateProp = "_$name"
    val fixedType = fixPropertyType(methodType)
    val propertyType = ClassName.bestGuess("Property")
    val defValue = getDefaultValue(fixedType)
    val record = ClassRecord(inputViewClass.canonicalName, methodName)
    val nullable = defValue == null && record !in nonNullMethods
    val fixedType2 = fixedType.copy(nullable)

    val pubProp = PropertySpec
        .builder(name, fixedType2)
        .mutable(true)
        .getter(
            FunSpec.getterBuilder()
                .addAnnotation(
                    AnnotationSpec
                        .builder(Deprecated::class)
                        .addMember("\"\", level = DeprecationLevel.HIDDEN")
                        .build()
                )
                .addCode("throw IllegalStateException()")
                .build()
        )
        .setter(
            FunSpec.setterBuilder()
                .addParameter("value", fixedType)
                .addCode("updateProp(value, $privateProp)")
                .build()
        )
        .build()

    val isRemote = isRemote(fixedType)

    val privProp = PropertySpec
        .builder(
            privateProp,
            propertyType.parameterizedBy(fixedType2, inputViewClass),
            KModifier.PRIVATE
        )
        .initializer("%T(%L, %S, %L, %T::%L)", propertyType, isRemote, name, defValue, inputViewClass, methodName)

    if (!isRemote)
        privProp.addAnnotation(Transient::class)

    return listOf(pubProp, privProp.build())
}

private fun isRemote(type: TypeName): Boolean =
    (getDefaultValue(type) != null
        || type == CharSequence::class.asTypeName()
        || type == String::class.asTypeName())

private fun fixPropertyType(methodType: TypeName): TypeName =
    when (methodType) {
        ClassName.bestGuess("java.lang.CharSequence") -> ClassName.bestGuess("kotlin.CharSequence")
        ClassName.bestGuess("java.lang.String") -> ClassName.bestGuess("kotlin.String")
        ClassName.bestGuess("java.lang.Object") -> ClassName.bestGuess("kotlin.Any")
        else -> {
            if (methodType is ParameterizedTypeName)
                methodType.rawType.parameterizedBy(
                    *methodType.typeArguments.map { fixPropertyType(it) }.toTypedArray()
                )
            else methodType
        }
    }

private fun toPropertyName(methodName: String): String =
    methodName[3].toLowerCase() + methodName.substring(4)

fun getDefaultValue(type: TypeName): String? =
    when (type) {
        Float::class.asTypeName() -> "0.0f"
        Int::class.asTypeName() -> "0"
        Long::class.asTypeName() -> "0L"
        Boolean::class.asTypeName() -> "false"
        else -> null
    }
