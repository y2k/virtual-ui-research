@file:Suppress("unused", "ClassName", "DEPRECATION")

package y2k.virtual.ui

import android.animation.LayoutTransition
import android.animation.StateListAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Rect
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputFilter
import android.text.Spannable
import android.text.TextUtils
import android.text.method.KeyListener
import android.text.method.MovementMethod
import android.text.method.TransformationMethod
import android.view.*
import android.view.animation.Animation
import android.view.animation.LayoutAnimationController
import android.view.inputmethod.ExtractedText
import android.widget.LinearLayout
import android.widget.Scroller
import android.widget.TextView
import java.util.*

fun textView(f: TextView_.() -> Unit) {
    val x = TextView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TextView_ : View_() {
    var error: CharSequence
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _error.set(value)
            props += _error
        }

    private val _error: Property<CharSequence?, TextView> = Property(null, TextView::setError)

    var typeface: Typeface
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _typeface.set(value)
            props += _typeface
        }

    private val _typeface: Property<Typeface?, TextView> = Property(null, TextView::setTypeface)

    var keyListener: KeyListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _keyListener.set(value)
            props += _keyListener
        }

    private val _keyListener: Property<KeyListener?, TextView> = Property(
        null,
        TextView::setKeyListener
    )

    var movementMethod: MovementMethod
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _movementMethod.set(value)
            props += _movementMethod
        }

    private val _movementMethod: Property<MovementMethod?, TextView> = Property(
        null,
        TextView::setMovementMethod
    )

    var transformationMethod: TransformationMethod
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transformationMethod.set(value)
            props += _transformationMethod
        }

    private val _transformationMethod: Property<TransformationMethod?, TextView> = Property(
        null,
        TextView::setTransformationMethod
    )

    var compoundDrawablePadding: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _compoundDrawablePadding.set(value)
            props += _compoundDrawablePadding
        }

    private val _compoundDrawablePadding: Property<Int, TextView> = Property(
        0,
        TextView::setCompoundDrawablePadding
    )

    var textLocale: Locale
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textLocale.set(value)
            props += _textLocale
        }

    private val _textLocale: Property<Locale?, TextView> = Property(null, TextView::setTextLocale)

    var textSize: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textSize.set(value)
            props += _textSize
        }

    private val _textSize: Property<Float, TextView> = Property(0.0f, TextView::setTextSize)

    var textScaleX: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textScaleX.set(value)
            props += _textScaleX
        }

    private val _textScaleX: Property<Float, TextView> = Property(0.0f, TextView::setTextScaleX)

    var elegantTextHeight: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _elegantTextHeight.set(value)
            props += _elegantTextHeight
        }

    private val _elegantTextHeight: Property<Boolean, TextView> = Property(
        false,
        TextView::setElegantTextHeight
    )

    var letterSpacing: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _letterSpacing.set(value)
            props += _letterSpacing
        }

    private val _letterSpacing: Property<Float, TextView> = Property(
        0.0f,
        TextView::setLetterSpacing
    )

    var fontFeatureSettings: String
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fontFeatureSettings.set(value)
            props += _fontFeatureSettings
        }

    private val _fontFeatureSettings: Property<String?, TextView> = Property(
        null,
        TextView::setFontFeatureSettings
    )

    var highlightColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _highlightColor.set(value)
            props += _highlightColor
        }

    private val _highlightColor: Property<Int, TextView> = Property(0, TextView::setHighlightColor)

    var showSoftInputOnFocus: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showSoftInputOnFocus.set(value)
            props += _showSoftInputOnFocus
        }

    private val _showSoftInputOnFocus: Property<Boolean, TextView> = Property(
        false,
        TextView::setShowSoftInputOnFocus
    )

    var autoLinkMask: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoLinkMask.set(value)
            props += _autoLinkMask
        }

    private val _autoLinkMask: Property<Int, TextView> = Property(0, TextView::setAutoLinkMask)

    var linksClickable: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _linksClickable.set(value)
            props += _linksClickable
        }

    private val _linksClickable: Property<Boolean, TextView> = Property(
        false,
        TextView::setLinksClickable
    )

    var paintFlags: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _paintFlags.set(value)
            props += _paintFlags
        }

    private val _paintFlags: Property<Int, TextView> = Property(0, TextView::setPaintFlags)

    var horizontallyScrolling: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontallyScrolling.set(value)
            props += _horizontallyScrolling
        }

    private val _horizontallyScrolling: Property<Boolean, TextView> = Property(
        false,
        TextView::setHorizontallyScrolling
    )

    var minLines: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minLines.set(value)
            props += _minLines
        }

    private val _minLines: Property<Int, TextView> = Property(0, TextView::setMinLines)

    var minHeight: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minHeight.set(value)
            props += _minHeight
        }

    private val _minHeight: Property<Int, TextView> = Property(0, TextView::setMinHeight)

    var maxLines: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxLines.set(value)
            props += _maxLines
        }

    private val _maxLines: Property<Int, TextView> = Property(0, TextView::setMaxLines)

    var maxHeight: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxHeight.set(value)
            props += _maxHeight
        }

    private val _maxHeight: Property<Int, TextView> = Property(0, TextView::setMaxHeight)

    var lines: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _lines.set(value)
            props += _lines
        }

    private val _lines: Property<Int, TextView> = Property(0, TextView::setLines)

    var height: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _height.set(value)
            props += _height
        }

    private val _height: Property<Int, TextView> = Property(0, TextView::setHeight)

    var minEms: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minEms.set(value)
            props += _minEms
        }

    private val _minEms: Property<Int, TextView> = Property(0, TextView::setMinEms)

    var minWidth: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minWidth.set(value)
            props += _minWidth
        }

    private val _minWidth: Property<Int, TextView> = Property(0, TextView::setMinWidth)

    var maxEms: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxEms.set(value)
            props += _maxEms
        }

    private val _maxEms: Property<Int, TextView> = Property(0, TextView::setMaxEms)

    var maxWidth: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxWidth.set(value)
            props += _maxWidth
        }

    private val _maxWidth: Property<Int, TextView> = Property(0, TextView::setMaxWidth)

    var ems: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _ems.set(value)
            props += _ems
        }

    private val _ems: Property<Int, TextView> = Property(0, TextView::setEms)

    var width: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _width.set(value)
            props += _width
        }

    private val _width: Property<Int, TextView> = Property(0, TextView::setWidth)

    var freezesText: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _freezesText.set(value)
            props += _freezesText
        }

    private val _freezesText: Property<Boolean, TextView> = Property(
        false,
        TextView::setFreezesText
    )

    var editableFactory: Editable.Factory
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _editableFactory.set(value)
            props += _editableFactory
        }

    private val _editableFactory: Property<Editable.Factory?, TextView> = Property(
        null,
        TextView::setEditableFactory
    )

    var spannableFactory: Spannable.Factory
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _spannableFactory.set(value)
            props += _spannableFactory
        }

    private val _spannableFactory: Property<Spannable.Factory?, TextView> = Property(
        null,
        TextView::setSpannableFactory
    )

    var textKeepState: CharSequence
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textKeepState.set(value)
            props += _textKeepState
        }

    private val _textKeepState: Property<CharSequence?, TextView> = Property(
        null,
        TextView::setTextKeepState
    )

    var inputType: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inputType.set(value)
            props += _inputType
        }

    private val _inputType: Property<Int, TextView> = Property(0, TextView::setInputType)

    var rawInputType: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rawInputType.set(value)
            props += _rawInputType
        }

    private val _rawInputType: Property<Int, TextView> = Property(0, TextView::setRawInputType)

    var imeOptions: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imeOptions.set(value)
            props += _imeOptions
        }

    private val _imeOptions: Property<Int, TextView> = Property(0, TextView::setImeOptions)

    var onEditorActionListener: TextView.OnEditorActionListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onEditorActionListener.set(value)
            props += _onEditorActionListener
        }

    private val _onEditorActionListener: Property<TextView.OnEditorActionListener?, TextView> =
        Property(null, TextView::setOnEditorActionListener)

    var privateImeOptions: String
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _privateImeOptions.set(value)
            props += _privateImeOptions
        }

    private val _privateImeOptions: Property<String?, TextView> = Property(
        null,
        TextView::setPrivateImeOptions
    )

    var inputExtras: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inputExtras.set(value)
            props += _inputExtras
        }

    private val _inputExtras: Property<Int, TextView> = Property(0, TextView::setInputExtras)

    var filters: Array<InputFilter>
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filters.set(value)
            props += _filters
        }

    private val _filters: Property<Array<InputFilter>?, TextView> = Property(
        null,
        TextView::setFilters
    )

    var textIsSelectable: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textIsSelectable.set(value)
            props += _textIsSelectable
        }

    private val _textIsSelectable: Property<Boolean, TextView> = Property(
        false,
        TextView::setTextIsSelectable
    )

    var extractedText: ExtractedText
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _extractedText.set(value)
            props += _extractedText
        }

    private val _extractedText: Property<ExtractedText?, TextView> = Property(
        null,
        TextView::setExtractedText
    )

    var includeFontPadding: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _includeFontPadding.set(value)
            props += _includeFontPadding
        }

    private val _includeFontPadding: Property<Boolean, TextView> = Property(
        false,
        TextView::setIncludeFontPadding
    )

    var textColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textColor.set(value)
            props += _textColor
        }

    private val _textColor: Property<Int, TextView> = Property(0, TextView::setTextColor)

    var hintTextColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hintTextColor.set(value)
            props += _hintTextColor
        }

    private val _hintTextColor: Property<Int, TextView> = Property(0, TextView::setHintTextColor)

    var linkTextColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _linkTextColor.set(value)
            props += _linkTextColor
        }

    private val _linkTextColor: Property<Int, TextView> = Property(0, TextView::setLinkTextColor)

    var hint: CharSequence
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hint.set(value)
            props += _hint
        }

    private val _hint: Property<CharSequence?, TextView> = Property(null, TextView::setHint)

    var text: CharSequence
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _text.set(value)
            props += _text
        }

    private val _text: Property<CharSequence?, TextView> = Property(null, TextView::setText)

    var gravity: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, TextView> = Property(0, TextView::setGravity)

    var ellipsize: TextUtils.TruncateAt
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _ellipsize.set(value)
            props += _ellipsize
        }

    private val _ellipsize: Property<TextUtils.TruncateAt?, TextView> = Property(
        null,
        TextView::setEllipsize
    )

    var singleLine: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _singleLine.set(value)
            props += _singleLine
        }

    private val _singleLine: Property<Boolean, TextView> = Property(false, TextView::setSingleLine)

    var allCaps: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _allCaps.set(value)
            props += _allCaps
        }

    private val _allCaps: Property<Boolean, TextView> = Property(false, TextView::setAllCaps)

    var marqueeRepeatLimit: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _marqueeRepeatLimit.set(value)
            props += _marqueeRepeatLimit
        }

    private val _marqueeRepeatLimit: Property<Int, TextView> = Property(
        0,
        TextView::setMarqueeRepeatLimit
    )

    var selectAllOnFocus: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selectAllOnFocus.set(value)
            props += _selectAllOnFocus
        }

    private val _selectAllOnFocus: Property<Boolean, TextView> = Property(
        false,
        TextView::setSelectAllOnFocus
    )

    var cursorVisible: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cursorVisible.set(value)
            props += _cursorVisible
        }

    private val _cursorVisible: Property<Boolean, TextView> = Property(
        false,
        TextView::setCursorVisible
    )

    var scroller: Scroller
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scroller.set(value)
            props += _scroller
        }

    private val _scroller: Property<Scroller?, TextView> = Property(null, TextView::setScroller)

    var customSelectionActionModeCallback: ActionMode.Callback
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _customSelectionActionModeCallback.set(value)
            props += _customSelectionActionModeCallback
        }

    private val _customSelectionActionModeCallback: Property<ActionMode.Callback?, TextView> =
        Property(null, TextView::setCustomSelectionActionModeCallback)

    override fun createEmpty(context: Context) = TextView(context)
}

