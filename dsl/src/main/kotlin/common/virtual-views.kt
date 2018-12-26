package common

import android.content.Context
import y2k.virtual.ui.Property
import y2k.virtual.ui.VirtualNode

abstract class View_ : VirtualNode() {

    var backgroundColor: Int
        get() = _backgroundColor.value
        set(value) {
            _backgroundColor.set(value)
            props += _backgroundColor
        }

    private val _backgroundColor: Property<Int, LinearLayout> = Property(0, LinearLayout::setBackgroundColor)
}

abstract class ViewGroup_ : View_()

class LinearLayout_ : ViewGroup_() {

    var orientation: Int
        get() = throw IllegalStateException()
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, LinearLayout> = Property(0, LinearLayout::setOrientation)

    override fun createEmpty(context: Context?): View = LinearLayout(context)
}

open class TextView_ : View_() {

    var text: String
        get() = throw IllegalStateException()
        set(value) {
            _text.set(value)
            props += _text
        }
    var textColor: Int
        get() = throw IllegalStateException()
        set(value) {
            _textColor.set(value)
            props += _textColor
        }
    var textSize: Float
        get() = throw IllegalStateException()
        set(value) {
            _textSize.set(value)
            props += _textSize
        }
    var backgroundResource: Int
        get() = throw IllegalStateException()
        set(value) {
            _backgroundResource.set(value)
            props += _backgroundResource
        }

    private val _text: Property<String, TextView> = Property("", TextView::setText)
    private val _textSize: Property<Float, TextView> = Property(0f, TextView::setTextSize)
    private val _textColor: Property<Int, TextView> = Property(0, TextView::setTextColor)
    private val _backgroundResource: Property<Int, TextView> = Property(0, TextView::setBackgroundResource)

    override fun createEmpty(context: Context?): View = TextView(context)
}

class Button_ : TextView_() {

    override fun createEmpty(context: Context?): View = Button(context)
}
