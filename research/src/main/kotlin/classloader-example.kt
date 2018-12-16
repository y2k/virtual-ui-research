import common.loadAllClassesFromJar
import java.io.File
import java.net.URLClassLoader

fun main(args: Array<String>) {
    val android = File(args[0])

    val loader = URLClassLoader(arrayOf(android.toURL()), ClassLoader.getSystemClassLoader())

    val classes = loadAllClassesFromJar(android, loader)

    val filterParent = classes.first { it.name == "android.view.View" }

    classes.forEach { handleClass(it, filterParent) }
}

private fun handleClass(clazz: Class<*>, filterParent: Class<*>) {
    if (!filterParent.isAssignableFrom(clazz)) return

    println(clazz.canonicalName + " : " + clazz.superclass.canonicalName)

    printMethods(clazz)
}

private fun printMethods(clazz: Class<*>) {
    clazz.methods
        .filter { it.name.matches(Regex("set[A-Z].+")) }
        .filter { it.parameterCount == 1 }
        .forEach { println("\t${it.name}(${it.parameters.joinToString { it.type.simpleName }})") }
}
