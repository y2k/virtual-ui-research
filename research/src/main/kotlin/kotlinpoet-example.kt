import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
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
            true
        )
    )

    printComponents(components)
}

fun printComponents(components: List<ComponentDesc>) {
    val fileSpecBuild = FileSpec
        .builder(libraryPackage, "dsl")

    components.forEach {
        fileSpecBuild.addFunction(createTypeDsl(it.type, it.group))
        fileSpecBuild.addType(createType(it))
    }

    println(fileSpecBuild.build())
}

data class ComponentDesc(
    val type: ClassName,
    val parentType: ClassName?,
    val properties: List<PropertyDescription>,
    val group: Boolean
)

data class PropertyDescription(val methodName: String, val type: TypeName)

fun createType(comp: ComponentDesc): TypeSpec {
    val clazz = comp.type.simpleName
    val className = ClassName.bestGuess("${clazz}_")
    val viewBuilder = TypeSpec
        .classBuilder(className)
        .addModifiers(KModifier.OPEN)

    viewBuilder.addInitializerBlock(
        CodeBlock.of(
            "props += listOf(%N)",
            comp.properties.map { toPropertyName(it.methodName) }.joinToString(transform = { "_$it" })
        )
    )

    if (comp.type.canonicalName == "android.view.View") {
        viewBuilder
            .superclass(ClassName.bestGuess("VirtualNode"))
    } else if (comp.parentType != null && comp.parentType.canonicalName !in listOf("java.lang.Object")) {
        val sc = comp.parentType.simpleName + "_"

        viewBuilder
            .superclass(ClassName.bestGuess(sc))
    }

    comp.properties
        .map { mkCompProps(comp.type, it.methodName, it.type) }
        .forEach { viewBuilder.addProperties(it) }

    mkCreateEmpty(clazz)?.let { viewBuilder.addFunction(it) }

    return viewBuilder.build()
}

private fun mkCreateEmpty(clazz: String): FunSpec? =
    if (clazz == "ViewGroup") null
    else FunSpec.builder("createEmpty")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("context", ClassName.bestGuess("android.content.Context"))
        .addCode("return $clazz(context)")
        .build()

private fun mkCompProps(inputViewClass: TypeName, methodName: String, methodType: TypeName): List<PropertySpec> {
    val name = toPropertyName(methodName)
    val privateProp = "_$name"
    val fixedType =
        when (methodType) {
            ClassName.bestGuess("java.lang.CharSequence") -> ClassName.bestGuess("CharSequence")
            ClassName.bestGuess("java.lang.String") -> ClassName.bestGuess("String")
            ClassName.bestGuess("java.lang.Object") -> ClassName.bestGuess("Any")
            else -> methodType
        }

    val p1 = PropertySpec
        .builder(name, fixedType)
        .mutable(true)
        .getter(
            FunSpec.getterBuilder()
                .addCode("throw IllegalStateException()")
                .build()
        )
        .setter(
            FunSpec.setterBuilder()
                .addParameter("value", fixedType)
                .addCode("$privateProp.set(value)")
                .build()
        )
        .build()

    val propertyType = ClassName.bestGuess("Property")
    val defValue = getDefaultValue(fixedType)

    val p2 = PropertySpec
        .builder(
            privateProp,
            propertyType.parameterizedBy(fixedType.copy(defValue == null), inputViewClass),
            KModifier.PRIVATE
        )
        .initializer("%T(%L, %T::%L)", propertyType, defValue, inputViewClass, methodName)
        .build()

    return listOf(p1, p2)
}

private fun toPropertyName(methodName: String): String =
    methodName[3].toLowerCase() + methodName.substring(4)

fun getDefaultValue(type: TypeName): String? =
    when (type) {
        Float::class.asTypeName() -> "0.0f"
        Int::class.asTypeName() -> "0"
        Boolean::class.asTypeName() -> "false"
        else -> null
    }