fun linearLayout(f: LinearLayout_.() -> Unit) {
    val x = LinearLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class LinearLayout_ : ViewGroup_() {
    var showDividers: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showDividers.set(value)
            props += _showDividers
        }

    private val _showDividers: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setShowDividers
    )

    var dividerDrawable: Drawable
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerDrawable.set(value)
            props += _dividerDrawable
        }

    private val _dividerDrawable: Property<Drawable?, LinearLayout> = Property(
        null,
        LinearLayout::setDividerDrawable
    )

    var dividerPadding: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerPadding.set(value)
            props += _dividerPadding
        }

    private val _dividerPadding: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setDividerPadding
    )

    var baselineAligned: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAligned.set(value)
            props += _baselineAligned
        }

    private val _baselineAligned: Property<Boolean, LinearLayout> = Property(
        false,
        LinearLayout::setBaselineAligned
    )

    var measureWithLargestChildEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _measureWithLargestChildEnabled.set(value)
            props += _measureWithLargestChildEnabled
        }

    private val _measureWithLargestChildEnabled: Property<Boolean, LinearLayout> = Property(
        false,
        LinearLayout::setMeasureWithLargestChildEnabled
    )

    var baselineAlignedChildIndex: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAlignedChildIndex.set(value)
            props += _baselineAlignedChildIndex
        }

    private val _baselineAlignedChildIndex: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setBaselineAlignedChildIndex
    )

    var weightSum: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weightSum.set(value)
            props += _weightSum
        }

    private val _weightSum: Property<Float, LinearLayout> = Property(
        0.0f,
        LinearLayout::setWeightSum
    )

    var orientation: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setOrientation
    )

    var gravity: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, LinearLayout> = Property(0, LinearLayout::setGravity)

    var horizontalGravity: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalGravity.set(value)
            props += _horizontalGravity
        }

    private val _horizontalGravity: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setHorizontalGravity
    )

    var verticalGravity: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalGravity.set(value)
            props += _verticalGravity
        }

    private val _verticalGravity: Property<Int, LinearLayout> = Property(
        0,
        LinearLayout::setVerticalGravity
    )

    override fun createEmpty(context: Context) = LinearLayout(context)
}

