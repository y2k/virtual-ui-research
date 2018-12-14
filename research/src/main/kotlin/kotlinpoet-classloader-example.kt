import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import java.io.File
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import java.util.*
import java.util.jar.JarFile
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val android = File(args[0])

    val loader = URLClassLoader(arrayOf(android.toURL()), ClassLoader.getSystemClassLoader())

    val result = loadAndScanJar(android, loader)
    val classes = result["classes"]!!

    val filterParent = classes.first { it.name == "android.view.View" }
    val groupClass = classes.first { it.name == "android.view.ViewGroup" }

    classes
        .filter { it.name == "android.widget.Button" }
        .forEach { handleClass(it, filterParent, groupClass) }
}

private fun handleClass(clazz: Class<*>, viewClass: Class<*>, groupClass: Class<*>) {
    if (!viewClass.isAssignableFrom(clazz)) return

    val props = clazz.methods
        .filter { it.name.matches(Regex("set[A-Z].+")) }
        .filterNot { Modifier.isStatic(it.modifiers) && Modifier.isPublic(it.modifiers) }
        .filter { it.parameterCount == 1 }
    val c = ComponentDesc(
        clazz.asClassName(),
        props
            .map {
                PropertyDescription(
                    it.name,
                    it.parameters[0].type.asTypeName()
                )
            },
        groupClass.isAssignableFrom(clazz)
    )

    printComponents(listOf(c))

    exitProcess(0)
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
