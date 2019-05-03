package y2k.android

import org.junit.Test
import y2k.virtual.ui.remote.HotReloadClient
import y2k.virtual.ui.runInRemote

class DslExampleActivityTest {

    @Test
    fun run() {
        runInRemote {
            val virtualNode = DslExampleActivity.view(null, 0) {}
            HotReloadClient.send(virtualNode)
        }
    }
}