fun view(f: View_.() -> Unit) {
    val x = View_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class View_ : VirtualNode() {
    var fadingEdgeLength: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fadingEdgeLength.set(value)
            props += _fadingEdgeLength
        }

    private val _fadingEdgeLength: Property<Int, View> = Property(0, View::setFadingEdgeLength)

    var verticalScrollbarPosition: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalScrollbarPosition.set(value)
            props += _verticalScrollbarPosition
        }

    private val _verticalScrollbarPosition: Property<Int, View> = Property(
        0,
        View::setVerticalScrollbarPosition
    )

    var onFocusChangeListener: View.OnFocusChangeListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onFocusChangeListener.set(value)
            props += _onFocusChangeListener
        }

    private val _onFocusChangeListener: Property<View.OnFocusChangeListener?, View> = Property(
        null,
        View::setOnFocusChangeListener
    )

    var onClickListener: View.OnClickListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onClickListener.set(value)
            props += _onClickListener
        }

    private val _onClickListener: Property<View.OnClickListener?, View> = Property(
        null,
        View::setOnClickListener
    )

    var onLongClickListener: View.OnLongClickListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onLongClickListener.set(value)
            props += _onLongClickListener
        }

    private val _onLongClickListener: Property<View.OnLongClickListener?, View> = Property(
        null,
        View::setOnLongClickListener
    )

    var onCreateContextMenuListener: View.OnCreateContextMenuListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCreateContextMenuListener.set(value)
            props += _onCreateContextMenuListener
        }

    private val _onCreateContextMenuListener: Property<View.OnCreateContextMenuListener?, View> =
        Property(null, View::setOnCreateContextMenuListener)

    var onKeyListener: View.OnKeyListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onKeyListener.set(value)
            props += _onKeyListener
        }

    private val _onKeyListener: Property<View.OnKeyListener?, View> = Property(
        null,
        View::setOnKeyListener
    )

    var onTouchListener: View.OnTouchListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onTouchListener.set(value)
            props += _onTouchListener
        }

    private val _onTouchListener: Property<View.OnTouchListener?, View> = Property(
        null,
        View::setOnTouchListener
    )

    var onGenericMotionListener: View.OnGenericMotionListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onGenericMotionListener.set(value)
            props += _onGenericMotionListener
        }

    private val _onGenericMotionListener: Property<View.OnGenericMotionListener?, View> =
        Property(null, View::setOnGenericMotionListener)

    var onHoverListener: View.OnHoverListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onHoverListener.set(value)
            props += _onHoverListener
        }

    private val _onHoverListener: Property<View.OnHoverListener?, View> = Property(
        null,
        View::setOnHoverListener
    )

    var onDragListener: View.OnDragListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onDragListener.set(value)
            props += _onDragListener
        }

    private val _onDragListener: Property<View.OnDragListener?, View> = Property(
        null,
        View::setOnDragListener
    )

    var accessibilityDelegate: View.AccessibilityDelegate
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityDelegate.set(value)
            props += _accessibilityDelegate
        }

    private val _accessibilityDelegate: Property<View.AccessibilityDelegate?, View> = Property(
        null,
        View::setAccessibilityDelegate
    )

    var contentDescription: CharSequence
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _contentDescription.set(value)
            props += _contentDescription
        }

    private val _contentDescription: Property<CharSequence?, View> = Property(
        null,
        View::setContentDescription
    )

    var accessibilityTraversalBefore: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityTraversalBefore.set(value)
            props += _accessibilityTraversalBefore
        }

    private val _accessibilityTraversalBefore: Property<Int, View> = Property(
        0,
        View::setAccessibilityTraversalBefore
    )

    var accessibilityTraversalAfter: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityTraversalAfter.set(value)
            props += _accessibilityTraversalAfter
        }

    private val _accessibilityTraversalAfter: Property<Int, View> = Property(
        0,
        View::setAccessibilityTraversalAfter
    )

    var labelFor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _labelFor.set(value)
            props += _labelFor
        }

    private val _labelFor: Property<Int, View> = Property(0, View::setLabelFor)

    var scrollContainer: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollContainer.set(value)
            props += _scrollContainer
        }

    private val _scrollContainer: Property<Boolean, View> = Property(
        false,
        View::setScrollContainer
    )

    var drawingCacheQuality: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheQuality.set(value)
            props += _drawingCacheQuality
        }

    private val _drawingCacheQuality: Property<Int, View> = Property(
        0,
        View::setDrawingCacheQuality
    )

    var keepScreenOn: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _keepScreenOn.set(value)
            props += _keepScreenOn
        }

    private val _keepScreenOn: Property<Boolean, View> = Property(false, View::setKeepScreenOn)

    var nextFocusLeftId: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusLeftId.set(value)
            props += _nextFocusLeftId
        }

    private val _nextFocusLeftId: Property<Int, View> = Property(0, View::setNextFocusLeftId)

    var nextFocusRightId: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusRightId.set(value)
            props += _nextFocusRightId
        }

    private val _nextFocusRightId: Property<Int, View> = Property(0, View::setNextFocusRightId)

    var nextFocusUpId: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusUpId.set(value)
            props += _nextFocusUpId
        }

    private val _nextFocusUpId: Property<Int, View> = Property(0, View::setNextFocusUpId)

    var nextFocusDownId: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusDownId.set(value)
            props += _nextFocusDownId
        }

    private val _nextFocusDownId: Property<Int, View> = Property(0, View::setNextFocusDownId)

    var nextFocusForwardId: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusForwardId.set(value)
            props += _nextFocusForwardId
        }

    private val _nextFocusForwardId: Property<Int, View> = Property(0, View::setNextFocusForwardId)

    var onApplyWindowInsetsListener: View.OnApplyWindowInsetsListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onApplyWindowInsetsListener.set(value)
            props += _onApplyWindowInsetsListener
        }

    private val _onApplyWindowInsetsListener: Property<View.OnApplyWindowInsetsListener?, View> =
        Property(null, View::setOnApplyWindowInsetsListener)

    var fitsSystemWindows: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fitsSystemWindows.set(value)
            props += _fitsSystemWindows
        }

    private val _fitsSystemWindows: Property<Boolean, View> = Property(
        false,
        View::setFitsSystemWindows
    )

    var visibility: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _visibility.set(value)
            props += _visibility
        }

    private val _visibility: Property<Int, View> = Property(0, View::setVisibility)

    var enabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _enabled.set(value)
            props += _enabled
        }

    private val _enabled: Property<Boolean, View> = Property(false, View::setEnabled)

    var focusable: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _focusable.set(value)
            props += _focusable
        }

    private val _focusable: Property<Boolean, View> = Property(false, View::setFocusable)

    var focusableInTouchMode: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _focusableInTouchMode.set(value)
            props += _focusableInTouchMode
        }

    private val _focusableInTouchMode: Property<Boolean, View> = Property(
        false,
        View::setFocusableInTouchMode
    )

    var soundEffectsEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _soundEffectsEnabled.set(value)
            props += _soundEffectsEnabled
        }

    private val _soundEffectsEnabled: Property<Boolean, View> = Property(
        false,
        View::setSoundEffectsEnabled
    )

    var hapticFeedbackEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hapticFeedbackEnabled.set(value)
            props += _hapticFeedbackEnabled
        }

    private val _hapticFeedbackEnabled: Property<Boolean, View> = Property(
        false,
        View::setHapticFeedbackEnabled
    )

    var layoutDirection: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutDirection.set(value)
            props += _layoutDirection
        }

    private val _layoutDirection: Property<Int, View> = Property(0, View::setLayoutDirection)

    var hasTransientState: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hasTransientState.set(value)
            props += _hasTransientState
        }

    private val _hasTransientState: Property<Boolean, View> = Property(
        false,
        View::setHasTransientState
    )

    var willNotDraw: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _willNotDraw.set(value)
            props += _willNotDraw
        }

    private val _willNotDraw: Property<Boolean, View> = Property(false, View::setWillNotDraw)

    var willNotCacheDrawing: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _willNotCacheDrawing.set(value)
            props += _willNotCacheDrawing
        }

    private val _willNotCacheDrawing: Property<Boolean, View> = Property(
        false,
        View::setWillNotCacheDrawing
    )

    var clickable: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clickable.set(value)
            props += _clickable
        }

    private val _clickable: Property<Boolean, View> = Property(false, View::setClickable)

    var longClickable: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _longClickable.set(value)
            props += _longClickable
        }

    private val _longClickable: Property<Boolean, View> = Property(false, View::setLongClickable)

    var pressed: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pressed.set(value)
            props += _pressed
        }

    private val _pressed: Property<Boolean, View> = Property(false, View::setPressed)

    var saveEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _saveEnabled.set(value)
            props += _saveEnabled
        }

    private val _saveEnabled: Property<Boolean, View> = Property(false, View::setSaveEnabled)

    var filterTouchesWhenObscured: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filterTouchesWhenObscured.set(value)
            props += _filterTouchesWhenObscured
        }

    private val _filterTouchesWhenObscured: Property<Boolean, View> = Property(
        false,
        View::setFilterTouchesWhenObscured
    )

    var saveFromParentEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _saveFromParentEnabled.set(value)
            props += _saveFromParentEnabled
        }

    private val _saveFromParentEnabled: Property<Boolean, View> = Property(
        false,
        View::setSaveFromParentEnabled
    )

    var accessibilityLiveRegion: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityLiveRegion.set(value)
            props += _accessibilityLiveRegion
        }

    private val _accessibilityLiveRegion: Property<Int, View> = Property(
        0,
        View::setAccessibilityLiveRegion
    )

    var importantForAccessibility: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _importantForAccessibility.set(value)
            props += _importantForAccessibility
        }

    private val _importantForAccessibility: Property<Int, View> = Property(
        0,
        View::setImportantForAccessibility
    )

    var hovered: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hovered.set(value)
            props += _hovered
        }

    private val _hovered: Property<Boolean, View> = Property(false, View::setHovered)

    var touchDelegate: TouchDelegate
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _touchDelegate.set(value)
            props += _touchDelegate
        }

    private val _touchDelegate: Property<TouchDelegate?, View> = Property(
        null,
        View::setTouchDelegate
    )

    var scrollX: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollX.set(value)
            props += _scrollX
        }

    private val _scrollX: Property<Int, View> = Property(0, View::setScrollX)

    var scrollY: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollY.set(value)
            props += _scrollY
        }

    private val _scrollY: Property<Int, View> = Property(0, View::setScrollY)

    var cameraDistance: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cameraDistance.set(value)
            props += _cameraDistance
        }

    private val _cameraDistance: Property<Float, View> = Property(0.0f, View::setCameraDistance)

    var rotation: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotation.set(value)
            props += _rotation
        }

    private val _rotation: Property<Float, View> = Property(0.0f, View::setRotation)

    var rotationY: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotationY.set(value)
            props += _rotationY
        }

    private val _rotationY: Property<Float, View> = Property(0.0f, View::setRotationY)

    var rotationX: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotationX.set(value)
            props += _rotationX
        }

    private val _rotationX: Property<Float, View> = Property(0.0f, View::setRotationX)

    var scaleX: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scaleX.set(value)
            props += _scaleX
        }

    private val _scaleX: Property<Float, View> = Property(0.0f, View::setScaleX)

    var scaleY: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scaleY.set(value)
            props += _scaleY
        }

    private val _scaleY: Property<Float, View> = Property(0.0f, View::setScaleY)

    var pivotX: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pivotX.set(value)
            props += _pivotX
        }

    private val _pivotX: Property<Float, View> = Property(0.0f, View::setPivotX)

    var pivotY: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pivotY.set(value)
            props += _pivotY
        }

    private val _pivotY: Property<Float, View> = Property(0.0f, View::setPivotY)

    var alpha: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _alpha.set(value)
            props += _alpha
        }

    private val _alpha: Property<Float, View> = Property(0.0f, View::setAlpha)

    var top: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _top.set(value)
            props += _top
        }

    private val _top: Property<Int, View> = Property(0, View::setTop)

    var bottom: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _bottom.set(value)
            props += _bottom
        }

    private val _bottom: Property<Int, View> = Property(0, View::setBottom)

    var left: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _left.set(value)
            props += _left
        }

    private val _left: Property<Int, View> = Property(0, View::setLeft)

    var right: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _right.set(value)
            props += _right
        }

    private val _right: Property<Int, View> = Property(0, View::setRight)

    var elevation: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _elevation.set(value)
            props += _elevation
        }

    private val _elevation: Property<Float, View> = Property(0.0f, View::setElevation)

    var translationX: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationX.set(value)
            props += _translationX
        }

    private val _translationX: Property<Float, View> = Property(0.0f, View::setTranslationX)

    var translationY: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationY.set(value)
            props += _translationY
        }

    private val _translationY: Property<Float, View> = Property(0.0f, View::setTranslationY)

    var translationZ: Float
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationZ.set(value)
            props += _translationZ
        }

    private val _translationZ: Property<Float, View> = Property(0.0f, View::setTranslationZ)

    var stateListAnimator: StateListAnimator
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stateListAnimator.set(value)
            props += _stateListAnimator
        }

    private val _stateListAnimator: Property<StateListAnimator?, View> = Property(
        null,
        View::setStateListAnimator
    )

    var clipToOutline: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipToOutline.set(value)
            props += _clipToOutline
        }

    private val _clipToOutline: Property<Boolean, View> = Property(false, View::setClipToOutline)

    var outlineProvider: ViewOutlineProvider
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _outlineProvider.set(value)
            props += _outlineProvider
        }

    private val _outlineProvider: Property<ViewOutlineProvider?, View> = Property(
        null,
        View::setOutlineProvider
    )

    var layoutParams: ViewGroup.LayoutParams
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutParams.set(value)
            props += _layoutParams
        }

    private val _layoutParams: Property<ViewGroup.LayoutParams?, View> = Property(
        null,
        View::setLayoutParams
    )

    var horizontalFadingEdgeEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalFadingEdgeEnabled.set(value)
            props += _horizontalFadingEdgeEnabled
        }

    private val _horizontalFadingEdgeEnabled: Property<Boolean, View> = Property(
        false,
        View::setHorizontalFadingEdgeEnabled
    )

    var verticalFadingEdgeEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalFadingEdgeEnabled.set(value)
            props += _verticalFadingEdgeEnabled
        }

    private val _verticalFadingEdgeEnabled: Property<Boolean, View> = Property(
        false,
        View::setVerticalFadingEdgeEnabled
    )

    var horizontalScrollBarEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalScrollBarEnabled.set(value)
            props += _horizontalScrollBarEnabled
        }

    private val _horizontalScrollBarEnabled: Property<Boolean, View> = Property(
        false,
        View::setHorizontalScrollBarEnabled
    )

    var verticalScrollBarEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalScrollBarEnabled.set(value)
            props += _verticalScrollBarEnabled
        }

    private val _verticalScrollBarEnabled: Property<Boolean, View> = Property(
        false,
        View::setVerticalScrollBarEnabled
    )

    var scrollbarFadingEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollbarFadingEnabled.set(value)
            props += _scrollbarFadingEnabled
        }

    private val _scrollbarFadingEnabled: Property<Boolean, View> = Property(
        false,
        View::setScrollbarFadingEnabled
    )

    var scrollBarDefaultDelayBeforeFade: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarDefaultDelayBeforeFade.set(value)
            props += _scrollBarDefaultDelayBeforeFade
        }

    private val _scrollBarDefaultDelayBeforeFade: Property<Int, View> = Property(
        0,
        View::setScrollBarDefaultDelayBeforeFade
    )

    var scrollBarFadeDuration: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarFadeDuration.set(value)
            props += _scrollBarFadeDuration
        }

    private val _scrollBarFadeDuration: Property<Int, View> = Property(
        0,
        View::setScrollBarFadeDuration
    )

    var scrollBarSize: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarSize.set(value)
            props += _scrollBarSize
        }

    private val _scrollBarSize: Property<Int, View> = Property(0, View::setScrollBarSize)

    var scrollBarStyle: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarStyle.set(value)
            props += _scrollBarStyle
        }

    private val _scrollBarStyle: Property<Int, View> = Property(0, View::setScrollBarStyle)

    var duplicateParentStateEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _duplicateParentStateEnabled.set(value)
            props += _duplicateParentStateEnabled
        }

    private val _duplicateParentStateEnabled: Property<Boolean, View> = Property(
        false,
        View::setDuplicateParentStateEnabled
    )

    var layerPaint: Paint
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layerPaint.set(value)
            props += _layerPaint
        }

    private val _layerPaint: Property<Paint?, View> = Property(null, View::setLayerPaint)

    var drawingCacheEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheEnabled.set(value)
            props += _drawingCacheEnabled
        }

    private val _drawingCacheEnabled: Property<Boolean, View> = Property(
        false,
        View::setDrawingCacheEnabled
    )

    var drawingCacheBackgroundColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheBackgroundColor.set(value)
            props += _drawingCacheBackgroundColor
        }

    private val _drawingCacheBackgroundColor: Property<Int, View> = Property(
        0,
        View::setDrawingCacheBackgroundColor
    )

    var clipBounds: Rect
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipBounds.set(value)
            props += _clipBounds
        }

    private val _clipBounds: Property<Rect?, View> = Property(null, View::setClipBounds)

    var backgroundColor: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundColor.set(value)
            props += _backgroundColor
        }

    private val _backgroundColor: Property<Int, View> = Property(0, View::setBackgroundColor)

    var backgroundResource: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundResource.set(value)
            props += _backgroundResource
        }

    private val _backgroundResource: Property<Int, View> = Property(0, View::setBackgroundResource)

    var background: Drawable
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _background.set(value)
            props += _background
        }

    private val _background: Property<Drawable?, View> = Property(null, View::setBackground)

    var backgroundDrawable: Drawable
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundDrawable.set(value)
            props += _backgroundDrawable
        }

    private val _backgroundDrawable: Property<Drawable?, View> = Property(
        null,
        View::setBackgroundDrawable
    )

    var backgroundTintList: ColorStateList
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundTintList.set(value)
            props += _backgroundTintList
        }

    private val _backgroundTintList: Property<ColorStateList?, View> = Property(
        null,
        View::setBackgroundTintList
    )

    var backgroundTintMode: PorterDuff.Mode
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundTintMode.set(value)
            props += _backgroundTintMode
        }

    private val _backgroundTintMode: Property<PorterDuff.Mode?, View> = Property(
        null,
        View::setBackgroundTintMode
    )

    var selected: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selected.set(value)
            props += _selected
        }

    private val _selected: Property<Boolean, View> = Property(false, View::setSelected)

    var activated: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _activated.set(value)
            props += _activated
        }

    private val _activated: Property<Boolean, View> = Property(false, View::setActivated)

    var id: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _id.set(value)
            props += _id
        }

    private val _id: Property<Int, View> = Property(0, View::setId)

    var tag: Any
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _tag.set(value)
            props += _tag
        }

    private val _tag: Property<Any?, View> = Property(null, View::setTag)

    var minimumHeight: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minimumHeight.set(value)
            props += _minimumHeight
        }

    private val _minimumHeight: Property<Int, View> = Property(0, View::setMinimumHeight)

    var minimumWidth: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minimumWidth.set(value)
            props += _minimumWidth
        }

    private val _minimumWidth: Property<Int, View> = Property(0, View::setMinimumWidth)

    var animation: Animation
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animation.set(value)
            props += _animation
        }

    private val _animation: Property<Animation?, View> = Property(null, View::setAnimation)

    var systemUiVisibility: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _systemUiVisibility.set(value)
            props += _systemUiVisibility
        }

    private val _systemUiVisibility: Property<Int, View> = Property(0, View::setSystemUiVisibility)

    var onSystemUiVisibilityChangeListener: View.OnSystemUiVisibilityChangeListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onSystemUiVisibilityChangeListener.set(value)
            props += _onSystemUiVisibilityChangeListener
        }

    private val _onSystemUiVisibilityChangeListener:
            Property<View.OnSystemUiVisibilityChangeListener?, View> = Property(
        null,
        View::setOnSystemUiVisibilityChangeListener
    )

    var overScrollMode: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overScrollMode.set(value)
            props += _overScrollMode
        }

    private val _overScrollMode: Property<Int, View> = Property(0, View::setOverScrollMode)

    var nestedScrollingEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nestedScrollingEnabled.set(value)
            props += _nestedScrollingEnabled
        }

    private val _nestedScrollingEnabled: Property<Boolean, View> = Property(
        false,
        View::setNestedScrollingEnabled
    )

    var textDirection: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textDirection.set(value)
            props += _textDirection
        }

    private val _textDirection: Property<Int, View> = Property(0, View::setTextDirection)

    var textAlignment: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textAlignment.set(value)
            props += _textAlignment
        }

    private val _textAlignment: Property<Int, View> = Property(0, View::setTextAlignment)

    var transitionName: String
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transitionName.set(value)
            props += _transitionName
        }

    private val _transitionName: Property<String?, View> = Property(null, View::setTransitionName)

    override fun createEmpty(context: Context) = View(context)
}

