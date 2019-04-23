package y2k.virtualuiresearch

import org.junit.Test
import java.io.File
import java.lang.System
import java.net.URL
import java.util.zip.ZipFile

class Scripts {

    // https://maven.google.com/com/google/android/material/material/1.0.0/material-1.0.0.aar
    // https://maven.google.com/com/google/android/material/material/1.0.0/material-1.0.0.pom
    @Test
    fun `Create DSL for material`() {
    }

    /*
        $HOME/Projects/virtual-ui-research/appcompat.jar
        $HOME/.gradle/caches/modules-2/files-2.1/androidx.annotation/annotation/1.0.0/45599f2cd5965ac05a1488fa2a5c0cdd7c499ead/annotation-1.0.0.jar
        $HOME/.gradle/caches/transforms-2/files-2.1/794ad516abb34dbce43d23b8f3a3de56/jars/classes.jar
        $HOME/.gradle/caches/transforms-2/files-2.1/b64d32257b9cb843e7388a5b226995b0/jars/classes.jar
        $HOME/Projects/virtual-ui-research/collection-1.0.0.jar
        $HOME/Projects/virtual-ui-research/lifecycle-viewmodel.jar
        $HOME/Projects/virtual-ui-research/lifecycle-common-2.0.0.jar
        $HOME/Projects/virtual-ui-research/fragment.jar
        $HOME/Projects/virtual-ui-research/drawerlayout.jar
        $HOME/Projects/virtual-ui-research/core.jar
        $HOME/Library/Android/sdk/platforms/android-22/android.jar
    */
    @Test
    fun `Create DSL AppCompat`() {
        val jars = listOf(
            downloadAar("https://maven.google.com/androidx/appcompat/appcompat/1.0.2/appcompat-1.0.2.aar"),
            downloadJar("https://maven.google.com/androidx/annotation/annotation/1.0.0/annotation-1.0.0.jar"),
            downloadAar("https://maven.google.com/androidx/customview/customview/1.0.0/customview-1.0.0.aar"),
            downloadAar("https://maven.google.com/androidx/cursoradapter/cursoradapter/1.0.0/cursoradapter-1.0.0.aar"),
            downloadJar("https://maven.google.com/androidx/collection/collection/1.0.0/collection-1.0.0.jar"),
            downloadAar("https://maven.google.com/androidx/lifecycle/lifecycle-viewmodel/2.0.0/lifecycle-viewmodel-2.0.0.aar"),
            downloadJar("https://maven.google.com/androidx/lifecycle/lifecycle-common/2.0.0/lifecycle-common-2.0.0.jar"),
            downloadAar("https://maven.google.com/androidx/fragment/fragment/1.0.0/fragment-1.0.0.aar"),
            downloadAar("https://maven.google.com/androidx/drawerlayout/drawerlayout/1.0.0/drawerlayout-1.0.0.aar"),
            downloadAar("https://maven.google.com/androidx/core/core/1.0.1/core-1.0.1.aar"),
            downloadJar("https://github.com/sourcegraph/android-sdk-jars/raw/master/platforms/android-22/android.jar")
        )

        val code = execute("androidx.appcompat.widget.", jars.first(), jars.last(), jars.toTypedArray())
        File("../android/src/main/java/y2k/virtual/ui/appcompat.generated.kt").writeText(code)
    }

    @Test
    fun `Create DSL`() {
        val jarPath =
            downloadJar("https://github.com/sourcegraph/android-sdk-jars/raw/master/platforms/android-22/android.jar")
        val code = execute(null, null, jarPath, arrayOf(jarPath))
        File("../android/src/main/java/y2k/virtual/ui/android.generated.kt").writeText(code)
    }

    private fun downloadAar(url: String): String {
        val file = File(
            System.getProperty("java.io.tmpdir"),
            "virtual-ui-" + (Long.MAX_VALUE / 2 + url.hashCode()) + ".jar"
        )
        if (file.exists()) return file.absolutePath

        val aar = downloadToTemp(url, "virtual-ui-" + (Long.MAX_VALUE / 2 + url.hashCode()) + ".aar.zip")

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
        downloadToTemp(url, "virtual-ui-" + (Long.MAX_VALUE / 2 + url.hashCode()) + ".jar").absolutePath

    private fun downloadToTemp(url: String, name: String): File {
        val file = File(System.getProperty("java.io.tmpdir"), name)

        if (!file.exists() || file.length() <= 0) {
            val tmp = File.createTempFile("___", null)
            URL(url).openStream().use { it.copyTo(tmp.outputStream()) }
            tmp.renameTo(file)
        }

        return file
    }
}
