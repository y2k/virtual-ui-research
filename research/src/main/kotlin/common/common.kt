package common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName
import java.io.File
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import java.util.jar.JarFile

fun loadAllClassesFromJar(jar: File, loader: URLClassLoader): List<Class<*>> =
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
        .filter { Modifier.isPublic(it.modifiers) }
        .toList()

fun Method.isOverrided(): Boolean {
    fun isOverrided(method: Method, clazz: Class<*>): Boolean {
        val base = clazz.superclass ?: return false
        return base.declaredMethods.any { it.name == method.name } || isOverrided(method, base)
    }
    return isOverrided(this, declaringClass)
}

val TypeName.simpleName: String
    get() = when (this) {
        is ClassName -> simpleName
        is ParameterizedTypeName -> rawType.simpleName
        else -> throw IllegalStateException("$this")
    }

val TypeName.canonicalName: String
    get() = when (this) {
        is ClassName -> canonicalName
        is ParameterizedTypeName -> rawType.canonicalName
        else -> throw IllegalStateException("$this")
    }
