package y2k.virtual.ui.common

import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import y2k.virtual.ui.LinearLayout_
import y2k.virtual.ui.View_
import y2k.virtual.ui.VirtualNode
import y2k.virtual.ui.frameLayout

@Suppress("unused")
fun LinearLayout_.fillHorizontal(f: () -> View_) {
    val node = f()
    node.layoutParams =
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            1f)
}

fun border(all: Int, f: () -> View_): VirtualNode =
    frameLayout {
        f().layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT).apply {
            topMargin = all
            bottomMargin = all
            leftMargin = all
            rightMargin = all
        }
    }
