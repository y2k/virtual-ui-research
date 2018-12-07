import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

fun main(args: Array<String>) {
}

private fun testDsl(t: String) {
    linearLayout {
        backgroundColor = Color.WHITE

        button {
            textColor = Color.BLUE
            textSize = 20f
            text = "+"
        }

        textView {
            textColor = Color.GRAY
            textSize = 20f
            text = t
        }

        button {
            textColor = Color.RED
            textSize = 20f
            text = "-"
        }
    }
}

class LinearLayout_ {
    var backgroundColor: Int = 0
}

class Button_ {
    var text: String = ""
    var textColor: Int = 0
    var textSize: Float = 0f
}

class TextView_ {
    var text: String = ""
    var textColor: Int = 0
    var textSize: Float = 0f
}

fun linearLayout(f: LinearLayout_.() -> Unit) = Unit
fun button(f: Button_.() -> Unit) = Unit
fun textView(f: TextView_.() -> Unit) = Unit

private fun test(text: String): (Context) -> View = {
    val a = LinearLayout(it)
    a.orientation = LinearLayout.VERTICAL

    val b = Button(it)
    a.addView(b)
    b.text = "+"

    val c = TextView(it)
    a.addView(c)
    c.text = text

    val d = Button(it)
    a.addView(d)
    d.text = "+"

    a
}
