package y2k.android

import org.junit.Test
import y2k.virtual.ui.remote.HotReloadClient

class HotReloadRunners {

    @Test
    fun `run TodoList`() {
        HotReloadClient.send {
            TodoListComponent.view(
                TodoListComponent.init.copy(todos = List(5) { "Item #$it" })
            ) {}
        }
    }

    @Test
    fun `run DSL example`() {
        HotReloadClient.send {
            DslExampleComponent.view(null, 0) {}
        }
    }
}
