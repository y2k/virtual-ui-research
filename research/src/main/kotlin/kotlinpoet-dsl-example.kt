import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asTypeName

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
}
