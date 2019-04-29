package y2k.virtualuiresearch

import org.junit.Test

class Asm {

    @Test
    fun run() {
        val jars =
            Scripts.getJars("https://maven.google.com/androidx/recyclerview/recyclerview/1.0.0/recyclerview-1.0.0.pom")
        y2k.virtualuiresearch.asm.main(arrayOf(jars.first()))
    }
}
