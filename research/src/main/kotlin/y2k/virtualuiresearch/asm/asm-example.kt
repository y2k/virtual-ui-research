package y2k.virtualuiresearch.asm

import org.objectweb.asm.*
import java.io.File
import java.io.InputStream
import java.util.jar.JarFile

data class ClassRecord(val clazz: String, val method: String)

fun findOrNonNullMethods(jars: List<File>): Set<ClassRecord> {
    val nonNullMethods = HashSet<ClassRecord>()

    jars.forEach {
        loadAndScanJar(it, nonNullMethods)
    }

    return nonNullMethods
}

private fun loadAndScanJar(jarFile: File, nonNullMethods: HashSet<ClassRecord>) {
    JarFile(jarFile).use { jar ->
        jar.entries().asSequence().forEach { zipEntry ->
            if (zipEntry.name.endsWith(".class") && zipEntry.name != "java/lang/Object.class") {
                jar.getInputStream(zipEntry)
                    .use {
                        visitClassFile(it, nonNullMethods)
                    }
            }
        }
    }
}

private fun visitClassFile(inputStream: InputStream, nonNullMethods: HashSet<ClassRecord>) {
    val cr = ClassReader(inputStream)

    cr.accept(object : ClassVisitor(Opcodes.ASM6) {

        private var skip = false
        private var lastClassName = ""

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
//            if (".widget." !in superName.toClsName()) return
            skip = false

            lastClassName = name.toClsName()
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

            return object :
                MethodVisitor(Opcodes.ASM6, super.visitMethod(access, name, descriptor, signature, exceptions)) {

                override fun visitParameterAnnotation(
                    parameter: Int,
                    descriptor: String,
                    visible: Boolean
                ): AnnotationVisitor? {

                    if ("androidx.annotation.NonNull" in descriptor.toClsName()) {
                        nonNullMethods += ClassRecord(lastClassName, name)
                    }

                    return super.visitParameterAnnotation(parameter, descriptor, visible)
                }
            }
        }

        private fun String.toClsName() = replace('/', '.')

    }, ClassReader.SKIP_DEBUG)
}
