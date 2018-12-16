@file:Suppress("ClassName")

package y2k.virtual.ui

import android.content.Context
import common.View
import common.ViewGroup
import java.util.*

val globalViewStack = Stack<ChildrenHolder>()

abstract class ChildrenHolder {
    val children = ArrayList<PropertyHolder>()
}

class Property<T, TView : View>(var value: T, private val f: (TView, T) -> Unit) {
    fun update(view: TView) {
        f(view, value)
    }

    fun set(x: T) {
        value = x
    }
}

interface PropertyHolder {
    fun createEmpty(context: Context?): View

    val props: List<Property<*, out View>>
}

fun updateRealView(view: View, prev: PropertyHolder?, current: PropertyHolder) {
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

    if (current is ChildrenHolder) {
        view as ViewGroup

        val prevChildren = (prev as? ChildrenHolder)?.children ?: emptyList<PropertyHolder>()
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
