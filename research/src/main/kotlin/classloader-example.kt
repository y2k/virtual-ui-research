import java.io.File
import java.net.URLClassLoader
import java.util.*
import java.util.jar.JarFile

fun main(args: Array<String>) {
    val android = File(args[0])

    val loader = URLClassLoader(arrayOf(android.toURL()), ClassLoader.getSystemClassLoader())

    val result = loadAndScanJar(android, loader)
    val classes = result["classes"]!!

    val filterParent = classes.first { it.name == "android.view.View" }

    classes.forEach { handleClass(it, filterParent) }
}

fun handleClass(clazz: Class<*>, filterParent: Class<*>) {
    if (!filterParent.isAssignableFrom(clazz)) return

    println(clazz.canonicalName + " : " + clazz.superclass.canonicalName)

    printMethods(clazz)
}

fun printMethods(clazz: Class<*>) {
    clazz.methods
        .filter { it.name.matches(Regex("set[A-Z].+")) }
        .filter { it.parameterCount == 1 }
        .forEach { println("\t${it.name}(${it.parameters.joinToString { it.type.simpleName }})") }
}

private fun loadAndScanJar(jarFile: File, loader: ClassLoader): Map<String, List<Class<*>>> {
    val classes = HashMap<String, List<Class<*>>>()

    val interfaces = ArrayList<Class<*>>()
    val clazzes = ArrayList<Class<*>>()
    val enums = ArrayList<Class<*>>()
    val annotations = ArrayList<Class<*>>()

    classes["interfaces"] = interfaces
    classes["classes"] = clazzes
    classes["annotations"] = annotations
    classes["enums"] = enums

    val jar = JarFile(jarFile)
    val enumeration = jar.entries()

    while (enumeration.hasMoreElements()) {
        val zipEntry = enumeration.nextElement()

        if (zipEntry.name.endsWith(".class")) {
            var className = zipEntry.name
            className = className.replace(".class", "").replace("/", ".")
            val clazz = loader.loadClass(className)

            try {
                when {
                    clazz.isInterface -> interfaces.add(clazz)
                    clazz.isAnnotation -> annotations.add(clazz)
                    clazz.isEnum -> enums.add(clazz)
                    else -> clazzes.add(clazz)
                }
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
        }
    }

    return classes
}
