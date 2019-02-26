package y2k.android

import android.app.Activity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout

class ConstraintTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_constraint)
        idFactory.set(0)

        val padding = 30
        val root = findViewById<FrameLayout>(R.id.frame_layout)
            .linearLayout(LinearLayout.VERTICAL) {
                setPadding(padding, padding, padding, padding)
                setBackgroundColor(0x40FF0000)

                button("Button #1.1") {
                    minWidth = 500
                }
                linearLayout(LinearLayout.HORIZONTAL) {
                    setPadding(padding, padding, padding, padding)
                    setBackgroundColor(0x4000FF00)

                    button("Button #2.1")
                    linearLayout(LinearLayout.VERTICAL) {
                        setPadding(padding, padding, padding, padding)
                        setBackgroundColor(0x400000FF)

                        button("Button #3.1")
                        button("Button #3.2") {
                            minWidth = 450
                        }
                        button("Button #3.3")
                    }
                    button("Button #2.3") {
                        minHeight = 300
                    }
                }
                button("Button #1.3") {
                    minWidth = 500
                }
            }

        fillConstraintLayout(root, findViewById(R.id.constraint_layout))
    }
}
