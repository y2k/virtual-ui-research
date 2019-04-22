@file:Suppress("ClassName")

import android.graphics.Color
import android.widget.LinearLayout
import y2k.virtualuiresearch.common.*

fun main(args: Array<String>) {
    view(
        "10",
        { /* Increase */ },
        { /* Decrease */ }
    ).let(::printPretty)
}

private fun view(counter: String, onUp: () -> Unit, onDown: () -> Unit) =
    linearLayout {
        backgroundColor = Color.WHITE
        orientation = LinearLayout.VERTICAL

        h1("Increase / Decrease example")

        counterButton("+", onUp)

        h1(counter)

        counterButton("-", onDown)
    }

private fun counterButton(title: String, e: () -> Unit) =
    button {
        backgroundResource = R.drawable.button_bg
        textColor = Color.BLUE
        textSize = 18f
        text = title
    }

private fun h1(title: String) =
    textView {
        backgroundResource = R.drawable.textview_bg
        textColor = Color.GRAY
        textSize = 20f
        text = title
    }
