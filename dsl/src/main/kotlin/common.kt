import com.google.gson.GsonBuilder
import java.util.*

fun printPretty(x: Any) {
    GsonBuilder()
        .setPrettyPrinting()
        .create()
        .toJson(x)
        .let(::println)
}

class LinearLayout_ {
    val `@class` = "LinearLayout"
    var backgroundColor: Int = 0
    var orientation: Int = 0
    var padding: FloatArray = floatArrayOf()
    val children = ArrayList<Any>()
}

class Button_ {
    val `@class` = "Button"
    var backgroundDrawableRes: Int = 0
    var text: String = ""
    var textColor: Int = 0
    var textSize: Float = 0f
    var onPressed: () -> Unit = {}
    var padding: FloatArray = floatArrayOf()
}

class TextView_ {
    val `@class` = "TextView"
    var backgroundDrawableRes: Int = 0
    var text: String = ""
    var textColor: Int = 0
    var textSize: Float = 0f
    var padding: FloatArray = floatArrayOf()
}

private val stack = Stack<LinearLayout_>()

fun linearLayout(f: LinearLayout_.() -> Unit): LinearLayout_ {
    val l = LinearLayout_()
    stack.push(l)
    l.f()
    stack.pop()
    return l
}

fun button(f: Button_.() -> Unit) {
    val b = Button_()
    b.f()
    stack.peek().children.add(b)
}

fun textView(f: TextView_.() -> Unit) {
    val t = TextView_()
    t.f()
    stack.peek().children.add(t)
}

@Suppress("ClassName")
object R {
    object drawable {
        const val button_bg: Int = 0
        const val textview_bg: Int = 0
    }
}
