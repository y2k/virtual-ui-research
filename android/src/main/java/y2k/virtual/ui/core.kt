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
        override fun createEmpty(context: Context): View = throw IllegalStateException()
    }

    f()

    return globalViewStack.pop().children.first()
}

private val isRemote = ThreadLocal<Unit>()

fun runInRemote(f: () -> Unit) {
    try {
        isRemote.set(Unit)
        f()
    } finally {
        isRemote.remove()
    }
}

fun <T> VirtualNode.updateProp(value: T, property: Property<T, *>) {
    if (isRemote.get() != null && !property.isRemoteReady) return

    property.set(value)
    props += property
}

val globalViewStack = Stack<VirtualNode>()

class NotRemovablePropertyException : Exception()

class Property<T, TView : View>(
    val isRemoteReady: Boolean,
    val name: String,
    var value: T?,
    private val f: (TView, T) -> Any
) : Serializable {

    private val default = value

    fun clear(view: TView) {
        f(view, default ?: throw NotRemovablePropertyException())
    }

    fun update(view: TView) {
        f(view, value!!)
    }

    fun set(x: T) {
        value = x
    }

    override fun toString() = "${functionRegex.find("$f")!!.groupValues[1]}($value)"

    companion object {
        private val functionRegex = Regex("function ([^ ]+)")
    }
}

abstract class VirtualNode : Serializable {

    val children = ArrayList<VirtualNode>()

    val props = ArrayList<Property<*, out View>>()

    abstract fun createEmpty(context: Context): View
}

fun updateRealView(view: View, prev: VirtualNode?, current: VirtualNode) {
    if (prev == null) {
        current.props.forEach { p -> updateViewProp(view, p) }
    } else {
        prev.props.forEach { oldProp ->
            val newProp = current.props.find { it.name == oldProp.name }
            if (newProp == null) {
                clearViewProp(view, oldProp)
            } else {
                if (oldProp.value != newProp.value) {
                    updateViewProp(view, newProp)
                }
            }
        }
        current.props.forEach { newProp ->
            if (prev.props.none { it.name == newProp.name }) {
                updateViewProp(view, newProp)
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
                            replaceNode(view, i, c, p)
                        }
                    } else {
                        replaceNode(view, i, c, p)
                    }
                }
            }
        }
    }
}

private fun replaceNode(
    view: ViewGroup,
    i: Int,
    c: VirtualNode,
    p: VirtualNode?
) {
    view.removeViewAt(i)
    val v = c.createEmpty(view.context)
    view.addView(v, i)
    updateRealView(v, null, c)
}

@Suppress("UNCHECKED_CAST")
fun updateViewProp(view: View, c: Property<*, out View>) {
    log { "Update: ${view.javaClass.simpleName}.$c" }

    val a = c as Property<*, View>
    a.update(view)
}

@Suppress("UNCHECKED_CAST")
fun clearViewProp(view: View, c: Property<*, out View>) {
    log { "Clear: ${view.javaClass.simpleName}.$c" }

    val a = c as Property<*, View>
    a.clear(view)
}

private inline fun log(f: () -> String) {
    if (BuildConfig.DEBUG) Log.i("VirtualUi", f())
}
