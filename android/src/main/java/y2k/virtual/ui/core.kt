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
        update(mkNode {
            frameLayout { f() }
        })
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

    override fun toString() = "${functionRegex.find("$f")?.groupValues?.get(1)}($value)"

    companion object {
        private val functionRegex = Regex("function ([^ ]+)")
    }
}

abstract class VirtualNode : Serializable {
    lateinit var realView: View
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
            } else if (oldProp.value != newProp.value) {
                updateViewProp(view, newProp)
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
        var viewPos = 0
        for (i in 0 until Math.max(current.children.size, prevChildren.size)) {
            val p = prevChildren.getOrNull(i)
            val c = current.children.getOrNull(i)

            when {
                c == null -> view.removeViewAt(viewPos--)
                p == null -> {
                    val v = c.createEmpty(view.context)
                    log { "Add view '${v.javaClass.simpleName}'" }
                    updateRealView(v, p, c)
                    addView(c, view, v)
                }
                p.javaClass == c.javaClass ->
                    try {
                        updateRealView(p.realView, p, c)
                    } catch (e: NotRemovablePropertyException) {
                        replaceNode(view, i, c)
                    }
                else -> replaceNode(view, i, c)
            }

            viewPos++
        }
    }
}

private fun replaceNode(view: ViewGroup, i: Int, c: VirtualNode) {
    view.removeViewAt(i)
    val v = c.createEmpty(view.context)
    updateRealView(v, null, c)
    addView(c, view, v, i)
}

private fun addView(vn: VirtualNode, group: ViewGroup, view: View, i: Int? = null) {
    if (i == null) group.addView(view)
    else group.addView(view, i)
    vn.realView = view
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
