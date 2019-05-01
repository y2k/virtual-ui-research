package y2k.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import y2k.android.remote.RemoteServer
import y2k.virtual.ui.VirtualHostView
import y2k.virtual.ui.frameLayout
import y2k.virtual.ui.mkNode

class RemoteDslExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = VirtualHostView(this)
        setContentView(root)

        var stage = 0
        fun update() {
            root.update { DslExampleActivity.makeStage(this, stage++) { update() } }
        }
        update()

        RemoteServer { node ->
            val s2 = mkNode {
                frameLayout {
                    children += node
                }
            }
            root.update(s2)
        }.start()
    }
}
