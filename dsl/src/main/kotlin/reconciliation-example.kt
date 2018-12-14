
import android.graphics.Color
import common.*
import y2k.virtual.ui.updateRealView

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

private fun mkState1(): LinearLayout_ =
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

private fun mkState2(): LinearLayout_ =
    linearLayout {
        backgroundColor = Color.LTGRAY

        textView {
            text = "1.1) Hello World"
            textColor = Color.RED
            textSize = 20f
        }
    }

private fun mkState3(): LinearLayout_ =
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
