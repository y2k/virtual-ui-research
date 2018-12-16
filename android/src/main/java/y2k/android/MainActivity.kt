package y2k.android

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import y2k.virtual.ui.linearLayout
import y2k.virtual.ui.mkNode
import y2k.virtual.ui.textView
import y2k.virtual.ui.updateRealView
import java.lang.Thread.sleep

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        setContentView(root)

        val s1 = stage1()
        updateRealView(root, null, s1)
        sleep(500)
        updateRealView(root, s1, stage2())
    }

    private fun stage1() = mkNode {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL

            textView {
                textSize = 20f
                text = "Line #1"
            }
            textView {
                textSize = 20f
                text = "Line #2"
            }
        }
    }

    private fun stage2() = mkNode {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL

            textView {
                textSize = 20f
                text = "Line #1"
            }
            textView {
                textSize = 20f
                text = "Line #2"
            }
            textView {
                textSize = 20f
                text = "Line #3"
            }
        }
    }
}
