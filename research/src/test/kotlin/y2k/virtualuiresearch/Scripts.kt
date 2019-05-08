package y2k.virtualuiresearch

import org.jsoup.parser.Parser
import org.junit.Test
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import y2k.virtualuiresearch.asm.findOrNonNullMethods
import java.io.File
import java.net.URL
import java.util.zip.ZipFile

class Scripts {

    @Test
    fun `Create DSL for RecyclerView`() {
        val jars = getJars("https://maven.google.com/androidx/recyclerview/recyclerview/1.0.0/recyclerview-1.0.0.pom")
        val nonNullMethods = findOrNonNullMethods(jars.map(::File))

        val code =
            execute("androidx.recyclerview.widget.", jars.first(), jars.last(), jars.toTypedArray(), nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/recyclerview.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL for CoordinatorLayout`() {
        val jars =
            getJars("https://maven.google.com/androidx/coordinatorlayout/coordinatorlayout/1.0.0/coordinatorlayout-1.0.0.pom")
        val nonNullMethods = findOrNonNullMethods(jars.map(::File))

        val code = execute(
            "androidx.coordinatorlayout.widget.",
            jars.first(),
            jars.last(),
            jars.toTypedArray(),
            nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/coordinatorlayout.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL for CardView`() {
        val jars = getJars("https://maven.google.com/androidx/cardview/cardview/1.0.0/cardview-1.0.0.pom")
        val nonNullMethods = findOrNonNullMethods(jars.map(::File))

        val code = execute("androidx.cardview.widget.", jars.first(), jars.last(), jars.toTypedArray(), nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/cardview.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL for Material`() {
        val jars = getJars("https://maven.google.com/com/google/android/material/material/1.0.0/material-1.0.0.pom")
        val nonNullMethods = findOrNonNullMethods(jars.map(::File))

        val code =
            execute("com.google.android.material.", jars.first(), jars.last(), jars.toTypedArray(), nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/material.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL for AppCompat`() {
        val jars = getJars("https://maven.google.com/androidx/appcompat/appcompat/1.0.2/appcompat-1.0.2.pom")
        val nonNullMethods = findOrNonNullMethods(jars.map(::File))

        val code = execute("androidx.appcompat.widget.", jars.first(), jars.last(), jars.toTypedArray(), nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/appcompat.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL for Android`() {
        val jarPath =
            downloadJar("https://github.com/sourcegraph/android-sdk-jars/raw/master/platforms/android-22/android.jar")
        val nonNullMethods = findOrNonNullMethods(listOf(File(jarPath)))

        val code = execute(null, null, jarPath, arrayOf(jarPath), nonNullMethods)
        File("../android/src/main/java/y2k/virtual/ui/android.generated.kt").writeText(code)
    }

    companion object {

        fun getJars(startPomUrl: String): List<String> {
            val computedUrls = HashSet<String>()
            val jars = ArrayList<String>()

            fun downloadPom(pomUrl: String) {
                if (computedUrls.contains(pomUrl)) return
                computedUrls += pomUrl

                val pom = Parser.xmlParser().parseInput(downloadToTemp(pomUrl, ".pom").readText(), pomUrl)

                val type = pom.selectFirst("project > packaging")?.text() ?: "jar"
                val artUrl = pomUrl.replace(".pom", ".$type")

                jars += if (type == "aar") downloadAar(artUrl) else downloadJar(artUrl)

                pom.select("dependency > scope:contains(compile)")
                    .map { it.parent() }
                    .forEach { dep ->
                        val groupId = dep.children().first { it.tagName() == "groupId" }.text().replace('.', '/')
                        val artifactId = dep.children().first { it.tagName() == "artifactId" }.text()
                        val version = dep.children().first { it.tagName() == "version" }.text()
                        downloadPom("https://maven.google.com/$groupId/$artifactId/$version/$artifactId-$version.pom")
                    }
            }

            downloadPom(startPomUrl)
            jars += downloadJar("https://github.com/sourcegraph/android-sdk-jars/raw/master/platforms/android-24/android.jar")
            return jars
        }

        private fun downloadAar(url: String): String {
            val file = File(
                System.getProperty("java.io.tmpdir"),
                "virtual-ui-" + (Long.MAX_VALUE / 2 + url.hashCode()) + ".jar"
            )
            if (file.exists()) return file.absolutePath

            val aar = downloadToTemp(url, ".aar.zip")

            ZipFile(aar).use { zipFile ->
                val e = zipFile
                    .entries().asSequence()
                    .first { it.name == "classes.jar" }
                zipFile.getInputStream(e).use { input ->
                    file.outputStream().use { input.copyTo(it) }
                }
            }

            return file.absolutePath
        }

        private fun downloadJar(url: String): String =
            downloadToTemp(url, ".jar").absolutePath

        private fun downloadToTemp(url: String, ext: String): File {
            val file = File(
                System.getProperty("java.io.tmpdir"),
                "virtual-ui-${Long.MAX_VALUE / 2 + url.hashCode()}$ext")
            if (!file.exists() || file.length() <= 0) {
                val tmp = File.createTempFile("___", null)
                URL(url).openStream().use { it.copyTo(tmp.outputStream()) }
                tmp.renameTo(file)
            }
            return file
        }

        private fun NodeList.toList() = List(length, this::item)

        operator fun Node.get(name: String): Node =
            childNodes.toList().first { it.localName == name }
    }
}
