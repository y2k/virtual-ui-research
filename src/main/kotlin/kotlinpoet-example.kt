import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec

fun main(args: Array<String>) {
    val utils = FileSpec.builder("com.example", "Utils")
        .addAnnotation(
            AnnotationSpec.builder(JvmName::class)
                .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
                .build()
        )
        .addFunction(
            FunSpec.builder("abs")
                .receiver(Int::class)
                .returns(Int::class)
                .addStatement("return if (this < 0) -this else this")
                .build()
        )
        .build()

    println(utils)
}
