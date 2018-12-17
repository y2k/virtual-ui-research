package y2k.android

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import y2k.virtual.ui.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        setContentView(root)

        val s1 = stage0()
        updateRealView(root, null, s1)
    }

    private fun stage0() = mkNode {
        linearLayout {
            backgroundColor = color4
            gravity = Gravity.CENTER_VERTICAL
            orientation = LinearLayout.VERTICAL

            textView {
                text = "Line #1"
                textColor = color3
                textSize = 20f
            }

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

            imageView {
                scaleType = ImageView.ScaleType.FIT_CENTER
                imageDrawable = getDrawable(android.R.drawable.ic_menu_view)
            }

            textView {
                textColor = color3
                textSize = 16f
            }

            linearLayout {
                button {
                    background = getDrawableByAttr(android.R.attr.selectableItemBackground)
                    text = "Line #4"
                    textColor = color1
                    textSize = 14f
                }

                frameLayout {
                    button {
                        background = getDrawableByAttr(android.R.attr.selectableItemBackground)
                        text = "Line #5"
                        textColor = color1
                        textSize = 14f
                    }

                    progressBar {
                        elevation = 10f
                    }
                }
            }
        }
    }

    companion object {
        const val color1 = 0xFF03a5f3.toInt()
        const val color2 = 0xFF98A098.toInt()
        const val color3 = 0xFFFFFFFF.toInt()
        const val color4 = 0xFF233544.toInt()
    }
}

private fun Context.getDrawableByAttr(selectableItemBackground: Int): Drawable {
    val ta = obtainStyledAttributes(intArrayOf(selectableItemBackground))
    val drawableFromTheme = ta.getDrawable(0)
    ta.recycle()
    return drawableFromTheme
}
