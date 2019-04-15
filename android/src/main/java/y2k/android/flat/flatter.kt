package y2k.android.flat

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintLayout

fun fillConstraintLayout(view: View, target: ConstraintLayout) {
    if (view !is LinearLayout) TODO()
    fillFromLinearLayout(view, target, null, 0)
}

private fun fillFromLinearLayout(
    ll: LinearLayout,
    target: ConstraintLayout,
    parentPrev: View?,
    parentOrientation: Int
): Pair<View, View> {
    val prevIds = mutableListOf<View>()
    val prevBarriers = mutableListOf<View>()

    ll.children().forEachIndexed { index, v ->
        when (v) {
            is LinearLayout -> {
                val (cv, cb) = fillFromLinearLayout(v, target, prevBarriers.last(), ll.orientation)
                prevIds += cv
                prevBarriers += cb
            }
            is ViewGroup -> TODO()
            else -> {
                if (index == 0) {
                    target.addView(
                        v.clone(),
                        ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                            leftMargin = ll.paddingLeft
                            topMargin = ll.paddingTop
                            if (parentPrev != null)
                                when (parentOrientation) {
                                    LinearLayout.HORIZONTAL -> {
                                        topToTop = parentPrev.id
                                        startToEnd = parentPrev.id
                                    }
                                    else -> {
                                        startToStart = parentPrev.id
                                        topToBottom = parentPrev.id
                                    }
                                }
                        }
                    )
                } else {
                    target.addView(
                        v.clone(),
                        ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                            if (parentPrev != null)
                                when (parentOrientation) {
                                    LinearLayout.HORIZONTAL -> startToEnd = parentPrev.id
                                    else -> topToBottom = parentPrev.id
                                }
                            when (ll.orientation) {
                                LinearLayout.HORIZONTAL -> {
                                    startToEnd = prevBarriers.last().id
                                    topMargin = ll.paddingTop
                                }
                                else -> {
                                    topToBottom = prevBarriers.last().id
                                    leftMargin = ll.paddingLeft
                                }
                            }
                        }
                    )
                }
                prevIds += v.clone()
                prevBarriers += v.clone()
            }
        }
    }

    val barrier = Barrier(target.context)
    barrier.id = idFactory.incrementAndGet()
    barrier.referencedIds = prevIds.map { it.id }.toIntArray()
    barrier.type = when (parentOrientation) {
        LinearLayout.HORIZONTAL -> Barrier.END
        else -> Barrier.BOTTOM
    }
    target.addView(barrier)
    if (ll.paddingBottom == 0 && ll.paddingRight == 0)
        return ll.children().last().clone() to barrier

    val stub = View(target.context)
    stub.id = idFactory.incrementAndGet()
    target.addView(
        stub,
        ConstraintLayout.LayoutParams(0, 0).apply {
            leftMargin = ll.paddingRight
            topMargin = ll.paddingBottom
            when (parentOrientation) {
                LinearLayout.HORIZONTAL -> {
                    topToBottom = prevIds.last().id
                    startToEnd = barrier.id
                }
                else -> {
                    topToBottom = barrier.id
                    startToEnd = prevIds.last().id
                }
            }
        }
    )

    return stub to stub
}
