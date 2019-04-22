import y2k.virtualuiresearch.common.printPretty
import java.util.*
import kotlin.collections.ArrayList

/*

VBox
|- TextView #1
|- TextView #2
|- HBox
|  |- TextView #3
|  |- TextView #4
|- PaddingBox
   |- HBox
      |- Button #5
      |- Button #6
      |- Button #7

CL
|- TextView #1 	(tt=parent,ss=parent)
|- TextView #2 	(tb=#1, ss=#1)
|- TextView #3 	(tb=#2, ss=#1)
|- TextView #4 	(tt=#3, se=#3)
|- Button #5 	(tb=#3, ss=#3)
|- Button #6	(tt=#5, se=#5)
|- Button #7	(tt=#5, se=#6)

*/

fun main(args: Array<String>) {
    val example = VBox(
        TTextView().apply {
            text = "Login page"
        },
        TTextView().apply {
            text = "User name"
        },
        PaddingBox(
            8,
            HBox(
                TButton().apply {
                    text = "OK"
                },
                TButton().apply {
                    text = "Cancel"
                },
                TButton().apply {
                    text = "Help"
                }
            )
        )
    )

    val cl = FakeConstraintLayout()
    test(example, cl, FakeConstraintLayoutF)
    printPretty(cl)
}

private var globalId = 1
private val decoratorStack = Stack<Group>()
private val prevViewsInGroup = Stack<Any>()

private fun <T, P, V> test(child: Any, constrainLayout: T, F: ConstraintLayoutF<T, P, V>) {
    when (child) {
        is VBox -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()

            child.children.forEach { test(it, constrainLayout, F) }

            decoratorStack.pop()
        }
        is HBox -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()

            child.children.forEach { test(it, constrainLayout, F) }

            decoratorStack.pop()
        }
        is Box -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()

            child.children.forEach { test(it, constrainLayout, F) }

            decoratorStack.pop()
        }
        is PaddingBox -> {
            prevViewsInGroup.clear()
            decoratorStack.push(child)
            prevViewsInGroup.clear()

            test(child.child, constrainLayout, F)

            decoratorStack.pop()
        }
        else -> when {
            F.isView(child) -> {
                @Suppress("UNCHECKED_CAST")
                F.setId(child as V, globalId++)
                F.addView(constrainLayout, child, makeParams(F))
                prevViewsInGroup.add(child)
            }
            else ->
                error(child.toString())
        }
    }
}

fun <T, P, V> makeParams(F: ConstraintLayoutF<T, P, V>): P {
    val totalPadding = Padding(0, 0, 0, 0)

    val lp = F.mkLayoutParams()

    for (g in decoratorStack) {
        when (g) {
            is PaddingBox -> {
                totalPadding.l += g.padding
                totalPadding.t += g.padding
                totalPadding.r += g.padding
                totalPadding.b += g.padding
            }
            is VBox -> {
                val prevView = getPrevView<V>()
                F.bindTopToBottom(lp, prevView)
                F.bindStartToStart(lp, prevView)
            }
            is HBox -> {
                val prevView = getPrevView<V>()
                F.bindTopToTop(lp, prevView)
                F.bindStartToEnd(lp, prevView)
            }
            is Box -> {
                val prevView = getPrevView<V>()
                F.bindTopToTop(lp, prevView)
                F.bindStartToStart(lp, prevView)
            }
            else -> error(g)
        }
    }

    F.setMargin(lp, totalPadding.l, totalPadding.t, totalPadding.r, totalPadding.b)

    return lp
}

@Suppress("UNCHECKED_CAST")
fun <TView> getPrevView(): TView? =
    prevViewsInGroup.lastOrNull() as TView?

open class TView {
    var id: Int = 0
}

open class TTextView : TView() {
    var text: String = ""
}

class TButton : TTextView()

typealias Child = Any

open class Group : Child()

class VBox(vararg val children: Child) : Group()

class HBox(vararg val children: Child) : Group()

class Box(vararg val children: Child) : Group()

class PaddingBox(val padding: Int, val child: Child) : Group()

interface ConstraintLayoutF<T, P, V> {
    fun isView(obj: Any): Boolean
    fun addView(constrainLayout: T, child: V, params: P)
    fun mkLayoutParams(): P
    fun setMargin(lp: P, s: Int, t: Int, e: Int, b: Int)
    fun setId(child: V, id: Int)
    fun bindTopToBottom(lp: P, prevView: V?)
    fun bindStartToStart(lp: P, prevView: V?)
    fun bindTopToTop(lp: P, prevView: V?)
    fun bindStartToEnd(lp: P, prevView: V?)
}

private class Padding(var l: Int, var t: Int, var r: Int, var b: Int)

object FakeConstraintLayoutF : ConstraintLayoutF<FakeConstraintLayout, FakeConstraintLayoutParams, TView> {

    override fun isView(obj: Any): Boolean =
        obj is TView

    override fun addView(constrainLayout: FakeConstraintLayout, child: TView, params: FakeConstraintLayoutParams) {
        constrainLayout.children += child to params
    }

    override fun mkLayoutParams(): FakeConstraintLayoutParams =
        FakeConstraintLayoutParams()

    override fun setMargin(lp: FakeConstraintLayoutParams, s: Int, t: Int, e: Int, b: Int) {
        lp.margin[0] = s
        lp.margin[1] = t
        lp.margin[2] = e
        lp.margin[3] = b
    }

    override fun setId(child: TView, id: Int) {
        child.id = id
    }

    override fun bindTopToBottom(lp: FakeConstraintLayoutParams, prevView: TView?) {
        addConstraint(prevView, lp, "top-bottom")
    }

    override fun bindStartToStart(lp: FakeConstraintLayoutParams, prevView: TView?) {
        addConstraint(prevView, lp, "start-start")
    }

    override fun bindTopToTop(lp: FakeConstraintLayoutParams, prevView: TView?) {
        addConstraint(prevView, lp, "top-top")
    }

    override fun bindStartToEnd(lp: FakeConstraintLayoutParams, prevView: TView?) {
        addConstraint(prevView, lp, "start-end")
    }

    private fun addConstraint(prevView: TView?, lp: FakeConstraintLayoutParams, c: String) {
        lp.constraints += "$c-${prevView?.id?.toString() ?: "parent"}"
    }
}

class FakeConstraintLayout {
    val children = ArrayList<Pair<Any, FakeConstraintLayoutParams>>()
}

class FakeConstraintLayoutParams {
    val constraints = ArrayList<String>()
    val margin = intArrayOf(0, 0, 0, 0)
}
