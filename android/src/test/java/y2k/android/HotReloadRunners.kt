package y2k.android

import org.junit.Test
import y2k.virtual.ui.remote.HotReloadClient
import y2k.virtual.ui.runInRemote

class HotReloadRunners {

    @Test
    fun `run TodoList`() {
        val model = TodoListComponent.init.copy(todos = List(5) { "Item #$it" })

        runInRemote {
            val virtualNode = TodoListComponent.view(model) {}
            HotReloadClient.send(virtualNode)
        }
    }

    @Test
    fun `run DSL example`() {
        runInRemote {
            val virtualNode = DslExampleActivity.view(null, 0) {}
            HotReloadClient.send(virtualNode)
        }
    }
}
