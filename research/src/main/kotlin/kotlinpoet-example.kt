import com.squareup.kotlinpoet.*

fun main(args: Array<String>) {
    val utils =
        FileSpec
            .builder("y2k.virtualui", "dsl")
            .addType(
                TypeSpec.classBuilder("TextView_")
                    .addSuperinterface(ClassName.bestGuess("PropertyHolder"))
                    .addProp("text", "String")
                    .addProp("textSize", "Float")
                    .addProperty(
                        PropertySpec
                            .builder(
                                "props",
                                ClassName.bestGuess("List<Property<out Any, TextView>>"),
                                KModifier.OVERRIDE
                            )
                            .initializer(
                                "listOf( %P )",
                                listOf("text", "textSize").joinToString(transform = { it + "_" })
                            )
                            .build()
                    )
                    .addFunction(
                        FunSpec.builder("createEmpty")
                            .addModifiers(KModifier.OVERRIDE)
                            .addCode("return TextView()")
                            .build()
                    )
                    .build()
            )
            .build()

    println(utils)
}

private fun TypeSpec.Builder.addProp(name: String, type: String): TypeSpec.Builder =
    addProperty(
        PropertySpec
            .builder(name, String::class)
            .mutable(true)
            .getter(
                FunSpec.getterBuilder()
                    .addCode("throw IllegalStateException()")
                    .build()
            )
            .setter(
                FunSpec.setterBuilder()
                    .addParameter("value", String::class)
                    .addCode("${name}_.set(value)")
                    .build()
            )
            .build()
    )
        .addProperty(
            PropertySpec
                .builder("${name}_", ClassName.bestGuess("Property<$type, TextView>"), KModifier.PRIVATE)
                .build()
        )
