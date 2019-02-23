package y2k.android

import android.app.Activity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import java.util.concurrent.atomic.AtomicInteger

class ConstraintTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_constraint)

        idFactory.set(0)
        val frameLayout: FrameLayout = findViewById(R.id.frame_layout)

        frameLayout.linearLayout(LinearLayout.VERTICAL) {
            button("Button #1")

            linearLayout(LinearLayout.HORIZONTAL) {
                button("Button #2").apply {
                    minHeight = 300
                }
                button("Button #4")
            }

            button("Button #3")
        }

        fillConstraintLayout(frameLayout, findViewById(R.id.constraint_layout))
    }

    private fun fillConstraintLayout(source: FrameLayout, target: ConstraintLayout) {
        val child = source.getChildAt(0)
        when (child) {
            is LinearLayout -> {
                lateinit var prev: View
                child.children().forEachIndexed { index, v ->
                    if (index == 0) {
                        when (v) {
                            is LinearLayout -> TODO()
                            is Button -> {
                                target.addView(
                                    v.clone(),
                                    ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                                )
                                prev = v.clone()
                            }
                            else -> TODO()
                        }
                    } else {
                        when (v) {
                            is LinearLayout -> {
                                prev = copyTo_(target, v, prev, child.orientation)
                            }
                            is Button -> {
                                target.addView(
                                    v.clone(),
                                    ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                                        .apply {
                                            when (child.orientation) {
                                                LinearLayout.VERTICAL -> topToBottom = prev.id
                                                else -> startToEnd = prev.id
                                            }
                                        }
                                )
                                prev = v.clone()
                            }
                            else -> TODO()
                        }
                    }
                }
            }
            is Button -> TODO()
            else -> TODO()
        }
    }

    private fun copyTo_(
        target: ConstraintLayout,
        ll: LinearLayout,
        parentPrev: View,
        parentOrientation: Int
    ): View {
        lateinit var prev: View
        lateinit var result: View

        ll.children().forEachIndexed { index, v ->
            when (v) {
                is Button -> {
                    if (index == 0) {
                        target.addView(
                            v.clone(),
                            ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                                .apply {
                                    when (parentOrientation) {
                                        LinearLayout.VERTICAL -> topToBottom = parentPrev.id
                                        else -> startToEnd = parentPrev.id
                                    }
                                }
                        )
                        result = v.clone()
                    } else {
                        target.addView(
                            v.clone(),
                            ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                                .apply {
                                    when (parentOrientation) {
                                        LinearLayout.VERTICAL -> topToBottom = parentPrev.id
                                        else -> startToEnd = parentPrev.id
                                    }
                                    when (ll.orientation) {
                                        LinearLayout.VERTICAL -> topToBottom = prev.id
                                        else -> startToEnd = prev.id
                                    }
                                }
                        )
                    }
                }
                is LinearLayout -> TODO()
                else -> TODO()
            }
            prev = v.clone()
        }

        return result
    }
}

fun ViewGroup.linearLayout(orientation: Int, f: LinearLayout.() -> Unit): LinearLayout {
    val l = LinearLayout(context)
    l.orientation = orientation
    l.f()
    addView(l)
    return l
}

private fun ViewGroup.button(title: String): Button =
    Button(context).apply {
        text = title
        id = idFactory.incrementAndGet()
        addView(this)
    }

private fun Button.clone(): Button =
    Button(context).also {
        it.text = text
        it.id = id + 1000
        it.minWidth = minWidth
        it.minHeight = minHeight
    }

private fun LinearLayout.children(): List<View> =
    List(childCount) { getChildAt(it) }

private val idFactory = AtomicInteger()
