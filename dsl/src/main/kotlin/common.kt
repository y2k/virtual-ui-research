import com.google.gson.GsonBuilder

fun printPretty(x: Any) {
    GsonBuilder()
        .setPrettyPrinting()
        .create()
        .toJson(x)
        .let(::println)
}
