import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

fun main(args: Array<String>) {
    val components = listOf(
        ComponentDesc(
            ClassName.bestGuess("android.widget.TextView"),
            listOf(
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            )
        ),
        ComponentDesc(
            ClassName.bestGuess("android.widget.LinearLayout"),
            listOf(
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            )
        )
    )

    printComponents(components)
}

fun printComponents(components: List<ComponentDesc>) {
    val fileSpecBuild = FileSpec
        .builder("y2k.virtualui", "dsl")

    components.forEach {
        fileSpecBuild.addType(createType(it.properties, it.viewType))
    }

    println(fileSpecBuild.build())
}

data class ComponentDesc(val viewType: ClassName, val properties: List<PropertyDescription>)
data class PropertyDescription(val methodName: String, val type: TypeName)

private fun createType(properties: List<PropertyDescription>, inputViewClass: ClassName): TypeSpec {
    val clazz = inputViewClass.simpleName
    val className = ClassName.bestGuess("${clazz}_")

    val viewBuilder = TypeSpec
        .classBuilder(className)
        .addSuperinterface(ClassName.bestGuess("PropertyHolder"))

    properties.forEach {
        viewBuilder.addProp(inputViewClass, it.methodName, it.type)
    }

    return viewBuilder
        .addProperty(
            PropertySpec
                .builder(
                    "props",
                    ClassName.bestGuess("List<Property<out Any, $clazz>>"),
                    KModifier.OVERRIDE
                )
                .initializer(
                    "listOf(%N)",
                    listOf("text", "textSize").joinToString(transform = { "_$it" })
                )
                .build()
        )
        .addFunction(
            FunSpec.builder("createEmpty")
                .addModifiers(KModifier.OVERRIDE)
                .addParameter("context", ClassName.bestGuess("android.content.Context"))
                .addCode("return $clazz(context)")
                .build()
        )
        .build()
}

private fun TypeSpec.Builder.addProp(inputViewClass: TypeName, methodName: String, type: TypeName): TypeSpec.Builder {
    val name = toPropertyName(methodName)
    val privateProp = "_$name"
    val propertyType = ClassName.bestGuess("Property")

    return addProperty(
        PropertySpec
            .builder(name, type)
            .mutable(true)
            .getter(
                FunSpec.getterBuilder()
                    .addCode("throw IllegalStateException()")
                    .build()
            )
            .setter(
                FunSpec.setterBuilder()
                    .addParameter("value", type)
                    .addCode("$privateProp.set(value)")
                    .build()
            )
            .build()
    )
        .addProperty(
            PropertySpec
                .builder(
                    privateProp,
                    propertyType.parameterizedBy(type, inputViewClass),
                    KModifier.PRIVATE
                )
                .initializer("%T(%L, %T::%L)", propertyType, getDefaultValue(type), inputViewClass, methodName)
                .build()
        )
}

private fun toPropertyName(methodName: String): String =
    methodName[3].toLowerCase() + methodName.substring(4)

fun getDefaultValue(type: TypeName): String =
    when (type) {
        String::class.asTypeName() -> "\"\""
        Float::class.asTypeName() -> "0.0f"
        Int::class.asTypeName() -> "0"
        Boolean::class.asTypeName() -> "false"
        else -> "null"
    }
