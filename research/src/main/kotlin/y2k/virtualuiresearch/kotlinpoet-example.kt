package y2k.virtualuiresearch

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import y2k.virtual.ui.Quadruple
import y2k.virtualuiresearch.asm.ClassRecord
import y2k.virtualuiresearch.common.canonicalName
import y2k.virtualuiresearch.common.simpleName

data class ComponentDesc(
    val type: TypeName,
    val parentType: TypeName?,
    val properties: List<PropertyDescription>,
    val group: Boolean,
    val isAbstract: Boolean,
    val typeBound: TypeName? = null
)

data class PropertyDescription(val methodName: String, val types: List<TypeName>, val hasOverloads: Boolean = false)

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
        .map { mkCompProps(comp.type, it.methodName, it.types, it.hasOverloads, nonNullMethods) }
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
    methodTypes: List<TypeName>,
    hasOverloads: Boolean,
    nonNullMethods: Set<ClassRecord>
): List<PropertySpec> {
    val name =
        if (hasOverloads) genOverloadsName(methodName, methodTypes)
        else toPropertyName(methodName)

    val privateProp = "_$name"
    val fixedTypes = methodTypes.map { fixPropertyType(it) }
    val propertyType = ClassName.bestGuess("Property")
    val defValues = fixedTypes.map { getDefaultValue(it) }
    val fixedType2s =
        fixedTypes.zip(defValues) { fixedType, defValue ->
            fixedType.copy(isNullable(defValue, inputViewClass, methodName, nonNullMethods))
        }

    val complexTN = generateComplexType(fixedType2s)

    val pubProp = PropertySpec
        .builder(name, complexTN)
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
                .addParameter("value", complexTN)
                .addCode("updateProp(value, $privateProp)")
                .build()
        )
        .build()

    val isRemote = fixedTypes.size > 1 || isRemote(fixedTypes[0])

    val privProp = PropertySpec
        .builder(
            privateProp,
            propertyType.parameterizedBy(complexTN, inputViewClass),
            KModifier.PRIVATE)

    when {
        methodTypes.size == 1 -> privProp.initializer(
            "%T(%L, %S, %L, %T::%L)",
            propertyType, isRemote, name, defValues[0], inputViewClass, methodName)
        methodTypes.size == 2 -> privProp.initializer(
            "%T(%L, %S, Pair(%L), { a, b -> a.%L(b.first, b.second) })",
            propertyType, isRemote, name, defValues.joinToString(), methodName)
        methodTypes.size == 3 -> privProp.initializer(
            "%T(%L, %S, Triple(%L), { a, b -> a.%L(b.first, b.second, b.third) })",
            propertyType, isRemote, name, defValues.joinToString(), methodName)
        methodTypes.size == 4 -> privProp.initializer(
            "%T(%L, %S, Quadruple(%L), { a, b -> a.%L(b.first, b.second, b.third, b.fourth) })",
            propertyType, isRemote, name, defValues.joinToString(), methodName)
        else -> error("${methodTypes.size}")
    }

    if (!isRemote)
        privProp.addAnnotation(Transient::class)

    return listOf(pubProp, privProp.build())
}

fun generateComplexType(types: List<TypeName>): TypeName =
    when (types.size) {
        1 -> types[0]
        2 -> Pair::class.java.asClassName().parameterizedBy(*types.toTypedArray())
        3 -> Triple::class.java.asClassName().parameterizedBy(*types.toTypedArray())
        4 -> Quadruple::class.java.asClassName().parameterizedBy(*types.toTypedArray())
        else -> error("${types.size}")
    }

private fun genOverloadsName(
    methodName: String,
    methodTypes: List<TypeName>
): String {
    return toPropertyName(methodName) + methodTypes.joinToString(
        separator = "",
        transform = { it.simpleName })
}

private fun isNullable(
    defValue: String?,
    inputViewClass: TypeName,
    methodName: String,
    nonNullMethods: Set<ClassRecord>
): Boolean {
    return defValue == null && ClassRecord(
        inputViewClass.canonicalName,
        methodName) !in nonNullMethods
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
        Char::class.asTypeName() -> "Char.MIN_VALUE"
        else -> null
    }
