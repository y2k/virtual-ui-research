package y2k.android

import android.support.constraint.Barrier
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout

fun fillConstraintLayout(view: View, target: ConstraintLayout) {
    if (view !is LinearLayout) TODO()
    fillFromLinearLayout(view, target, null, 0)
}

private fun fillFromLinearLayout(
    ll: LinearLayout,
    target: ConstraintLayout,
    parentPrev: View?,
    parentOrientation: Int
): Pair<View, Barrier> {
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
        LinearLayout.VERTICAL -> Barrier.BOTTOM
        else -> Barrier.END
    }
    target.addView(barrier)
    return ll.children().last().clone() to barrier
}
