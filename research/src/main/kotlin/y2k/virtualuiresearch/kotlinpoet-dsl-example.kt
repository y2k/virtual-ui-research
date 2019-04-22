package y2k.virtualuiresearch

import com.squareup.kotlinpoet.*
import y2k.virtualuiresearch.common.simpleName

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
            false,
            false
        ),
        ComponentDesc(
            ClassName.bestGuess("android.widget.LinearLayout"),
            ClassName.bestGuess("android.view.ViewGroup"),
            listOf(
                PropertyDescription("setText", String::class.asTypeName()),
                PropertyDescription("setTextSize", Float::class.asTypeName())
            ),
            true,
            false
        )
    )

    val fileSpecBuild = FileSpec
        .builder(libraryPackage, "dsl.kt")

    components.forEach {
        fileSpecBuild.addFunction(createTypeDsl(it.type, it.group))
    }

    fileSpecBuild.build().let(::println)
}

fun createTypeDsl(inputViewClass: TypeName, group: Boolean): FunSpec {
    val componentClass = ClassName.bestGuess(inputViewClass.simpleName + "_")
    return FunSpec
        .builder(toDslFunName(inputViewClass))
        .addParameter(
            "f",
            LambdaTypeName.get(
                componentClass,
                emptyList(),
                Unit::class.asTypeName()
            )
        )
        .returns(componentClass)
        .addCode(
            """
                val x = %L_()
                %L
                x.f()
                %L
                globalViewStack.lastOrNull()?.children?.add(x)
                return x
                """.trimIndent(),
            inputViewClass.simpleName,
            if (group) "globalViewStack.push(x)" else "",
            if (group) "globalViewStack.pop()" else ""
        )
        .build()
}

fun toDslFunName(inputViewClass: TypeName): String {
    val x = inputViewClass.simpleName
    return x[0].toLowerCase() + x.substring(1)
}
