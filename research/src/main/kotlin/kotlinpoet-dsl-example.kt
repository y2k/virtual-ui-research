import com.squareup.kotlinpoet.*

const val libraryPackage = "y2k.virtual.ui"

fun main(args: Array<String>) {
    val components = listOf(
        ComponentDesc(
            ClassName.bestGuess("android.widget.TextView"),
            ClassName.bestGuess("android.view.View"),
            listOf(
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            ),
            false
        ),
        ComponentDesc(
            ClassName.bestGuess("android.widget.LinearLayout"),
            ClassName.bestGuess("android.view.ViewGroup"),
            listOf(
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            ),
            true
        )
    )

    val fileSpecBuild = FileSpec
        .builder(libraryPackage, "dsl.kt")

    components.forEach {
        fileSpecBuild.addFunction(createTypeDsl(it.type, it.group))
    }

    fileSpecBuild.build().let(::println)
}

/*
fun linearLayout(f: LinearLayout_.() -> Unit): LinearLayout_ {
    val l = LinearLayout_()
    globalViewStack.push(l)
    l.f()
    globalViewStack.pop()
    return l
}

fun button(f: Button_.() -> Unit) {
    val b = Button_()
    b.f()
    globalViewStack.peek().children.add(b)
}
*/

fun createTypeDsl(inputViewClass: ClassName, group: Boolean): FunSpec {
    return FunSpec
        .builder(toDslFunName(inputViewClass))
        .addParameter(
            "f",
            LambdaTypeName.get(
                ClassName.bestGuess(inputViewClass.simpleName + "_"),
                emptyList(),
                Unit::class.asTypeName()
            )
        )
        .addCode(
            """
                val x = %L_()
                %L
                x.f()
                %L
                globalViewStack.peek()?.children?.add(x)
                """.trimIndent(),
            inputViewClass.simpleName,
            if (group) "globalViewStack.push(x)" else "",
            if (group) "globalViewStack.pop()" else ""
        )
        .build()
}

fun toDslFunName(inputViewClass: ClassName): String {
    val x = inputViewClass.simpleName
    return x[0].toLowerCase() + x.substring(1)
}
