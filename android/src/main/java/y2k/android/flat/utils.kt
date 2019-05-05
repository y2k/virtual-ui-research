package y2k.android.flat

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import java.util.concurrent.atomic.AtomicInteger

@Suppress("unused")
fun ViewGroup.paddingLayout(all: Int = 0, f: FrameLayout.() -> Unit): FrameLayout {
    val l = FrameLayout(context)
    l.setPadding(all, all, all, all)
    l.f()
    addView(l, ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT))
    return l
}

@Suppress("unused")
fun ViewGroup.frameLayout(f: FrameLayout.() -> Unit): FrameLayout {
    val l = FrameLayout(context)
    l.f()
    addView(l, ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT))
    return l
}

fun ViewGroup.linearLayout(orientation: Int, f: LinearLayout.() -> Unit): LinearLayout {
    val l = LinearLayout(context)
    l.orientation = orientation
    l.gravity = Gravity.START or Gravity.TOP
    l.f()
    addView(l, ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT))
    return l
}

fun ViewGroup.button(title: String, f: Button.() -> Unit = {}): Button =
    Button(context).apply {
        text = title
        id = idFactory.incrementAndGet()
        f()
        addView(this, ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT))
    }

@Suppress("UNCHECKED_CAST")
fun <T : View> T.clone(): T = when (this) {
    is Button -> Button(context).also {
        it.text = text
        it.id = id + 1000
        it.minWidth = minWidth
        it.minHeight = minHeight
    } as T
    else -> TODO()
}

fun ViewGroup.children(): List<View> =
    List(childCount) { getChildAt(it) }

val idFactory = AtomicInteger()
