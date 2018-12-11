import android.content.Context
import android.graphics.Color
import common.*
import java.lang.Math.max
import java.util.*

fun main(args: Array<String>) {
    val container = LinearLayout(null)

    val state1 = mkState1()
    println("=================================")
    updateRealView(container, null, state1)
    println()
    printPretty(container)

    val state2 = mkState2()
    println("=================================")
    updateRealView(container, state1, state2)
    println()
    printPretty(container)

    val state3 = mkState3()
    println("=================================")
    updateRealView(container, state2, state3)
    println()
    printPretty(container)
}

private fun mkState1(): LinearLayout__ =
    linearLayout {
        backgroundColor = Color.LTGRAY

        textView {
            text = "1) Hello World"
            textColor = Color.RED
            textSize = 20f
        }
        textView {
            text = "2) Moscow"
            textColor = Color.GREEN
        }
    }

private fun mkState2(): LinearLayout__ =
    linearLayout {
        backgroundColor = Color.LTGRAY

        textView {
            text = "1.1) Hello World"
            textColor = Color.RED
            textSize = 20f
        }
    }

private fun mkState3(): LinearLayout__ =
    linearLayout {
        backgroundColor = Color.LTGRAY

        textView {
            text = "1.1) Hello World"
            textColor = Color.LTGRAY
            textSize = 10f
        }
        textView {
            text = "2.1) Moscow"
            textColor = Color.GREEN
        }
    }

// ================================================================

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

    if (current is GroupHolder) {
        view as ViewGroup

        val prevChildren = (prev as? GroupHolder)?.children ?: emptyList()
        for (i in 0 until max(current.children.size, prevChildren.size)) {
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

// ================================================================
// DSL
// ================================================================

private val stack = Stack<LinearLayout__>()

private fun textView(f: TextView__.() -> Unit) {
    val a = TextView__()
    a.f()
    stack.peek().children.add(a)
}

private fun linearLayout(f: LinearLayout__.() -> Unit): LinearLayout__ {
    val a = LinearLayout__()
    stack.add(a)
    a.f()
    stack.pop()
    return a
}

// ================================================================
// Properties
// ================================================================

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

interface GroupHolder {
    val children: List<PropertyHolder>
}

class LinearLayout__ : GroupHolder, PropertyHolder {

    var backgroundColor: Int
        get() = backgroundColor__.value
        set(value) = backgroundColor__.set(value)

    private val backgroundColor__: Property<Int, LinearLayout> = Property(0, LinearLayout::setBackgroundColor)

    override val props: List<Property<out Any, LinearLayout>> =
        listOf(backgroundColor__)

    override val children = ArrayList<PropertyHolder>()

    override fun createEmpty(context: Context?): View = LinearLayout(context)
}

class TextView__ : PropertyHolder {

    var text: String
        get() = throw IllegalStateException()
        set(value) = text_.set(value)
    var textColor: Int
        get() = throw IllegalStateException()
        set(value) = textColor_.set(value)
    var textSize: Float
        get() = throw IllegalStateException()
        set(value) = textSize_.set(value)

    private val text_: Property<String, TextView> = Property("", TextView::setText)
    private val textSize_: Property<Float, TextView> = Property(0f, TextView::setTextSize)
    private val textColor_: Property<Int, TextView> = Property(0, TextView::setTextColor)

    override val props: List<Property<out Any, TextView>> =
        listOf(text_, textSize_, textColor_)

    override fun createEmpty(context: Context?): View = TextView(context)
}
