import common.printPretty
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
    val cl = FakeConstraintLayout()
    test(mkExample(), cl, FakeConstraintLayoutF)

    printPretty(cl)
}

private var globalId = 1
private val decoratorStack = Stack<Group>()
private val prevViewsInGroup = Stack<TView>()

private fun <Child, T, P> test(child: Child, constrainLayout: T, F: ConstraintLayoutF<T, P>) {
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
        }
        is TView -> {
            F.setId(child, globalId++)
            F.addView(constrainLayout, child, makeParams(F))
            prevViewsInGroup.add(child)
        }
        else -> error(child.toString())
    }
}

fun <T, P> makeParams(F: ConstraintLayoutF<T, P>): P {
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
                val prevView = getPrevView()
                F.bindTopToBottom(lp, prevView)
                F.bindStartToStart(lp, prevView)
            }
            is HBox -> {
                val prevView = getPrevView()
                F.bindTopToTop(lp, prevView)
                F.bindStartToEnd(lp, prevView)
            }
            is Box -> {
                val prevView = getPrevView()
                F.bindTopToTop(lp, prevView)
                F.bindStartToStart(lp, prevView)
            }
            else -> error(g)
        }
    }

    F.setMargin(lp, totalPadding.l, totalPadding.t, totalPadding.r, totalPadding.b)

    return lp
}

fun getPrevView(): TView? =
    prevViewsInGroup.lastOrNull()

private fun mkExample(): Group =
    VBox(
        TTextView().apply {
            text = "Login page"
        },
        PaddingBox(
            8,
            HBox(
                TButton().apply {
                    text = "OK"
                },
                TButton().apply {
                    text = "Cancel"
                }
            )
        )
    )

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

interface ConstraintLayoutF<T, P> {
    fun addView(constrainLayout: T, child: Any, params: P)
    fun mkLayoutParams(): P
    fun setMargin(lp: P, s: Int, t: Int, e: Int, b: Int)
    fun setId(child: TView, id: Int)
    fun bindTopToBottom(lp: P, prevView: TView?)
    fun bindStartToStart(lp: P, prevView: TView?)
    fun bindTopToTop(lp: P, prevView: TView?)
    fun bindStartToEnd(lp: P, prevView: TView?)
}

private class Padding(var l: Int, var t: Int, var r: Int, var b: Int)

object FakeConstraintLayoutF : ConstraintLayoutF<FakeConstraintLayout, FakeConstraintLayoutParams> {

    override fun addView(constrainLayout: FakeConstraintLayout, child: Any, params: FakeConstraintLayoutParams) {
        constrainLayout.children += child to params
    }

    override fun mkLayoutParams(): FakeConstraintLayoutParams =
        FakeConstraintLayoutParams()

    override fun setMargin(lp: FakeConstraintLayoutParams, s: Int, t: Int, e: Int, b: Int) {
        lp.startMargin = s
        lp.topMargin = t
        lp.endMargin = e
        lp.bottomMargin = b
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
    var startMargin: Int = 0
    var topMargin: Int = 0
    var endMargin: Int = 0
    var bottomMargin: Int = 0
}
