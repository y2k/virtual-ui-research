package y2k.virtualuiresearch

import org.junit.Assert
import org.junit.Test
import y2k.virtualuiresearch.asm.ClassRecord
import y2k.virtualuiresearch.asm.findOrNonNullMethods
import java.io.File

class Asm {

    @Test
    fun run() {
        val jars =
            Scripts.getJars("https://maven.google.com/androidx/recyclerview/recyclerview/1.0.0/recyclerview-1.0.0.pom")

        val actual = findOrNonNullMethods(jars.map(::File))

        val expected = setOf(
            ClassRecord("androidx.drawerlayout.widget.DrawerLayout", "setDrawerLockMode"),
            ClassRecord("androidx.core.app.ActivityCompat", "setExitSharedElementCallback"),
            ClassRecord("androidx.recyclerview.widget.DividerItemDecoration", "setDrawable"),
            ClassRecord("androidx.loader.content.CursorLoader", "setUri"),
            ClassRecord("androidx.recyclerview.widget.RecyclerView", "setEdgeEffectFactory"),
            ClassRecord("androidx.core.app.ActivityCompat", "setEnterSharedElementCallback"),
            ClassRecord("androidx.core.graphics.drawable.RoundedBitmapDrawable", "setTargetDensity"),
            ClassRecord("androidx.swiperefreshlayout.widget.CircularProgressDrawable", "setStrokeCap"),
            ClassRecord("androidx.swiperefreshlayout.widget.CircularProgressDrawable", "setColorSchemeColors"))

        Assert.assertEquals(expected, actual)
    }
}
