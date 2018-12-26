fun main(args: Array<String>) {
    foo(object : Reader, Writer {
        override fun write(x: Any): Unit = TODO()
        override fun read(): String? = TODO()
    })
    foo(object : Reader by Reader, Writer by Writer {})
    foo(Console)

    bar(object : Reader, Writer, Preferences {
        override fun write(x: Any): Unit = TODO()
        override fun read(): String? = TODO()
        override fun load(key: String): String? = TODO()
        override fun save(key: String, value: String): Unit = TODO()
    })
    bar(object : Reader by Reader, Writer by Writer, Preferences by Preferences {})
    bar(System)

    write(Writer)
}

object Console : Reader by Reader, Writer by Writer
object System : Reader by Reader, Preferences by Preferences, Writer by Writer

fun <T> bar(e: T) where T : Reader, T : Writer, T : Preferences {
    foo(e)
    usePrefs(e)
}

fun <T> foo(e: T) where T : Reader, T : Writer {
    write(e)
    read(e)
}

fun <T : Writer> write(e: T) {
    e.write("hello world")
}

fun <T : Reader> read(e: T) {
    val x = e.read()
    x?.length
}

fun <T : Preferences> usePrefs(e: T) {
    e.save("x", e.load("x") ?: "y")
}

interface Preferences {
    fun save(key: String, value: String)
    fun load(key: String): String?

    companion object : Preferences {
        override fun save(key: String, value: String): Unit = TODO()
        override fun load(key: String): String? = TODO()
    }
}

interface Writer {
    fun write(x: Any)

    companion object : Writer {
        override fun write(x: Any): Unit = TODO()
    }
}

interface Reader {
    fun read(): String?

    companion object : Reader {
        override fun read(): String? = TODO()
    }
}
