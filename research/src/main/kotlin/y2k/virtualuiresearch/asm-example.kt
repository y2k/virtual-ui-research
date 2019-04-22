package y2k.virtualuiresearch

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import java.io.File
import java.io.InputStream
import java.util.*
import java.util.jar.JarFile

fun main(args: Array<String>) {
    val file = File(args[0])
    loadAndScanJar(file)
}

private fun visitClassFile(inputStream: InputStream) {
    val cr = ClassReader(inputStream)
    cr.accept(object : ClassVisitor(Opcodes.ASM6) {

        private var skip = false

        override fun visit(
            version: Int,
            access: Int,
            name: String,
            signature: String?,
            superName: String,
            interfaces: Array<String>
        ) {
            super.visit(version, access, name, signature, superName, interfaces)

            skip = true
            if (name.contains('$')) return
            if (access.and(Opcodes.ACC_PUBLIC) == 0) return
            if (superName.toClsName() == "java.lang.Object") return
            if (".widget." !in superName.toClsName()) return
            skip = false

            println(
                """
                    ${name.toClsName()} : ${superName.toClsName()}
                    """.trimIndent()
            )
        }

        override fun visitMethod(
            access: Int,
            name: String,
            descriptor: String?,
            signature: String?,
            exceptions: Array<out String>?
        ): MethodVisitor? {
            if (skip) return null
            if (!name.matches(Regex("set[A-Z].+"))) return null

            println("\t$name")

            return super.visitMethod(access, name, descriptor, signature, exceptions)
        }

        private fun String.toClsName() = replace('/', '.')

    }, ClassReader.SKIP_DEBUG)
}

private fun loadAndScanJar(jarFile: File) {
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

            jar.getInputStream(zipEntry)
                .use(::visitClassFile)
        }
    }
}
