import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

fun main(args: Array<String>) {
    val components = listOf(
        ComponentDesc(
            ClassName.bestGuess("android.widget.TextView"),
            listOf(
                PropertyDescription("text", ClassName.bestGuess("String")),
                PropertyDescription("textSize", ClassName.bestGuess("Float"))
            )
        ),
        ComponentDesc(
            ClassName.bestGuess("android.widget.LinearLayout"),
            listOf(
                PropertyDescription("text", ClassName.bestGuess("String")),
                PropertyDescription("textSize", ClassName.bestGuess("Float"))
            )
        )
    )

    val fileSpecBuild = FileSpec
        .builder("y2k.virtualui", "dsl")

    components.forEach {
        fileSpecBuild.addType(createType(it.properties, it.viewType))
    }

    println(fileSpecBuild.build())
}

class ComponentDesc(val viewType: ClassName, val properties: List<PropertyDescription>)
class PropertyDescription(val name: String, val type: ClassName)

private fun createType(properties: List<PropertyDescription>, inputViewClass: ClassName): TypeSpec {
    val clazz = inputViewClass.simpleName
    val className = ClassName.bestGuess("${clazz}_")

    val viewBuilder = TypeSpec
        .classBuilder(className)
        .addSuperinterface(ClassName.bestGuess("PropertyHolder"))

    properties.forEach {
        viewBuilder.addProp(inputViewClass, it.name, it.type)
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

private fun TypeSpec.Builder.addProp(inputViewClass: TypeName, name: String, type: ClassName): TypeSpec.Builder {
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
                .initializer("%T(%L, %T::%L)", propertyType, getDefaultValue(type), inputViewClass, toSetter(name))
                .build()
        )
}

fun getDefaultValue(type: ClassName): String =
    when (type.simpleName) {
        "String" -> "\"\""
        "Float" -> "0.0f"
        "Int" -> "0"
        "Boolean" -> "false"
        else -> "null"
    }

fun toSetter(name: String): String =
    "set${name[0].toUpperCase()}${name.drop(1)}"
