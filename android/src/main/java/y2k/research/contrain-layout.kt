package y2k.research

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams

interface ConstraintLayoutF<T, P, V> {
    fun isView(obj: Any): Boolean
    fun addView(constrainLayout: T, child: V, params: P)
    fun mkLayoutParams(): P
    fun setMargin(lp: P, s: Int, t: Int, e: Int, b: Int)
    fun setId(child: V, id: Int)
    fun bindTopToBottom(lp: P, prevView: V?)
    fun bindStartToStart(lp: P, prevView: V?)
    fun bindTopToTop(lp: P, prevView: V?)
    fun bindStartToEnd(lp: P, prevView: V?)
}

@Suppress("unused")
object RealConstraintLayoutF : ConstraintLayoutF<ConstraintLayout, LayoutParams, View> {

    override fun isView(obj: Any): Boolean =
        obj is View

    override fun addView(constrainLayout: ConstraintLayout, child: View, params: LayoutParams) {
        constrainLayout.addView(child, params)
    }

    override fun mkLayoutParams(): LayoutParams =
        LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

    override fun setMargin(lp: LayoutParams, s: Int, t: Int, e: Int, b: Int) {
        lp.marginStart = s
        lp.topMargin = t
        lp.marginEnd = e
        lp.bottomMargin = b
    }

    override fun setId(child: View, id: Int) {
        child.id = id
    }

    override fun bindTopToBottom(lp: LayoutParams, prevView: View?) {
        lp.topToBottom = getIdOrParent(prevView)
    }

    override fun bindStartToStart(lp: LayoutParams, prevView: View?) {
        lp.startToStart = getIdOrParent(prevView)
    }

    override fun bindTopToTop(lp: LayoutParams, prevView: View?) {
        lp.topToTop = getIdOrParent(prevView)
    }

    override fun bindStartToEnd(lp: LayoutParams, prevView: View?) {
        lp.startToEnd = getIdOrParent(prevView)
    }

    private fun getIdOrParent(prevView: View?) =
        prevView?.id ?: LayoutParams.PARENT_ID
}
