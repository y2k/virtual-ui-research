package common

import android.content.Context
import y2k.virtual.ui.Property
import y2k.virtual.ui.PropertyHolder
import y2k.virtual.ui.ViewGroup_

class LinearLayout_ : ViewGroup_(), PropertyHolder {

    var orientation: Int
        get() = throw IllegalStateException()
        set(value) = orientation_.set(value)

    private val orientation_: Property<Int, LinearLayout> = Property(0, LinearLayout::setOrientation)

    var backgroundColor: Int
        get() = backgroundColor__.value
        set(value) = backgroundColor__.set(value)

    private val backgroundColor__: Property<Int, LinearLayout> = Property(0, LinearLayout::setBackgroundColor)

    override val props: List<Property<out Any, LinearLayout>> =
        listOf(backgroundColor__)

    override fun createEmpty(context: Context?): View = LinearLayout(context)
}

class TextView_ : PropertyHolder {

    var text: String
        get() = throw IllegalStateException()
        set(value) = text_.set(value)
    var textColor: Int
        get() = throw IllegalStateException()
        set(value) = textColor_.set(value)
    var textSize: Float
        get() = throw IllegalStateException()
        set(value) = textSize_.set(value)
    var backgroundResource: Int
        get() = throw IllegalStateException()
        set(value) = backgroundResource_.set(value)

    private val text_: Property<String, TextView> = Property("", TextView::setText)
    private val textSize_: Property<Float, TextView> = Property(0f, TextView::setTextSize)
    private val textColor_: Property<Int, TextView> = Property(0, TextView::setTextColor)
    private val backgroundResource_: Property<Int, TextView> = Property(0, TextView::setBackgroundResource)

    override val props: List<Property<out Any, TextView>> =
        listOf(text_, textSize_, textColor_)

    override fun createEmpty(context: Context?): View = TextView(context)
}

class Button_ : PropertyHolder {

    var text: String
        get() = throw IllegalStateException()
        set(value) = text_.set(value)
    var textColor: Int
        get() = throw IllegalStateException()
        set(value) = textColor_.set(value)
    var textSize: Float
        get() = throw IllegalStateException()
        set(value) = textSize_.set(value)
    var backgroundResource: Int
        get() = throw IllegalStateException()
        set(value) = backgroundResource_.set(value)

    private val text_: Property<String, Button> = Property("", Button::setText)
    private val textSize_: Property<Float, Button> = Property(0f, Button::setTextSize)
    private val textColor_: Property<Int, Button> = Property(0, Button::setTextColor)
    private val backgroundResource_: Property<Int, Button> = Property(0, Button::setBackgroundResource)

    override val props: List<Property<out Any, Button>> =
        listOf(text_, textSize_, textColor_)

    override fun createEmpty(context: Context?): View = Button(context)
}
