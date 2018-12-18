import android.content.Context
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView

fun main(args: Array<String>) = Unit

fun foo(context: Context) {
    VBox(context).apply {
        addView(
            TextView(context).apply {
                text = "Login page"
            }
        )
        addView(
            HBox(context).apply {
                setPadding(8, 8, 8, 8)

                addView(
                    Button(context).apply {
                        text = "OK"
                    }
                )
                addView(
                    Button(context).apply {
                        text = "Cancel"
                    }
                )
            }
        )
    }
}

class VBox(context: Context?) : FrameLayout(context)

class HBox(context: Context?) : FrameLayout(context)

class Box(context: Context?) : FrameLayout(context)

class PaddingBox(context: Context?) : FrameLayout(context)
