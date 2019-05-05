package y2k.android.common

import android.content.Context
import android.graphics.drawable.Drawable

fun Context.getDrawableByAttr(selectableItemBackground: Int): Drawable? {
    val ta = obtainStyledAttributes(intArrayOf(selectableItemBackground))
    val drawableFromTheme = ta.getDrawable(0)
    ta.recycle()
    return drawableFromTheme
}
