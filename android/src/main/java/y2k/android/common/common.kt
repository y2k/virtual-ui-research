package y2k.android.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper

fun timeout(delay: Long, f: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(f, delay)
}

fun Context.getDrawableByAttr(selectableItemBackground: Int): Drawable {
    val ta = obtainStyledAttributes(intArrayOf(selectableItemBackground))
    val drawableFromTheme = ta.getDrawable(0)
    ta.recycle()
    return drawableFromTheme
}
