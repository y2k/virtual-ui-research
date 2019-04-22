package y2k.virtualuiresearch.common

import com.google.gson.GsonBuilder
import y2k.virtual.ui.globalViewStack

fun printPretty(x: Any) {
    GsonBuilder()
        .setPrettyPrinting()
        .create()
        .toJson(x)
        .let(::println)
}

fun linearLayout(f: LinearLayout_.() -> Unit): LinearLayout_ {
    val l = LinearLayout_()
    globalViewStack.push(l)
    l.f()
    globalViewStack.pop()
    return l
}

fun button(f: Button_.() -> Unit) {
    val b = Button_()
    b.f()
    globalViewStack.peek().children.add(b)
}

fun textView(f: TextView_.() -> Unit) {
    val t = TextView_()
    t.f()
    globalViewStack.peek().children.add(t)
}

@Suppress("ClassName")
object R {
    object drawable {
        const val button_bg: Int = 0
        const val textview_bg: Int = 0
    }
}
