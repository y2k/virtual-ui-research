import java.util.*

fun main(args: Array<String>) {
    TODO()
}

private var globalId = 1
private val decoratorStack = Stack<Group>()
private val prevViewsInGroup = Stack<TView>()

private fun <Child, T, P> test(child: Child, constrainLayout: T, F: ConstraintLayoutF<T, P>) {
    when (child) {
        is VBox -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()
        }
        is HBox -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()
        }
        is Box -> {
            decoratorStack.push(child)
            prevViewsInGroup.clear()
        }
        is PaddingBox -> {
            prevViewsInGroup.clear()
            decoratorStack.push(child)
            prevViewsInGroup.clear()
        }
        is TView -> {
            F.addView(constrainLayout, child, makeParams(F))
            prevViewsInGroup.add(child)
        }
        else -> error(child.toString())
    }
}

fun <T, P> makeParams(F: ConstraintLayoutF<T, P>): P {

    val totalPadding = Padding(0, 0, 0, 0)

    for (g in decoratorStack) {
        when (g) {
            is PaddingBox -> {
                totalPadding.l += g.padding
                totalPadding.t += g.padding
                totalPadding.r += g.padding
                totalPadding.b += g.padding
            }
            else -> TODO()
        }
    }

    val lp = F.mkLayoutParams()
    F.setPadding(lp, totalPadding.l, totalPadding.t, totalPadding.r, totalPadding.b)

    TODO()
}

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

open class TView

open class TTextView : TView() {
    var text: String = ""
}

class TButton : TTextView()

typealias Child = Any

open class Group : Child()

class VBox(vararg children: Child) : Group()

class HBox(vararg children: Child) : Group()

class Box(vararg children: Child) : Group()

class PaddingBox(val padding: Int, val child: Child) : Group()

interface ConstraintLayoutF<T, P> {
    fun addView(constrainLayout: T, child: Any, params: P)
    fun mkLayoutParams(): P
    fun setPadding(lp: P, l: Int, t: Int, r: Int, b: Int)
}

private class Padding(var l: Int, var t: Int, var r: Int, var b: Int)

class FakeConstraintLayout
class FakeConstraintLayoutParams
