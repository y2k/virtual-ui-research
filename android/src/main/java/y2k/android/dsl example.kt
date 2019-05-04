package y2k.android

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import y2k.android.common.getDrawableByAttr
import y2k.virtual.ui.*
import y2k.virtual.ui.remote.HotReloadServer
import java.io.Closeable

class DslExampleActivity : AppCompatActivity() {

    private lateinit var root: VirtualHostView
    private lateinit var server: Closeable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = VirtualHostView(this).also(::setContentView)

        var step = 0
        fun update() {
            root.update { view(this, step++) { update() } }
        }
        update()
    }

    override fun onResume() {
        super.onResume()
        server = HotReloadServer.start(root)
    }

    override fun onPause() {
        super.onPause()
        server.close()
    }

    companion object {

        private const val color1 = 0xFF03a5f3.toInt()
        private const val color2 = 0xFF98A098.toInt()
        private const val color3 = 0xFFFFFFFF.toInt()
        private const val color4 = 0xFF233544.toInt()

        fun view(context: Context?, step: Int, dispatch: () -> Unit): VirtualNode =
            linearLayout {
                backgroundColor = color4
                gravity = Gravity.CENTER_VERTICAL
                orientation = LinearLayout.VERTICAL

                appCompatButton {
                    textCharSequence = "AppCompat Button ($step)"
                    allCaps = false
                    textSizeFloat = 18f
                }

                editText {
                    hintCharSequence = "Enter something..."
                    hintTextColorInt = Color.LTGRAY
                    backgroundColor = Color.WHITE
                    textColorInt = Color.DKGRAY
                    textSizeFloat = 20f
                }

                textView {
                    textCharSequence = "Line #1"
                    textColorInt = color3
                    textSizeFloat = 20f
                }

                if (step == 0)
                    textView {
                        textCharSequence = "Line #2"
                        textColorInt = color3
                        textSizeFloat = 16f
                    }

                textView {
                    textCharSequence = "Line #3"
                    textColorInt = color2
                    textSizeFloat = 12f
                }

                if (step >= 2)
                    imageView {
                        scaleType = ImageView.ScaleType.FIT_CENTER
                        imageResource = android.R.drawable.ic_menu_view
                    }

                if (step >= 3)
                    textView {
                        textCharSequence = "Line #4"
                        textColorInt = color3
                        textSizeFloat = 16f
                    }

                linearLayout {
                    button {
                        background = context?.getDrawableByAttr(android.R.attr.selectableItemBackground)
                        textCharSequence = "Update UI ($step)"
                        textColorInt = color1
                        textSizeFloat = 14f
                        onClickListener = View.OnClickListener { dispatch() }
                    }

                    progressButton(context, step >= 1)
                }
            }

        private fun progressButton(context: Context?, showProgress: Boolean) =
            frameLayout {
                if (!showProgress)
                    button {
                        background = context?.getDrawableByAttr(R.attr.selectableItemBackground)
                        textCharSequence = "Progress Button"
                        textColorInt = color1
                        textSizeFloat = 14f
                    }

                if (showProgress)
                    progressBar {
                        elevation = 10f
                    }
            }
    }
}