fun viewGroup(f: ViewGroup_.() -> Unit) {
    val x = ViewGroup_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewGroup_ : View_() {
    var layoutAnimation: LayoutAnimationController
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutAnimation.set(value)
            props += _layoutAnimation
        }

    private val _layoutAnimation: Property<LayoutAnimationController?, ViewGroup> = Property(
        null,
        ViewGroup::setLayoutAnimation
    )

    var animationCacheEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animationCacheEnabled.set(value)
            props += _animationCacheEnabled
        }

    private val _animationCacheEnabled: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setAnimationCacheEnabled
    )

    var alwaysDrawnWithCacheEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _alwaysDrawnWithCacheEnabled.set(value)
            props += _alwaysDrawnWithCacheEnabled
        }

    private val _alwaysDrawnWithCacheEnabled: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setAlwaysDrawnWithCacheEnabled
    )

    var persistentDrawingCache: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _persistentDrawingCache.set(value)
            props += _persistentDrawingCache
        }

    private val _persistentDrawingCache: Property<Int, ViewGroup> = Property(
        0,
        ViewGroup::setPersistentDrawingCache
    )

    var layoutMode: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutMode.set(value)
            props += _layoutMode
        }

    private val _layoutMode: Property<Int, ViewGroup> = Property(0, ViewGroup::setLayoutMode)

    var addStatesFromChildren: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _addStatesFromChildren.set(value)
            props += _addStatesFromChildren
        }

    private val _addStatesFromChildren: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setAddStatesFromChildren
    )

    var layoutAnimationListener: Animation.AnimationListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutAnimationListener.set(value)
            props += _layoutAnimationListener
        }

    private val _layoutAnimationListener: Property<Animation.AnimationListener?, ViewGroup> =
        Property(null, ViewGroup::setLayoutAnimationListener)

    var descendantFocusability: Int
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _descendantFocusability.set(value)
            props += _descendantFocusability
        }

    private val _descendantFocusability: Property<Int, ViewGroup> = Property(
        0,
        ViewGroup::setDescendantFocusability
    )

    var touchscreenBlocksFocus: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _touchscreenBlocksFocus.set(value)
            props += _touchscreenBlocksFocus
        }

    private val _touchscreenBlocksFocus: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setTouchscreenBlocksFocus
    )

    var motionEventSplittingEnabled: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _motionEventSplittingEnabled.set(value)
            props += _motionEventSplittingEnabled
        }

    private val _motionEventSplittingEnabled: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setMotionEventSplittingEnabled
    )

    var transitionGroup: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transitionGroup.set(value)
            props += _transitionGroup
        }

    private val _transitionGroup: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setTransitionGroup
    )

    var clipChildren: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipChildren.set(value)
            props += _clipChildren
        }

    private val _clipChildren: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setClipChildren
    )

    var clipToPadding: Boolean
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipToPadding.set(value)
            props += _clipToPadding
        }

    private val _clipToPadding: Property<Boolean, ViewGroup> = Property(
        false,
        ViewGroup::setClipToPadding
    )

    var onHierarchyChangeListener: ViewGroup.OnHierarchyChangeListener
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onHierarchyChangeListener.set(value)
            props += _onHierarchyChangeListener
        }

    private val _onHierarchyChangeListener: Property<ViewGroup.OnHierarchyChangeListener?,
            ViewGroup> = Property(null, ViewGroup::setOnHierarchyChangeListener)

    var layoutTransition: LayoutTransition
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutTransition.set(value)
            props += _layoutTransition
        }

    private val _layoutTransition: Property<LayoutTransition?, ViewGroup> = Property(
        null,
        ViewGroup::setLayoutTransition
    )
}
