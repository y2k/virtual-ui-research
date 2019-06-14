@file:Suppress("ClassName")

package y2k.virtual.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import y2k.android.BuildConfig
import java.io.Serializable
import java.util.*

@DslMarker
annotation class VirtualNodeMarker

data class Quadruple<T1, T2, T3, T4>(val first: T1, val second: T2, val third: T3, val fourth: T4) : Serializable

class VirtualHostView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var prevNode: VirtualNode? = null

    fun update(f: () -> Unit) {
        val s2 = mkNode {
            frameLayout {
                f()
            }
        }
        updateRealView(this, prevNode, s2)
        prevNode = s2
    }

    fun update(node: VirtualNode) {
        updateRealView(this, prevNode, node)
        prevNode = node
    }
}

fun mkNode(f: () -> Unit): VirtualNode {
    globalViewStack += object : VirtualNode() {
        override fun clear(p: Property, a: View): Unit = throw IllegalStateException()
        override fun update(p: Property, a: View): Unit = throw IllegalStateException()
        override fun createEmpty(context: Context): View = throw IllegalStateException()
    }

    f()

    return globalViewStack.pop().children.first()
}

val isRemote = ThreadLocal<Unit>()

fun runInRemote(f: () -> Unit) {
    try {
        isRemote.set(Unit)
        f()
    } finally {
        isRemote.remove()
    }
}

fun VirtualNode.updateProp(isRemoteReady: Boolean, propId: Int, value: Any?) {
    if (isRemote.get() != null && !isRemoteReady) return
    props += Property(propId, value)
}

val globalViewStack = Stack<VirtualNode>()

class NotRemovablePropertyException : Exception()

class Property(
    val propId: Int,
    var value: Any?
) : Serializable

abstract class VirtualNode : Serializable {

    open fun clear(p: Property, a: View): Unit = throw NotRemovablePropertyException()
    open fun update(p: Property, a: View): Unit = throw IllegalStateException("$p $a")

    val children = ArrayList<VirtualNode>()

    val props = ArrayList<Property>()

    abstract fun createEmpty(context: Context): View
}

fun updateRealView(view: View, prev: VirtualNode?, current: VirtualNode) {
    if (prev == null) {
        current.props.forEach { p ->
            current.update(p, view)
        }
    } else {
        prev.props.forEach { oldProp ->
            val newProp = current.props.find { it.propId == oldProp.propId }
            if (newProp == null) {
                prev.clear(oldProp, view)
            } else {
                if (oldProp.value != newProp.value) {
                    current.update(newProp, view)
                }
            }
        }
        current.props.forEach { newProp ->
            if (prev.props.none { it.propId == newProp.propId }) {
                current.update(newProp, view)
            }
        }
    }

    if (view is ViewGroup) {
        val prevChildren = prev?.children ?: emptyList<VirtualNode>()
        var viewPos = 0
        for (i in 0 until Math.max(current.children.size, prevChildren.size)) {
            val p = prevChildren.getOrNull(i)
            val c = current.children.getOrNull(i)

            if (c == null) {
                view.removeViewAt(viewPos--)
            } else {
                if (p == null) {
                    val v = c.createEmpty(view.context)
                    log { "Add view '${v.javaClass.simpleName}'" }
                    view.addView(v)
                    try {
                        updateRealView(v, p, c)
                    } catch (e: NotRemovablePropertyException) {
                        throw IllegalStateException()
                    }
                } else {
                    if (p.javaClass == c.javaClass) {
                        try {
                            updateRealView(view.getChildAt(i), p, c)
                        } catch (e: NotRemovablePropertyException) {
                            replaceNode(view, i, c)
                        }
                    } else {
                        replaceNode(view, i, c)
                    }
                }
            }

            viewPos++
        }
    }
}

private fun replaceNode(view: ViewGroup, i: Int, c: VirtualNode) {
    view.removeViewAt(i)
    val v = c.createEmpty(view.context)
    view.addView(v, i)
    updateRealView(v, null, c)
}

private inline fun log(f: () -> String) {
    if (BuildConfig.DEBUG) Log.i("VirtualUi", f())
}
