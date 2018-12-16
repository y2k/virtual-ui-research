@file:Suppress("ClassName")

package y2k.virtual.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import java.util.*

val globalViewStack = Stack<VirtualNode>()

class Property<T, TView : View>(var value: T, private val f: (TView, T) -> Unit) {
    fun update(view: TView) {
        f(view, value)
    }

    fun set(x: T) {
        value = x
    }
}

abstract class VirtualNode {

    val children = ArrayList<VirtualNode>()

    val props = ArrayList<Property<*, out View>>()

    abstract fun createEmpty(context: Context): View
}

fun updateRealView(view: View, prev: VirtualNode?, current: VirtualNode) {
    if (prev == null) {
        current.props.forEach { p -> updateViewProp(view, p) }
    } else {
        prev.props
            .zip(current.props)
            .forEach { (p, c) ->
                if (p.value != c.value) {
                    updateViewProp(view, c)
                }
            }
    }

    if (view is ViewGroup) {
        val prevChildren = prev?.children ?: emptyList<VirtualNode>()
        for (i in 0 until Math.max(current.children.size, prevChildren.size)) {
            val p = prevChildren.getOrNull(i)
            val c = current.children.getOrNull(i)

            if (c == null) {
                view.removeViewAt(i)
            } else {
                if (p == null) {
                    val v = c.createEmpty(view.context)
                    view.addView(v)
                    updateRealView(v, p, c)
                } else {
                    if (p.javaClass == c.javaClass) {
                        val v = view.getChildAt(i)
                        updateRealView(v, p, c)
                    } else {
                        view.removeViewAt(i)
                        val v = c.createEmpty(view.context)
                        view.addView(v, i)
                        updateRealView(v, p, c)
                    }
                }
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun updateViewProp(root: View, c: Property<*, out View>) {
    val a = c as Property<*, View>
    a.update(root)
}
