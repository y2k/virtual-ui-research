package y2k.virtualuiresearch.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.Parameter
import java.net.URLClassLoader
import java.util.jar.JarFile

fun Parameter.asGenTypeName(): TypeName = run {
    val pt = parameterizedType
    val isGeneric = type.toGenericString().contains(Regex("<.+?>"))

    if (type === pt && isGeneric) type.asClassName().parameterizedBy(STAR)
    else parameterizedType.asTypeName()
}

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
