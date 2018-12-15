import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import java.io.File
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import java.util.jar.JarFile

fun main(args: Array<String>) {
    val android = File(args[0])

    val loader = URLClassLoader(arrayOf(android.toURI().toURL()), ClassLoader.getSystemClassLoader())
    val classes = loadAndScanJar(android, loader)

    val filterParent = classes.first { it.name == "android.view.View" }
    val groupClass = classes.first { it.name == "android.view.ViewGroup" }

    classes
        .filter { it.name in listOf("android.widget.TextView", "android.widget.Button", "android.widget.LinearLayout") }
        .forEach { handleClass(it, filterParent, groupClass) }
}

private fun handleClass(clazz: Class<*>, viewClass: Class<*>, groupClass: Class<*>) {
    if (!viewClass.isAssignableFrom(clazz)) return

    val properties = clazz
        .methods
        .filter {
            it.name.matches(Regex("set[A-Z].+"))
                    && it.parameterCount == 1
                    && Modifier.isPublic(it.modifiers)
                    && !Modifier.isStatic(it.modifiers)
                    && !it.isAnnotationPresent(Deprecated::class.java)
        }
        .map {
            PropertyDescription(
                it.name,
                it.parameters[0].type.asTypeName()
            )
        }

    val c = ComponentDesc(
        clazz.asClassName(),
        properties,
        groupClass.isAssignableFrom(clazz)
    )

    printComponents(listOf(c))
}

fun loadAndScanJar(jar: File, loader: URLClassLoader): List<Class<*>> =
    JarFile(jar)
        .entries()
        .asSequence()
        .filter { zipEntry -> zipEntry.name.endsWith(".class") }
        .mapNotNull { zipEntry ->
            val clazz = zipEntry.name
                .replace(".class", "")
                .replace("/", ".")
                .let(loader::loadClass)

            when {
                clazz.isInterface -> null
                clazz.isAnnotation -> null
                clazz.isEnum -> null
                else -> clazz
            }
        }
        .toList()
