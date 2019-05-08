package y2k.android.common

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import com.facebook.soloader.SoLoader

fun Context.getDrawableByAttr(selectableItemBackground: Int): Drawable? {
    val ta = obtainStyledAttributes(intArrayOf(selectableItemBackground))
    val drawableFromTheme = ta.getDrawable(0)
    ta.recycle()
    return drawableFromTheme
}

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)
    }
}
