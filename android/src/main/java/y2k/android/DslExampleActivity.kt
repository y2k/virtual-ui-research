package y2k.android

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import y2k.android.common.getDrawableByAttr
import y2k.virtual.ui.*

class DslExampleActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = VirtualHostView(this)
        setContentView(root)

        var stage = 0
        fun update() {
            root.update { makeStage(stage++) { update() } }
        }
        update()
    }

    private fun makeStage(stage: Int, dispatch: () -> Unit) =
        linearLayout {
            backgroundColor = color4
            gravity = Gravity.CENTER_VERTICAL
            orientation = LinearLayout.VERTICAL

            textView {
                text = "Line #1"
                textColor = color3
                textSize = 20f
            }

            if (stage >= 1)
                textView {
                    text = "Line #2"
                    textColor = color3
                    textSize = 16f
                }

            textView {
                text = "Line #3"
                textColor = color2
                textSize = 12f
            }

            if (stage >= 2)
                imageView {
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    imageDrawable = getDrawable(android.R.drawable.ic_menu_view)!!
                }

            if (stage >= 3)
                textView {
                    text = "Line #4"
                    textColor = color3
                    textSize = 16f
                }

            linearLayout {
                button {
                    background = getDrawableByAttr(android.R.attr.selectableItemBackground)
                    text = "Line #4 ($stage)"
                    textColor = color1
                    textSize = 14f
                    onClickListener = View.OnClickListener { dispatch() }
                }

                customButton(stage >= 1)
            }
        }

    private fun customButton(showProgress: Boolean) =
        frameLayout {
            if (!showProgress)
                button {
                    background = getDrawableByAttr(android.R.attr.selectableItemBackground)
                    text = "Line #5"
                    textColor = color1
                    textSize = 14f
                }

            if (showProgress)
                progressBar {
                    elevation = 10f
                }
        }

    companion object {
        const val color1 = 0xFF03a5f3.toInt()
        const val color2 = 0xFF98A098.toInt()
        const val color3 = 0xFFFFFFFF.toInt()
        const val color4 = 0xFF233544.toInt()
    }
}
