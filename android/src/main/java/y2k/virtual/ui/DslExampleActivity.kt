package y2k.virtual.ui

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import y2k.android.common.timeout

class DslExampleActivity : Activity() {

    private val content by lazy { LinearLayout(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(content)

        val node =
            mkNode {
                linearLayout {
                    orientation = LinearLayout.VERTICAL

                    button { text = "Hello" }
                    button { text = "World" }
                }
            }
        updateRealView(content, null, node)

        timeout(1000L) {
            updateRealView(content, node, mkNode {
                linearLayout {
                    orientation = LinearLayout.VERTICAL

                    button { text = "Hello" }
                    button { text = "123" }
                    button { text = "World" }
                }
            })
        }
    }
}
