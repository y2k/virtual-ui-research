package y2k.virtual.ui.common

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import y2k.virtual.ui.*

class EditableView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var onTextChanged: ((CharSequence) -> Unit)? = null
    private var editText: EditText? = null

    fun setOnTextChanged(onTextChanged: ((CharSequence) -> Unit)?) {
        this.onTextChanged = onTextChanged
    }

    fun setText(s: CharSequence?) {
        val editText = editText ?: return
        if (editText.text?.toString() != s) {
            val sel = editText.selectionStart
            editText.setText(s)
            if (sel <= s?.length ?: 0)
                editText.setSelection(sel)
        }
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)

        editText = child as EditText
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
            override fun afterTextChanged(s: Editable) {
                onTextChanged?.invoke(s)
            }
        })
    }
}

fun editableView(f: EditableView_.() -> Unit): EditableView_ {
    val x = EditableView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
    return x
}

@Suppress("ClassName")
@VirtualNodeMarker
open class EditableView_ : ViewGroup_() {

    override fun clear(p: Property, a: View) {
        val v = a as EditableView
        when (p.propId) {
            0 -> v.setText(null)
            1 -> v.setOnTextChanged(null)
        }
    }

    override fun update(p: Property, a: View) {
        val v = a as EditableView
        when (p.propId) {
            0 -> v.setText(p.value as CharSequence?)
            1 -> v.setOnTextChanged(p.value as ((CharSequence) -> Unit)?)
        }
    }

    var text: CharSequence?
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() = throw IllegalStateException()
        set(value) = updateProp(true, 0, value)

    var onTextChanged: ((CharSequence) -> Unit)?
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() = throw IllegalStateException()
        set(value) = updateProp(false, 1, value)

    override fun createEmpty(context: Context) = EditableView(context)
}

@Suppress("unused")
fun LinearLayout_.fillHorizontal(f: () -> View_) {
    val node = f()
    node.layoutParams =
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            1f
        )
}
