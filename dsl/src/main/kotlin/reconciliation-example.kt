import android.graphics.Color
import common.*
import java.lang.Math.max

fun main(args: Array<String>) {
    val container = LinearLayout()

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
    LinearLayout__().apply {
        backgroundColor.set(Color.LTGRAY)

        children += TextView__().apply {
            text.set("1) Hello World")
            textColor.set(Color.RED)
        }
        children += TextView__().apply {
            text.set("2) Moscow")
            textColor.set(Color.GREEN)
        }
    }

private fun mkState2(): LinearLayout__ =
    LinearLayout__().apply {
        backgroundColor.set(Color.LTGRAY)

        children += TextView__().apply {
            text.set("1.1) Hello World")
            textColor.set(Color.RED)
        }
    }

private fun mkState3(): LinearLayout__ =
    LinearLayout__().apply {
        backgroundColor.set(Color.LTGRAY)

        children += TextView__().apply {
            text.set("1.1) Hello World")
            textColor.set(Color.LTGRAY)
        }
        children += TextView__().apply {
            text.set("2.1) Moscow")
            textColor.set(Color.GREEN)
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
                    val v = c.createEmpty()
                    view.addView(v)
                    updateRealView(v, p, c)
                } else {
                    if (p.javaClass == c.javaClass) {
                        val v = view.getChildAt(i)
                        updateRealView(v, p, c)
                    } else {
                        view.removeViewAt(i)
                        val v = c.createEmpty()
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

class Property<T, TView : View>(var value: T, private val f: (TView, T) -> Unit) {
    fun update(view: TView) {
        f(view, value)
    }

    fun set(x: T) {
        value = x
    }
}

interface PropertyHolder {
    fun createEmpty(): View

    val props: List<Property<*, out View>>
}

interface GroupHolder {
    val children: List<PropertyHolder>
}

class LinearLayout__ : GroupHolder, PropertyHolder {
    val backgroundColor: Property<Int, LinearLayout> = Property(0, LinearLayout::setBackgroundColor)

    override val props: List<Property<out Any, LinearLayout>> =
        listOf(backgroundColor)

    override val children = ArrayList<PropertyHolder>()

    override fun createEmpty(): View = LinearLayout()
}

class TextView__ : PropertyHolder {
    val text: Property<String, TextView> = Property("", TextView::setText)
    val textSize: Property<Float, TextView> = Property(0f, TextView::setTextSize)
    val textColor: Property<Int, TextView> = Property(0, TextView::setTextColor)

    override val props: List<Property<out Any, TextView>> =
        listOf(text, textSize, textColor)

    override fun createEmpty(): View = TextView()
}
