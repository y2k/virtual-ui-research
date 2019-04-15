@file:Suppress("ClassName", "unused", "DEPRECATION")

package y2k.virtual.ui

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.app.MediaRouteButton
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.gesture.Gesture
import android.gesture.GestureOverlayView
import android.graphics.*
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.media.tv.TvView
import android.net.Uri
import android.text.*
import android.text.method.KeyListener
import android.text.method.MovementMethod
import android.text.method.TransformationMethod
import android.view.*
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.LayoutAnimationController
import android.view.inputmethod.ExtractedText
import android.widget.*
import java.util.*

fun relativeLayout(f: RelativeLayout_.() -> Unit) {
    val x = RelativeLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class RelativeLayout_ : ViewGroup_() {
    var ignoreGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _ignoreGravity.set(value)
            props += _ignoreGravity
        }

    private val _ignoreGravity: Property<Int, RelativeLayout> = Property(
        "ignoreGravity", 0,
        RelativeLayout::setIgnoreGravity)

    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, RelativeLayout> = Property(
        "gravity", 0,
        RelativeLayout::setGravity)

    var horizontalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalGravity.set(value)
            props += _horizontalGravity
        }

    private val _horizontalGravity: Property<Int, RelativeLayout> = Property(
        "horizontalGravity", 0,
        RelativeLayout::setHorizontalGravity)

    var verticalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalGravity.set(value)
            props += _verticalGravity
        }

    private val _verticalGravity: Property<Int, RelativeLayout> = Property(
        "verticalGravity", 0,
        RelativeLayout::setVerticalGravity)

    override fun createEmpty(context: Context) = RelativeLayout(context)
}

fun tableRow(f: TableRow_.() -> Unit) {
    val x = TableRow_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TableRow_ : LinearLayout_() {
    override fun createEmpty(context: Context) = TableRow(context)
}

fun listView(f: ListView_.() -> Unit) {
    val x = ListView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ListView_ : AbsListView_() {
    var itemsCanFocus: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _itemsCanFocus.set(value)
            props += _itemsCanFocus
        }

    private val _itemsCanFocus: Property<Boolean, ListView> = Property(
        "itemsCanFocus", false,
        ListView::setItemsCanFocus)

    var divider: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _divider.set(value)
            props += _divider
        }

    private val _divider: Property<Drawable?, ListView> = Property(
        "divider", null,
        ListView::setDivider)

    var dividerHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerHeight.set(value)
            props += _dividerHeight
        }

    private val _dividerHeight: Property<Int, ListView> = Property(
        "dividerHeight", 0,
        ListView::setDividerHeight)

    var headerDividersEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _headerDividersEnabled.set(value)
            props += _headerDividersEnabled
        }

    private val _headerDividersEnabled: Property<Boolean, ListView> =
        Property("headerDividersEnabled", false, ListView::setHeaderDividersEnabled)

    var footerDividersEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _footerDividersEnabled.set(value)
            props += _footerDividersEnabled
        }

    private val _footerDividersEnabled: Property<Boolean, ListView> =
        Property("footerDividersEnabled", false, ListView::setFooterDividersEnabled)

    var overscrollHeader: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overscrollHeader.set(value)
            props += _overscrollHeader
        }

    private val _overscrollHeader: Property<Drawable?, ListView> = Property(
        "overscrollHeader",
        null, ListView::setOverscrollHeader)

    var overscrollFooter: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overscrollFooter.set(value)
            props += _overscrollFooter
        }

    private val _overscrollFooter: Property<Drawable?, ListView> = Property(
        "overscrollFooter",
        null, ListView::setOverscrollFooter)

    override fun createEmpty(context: Context) = ListView(context)
}

fun videoView(f: VideoView_.() -> Unit) {
    val x = VideoView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class VideoView_ : SurfaceView_() {
    var mediaController: MediaController
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _mediaController.set(value)
            props += _mediaController
        }

    private val _mediaController: Property<MediaController?, VideoView> =
        Property("mediaController", null, VideoView::setMediaController)

    var videoPath: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _videoPath.set(value)
            props += _videoPath
        }

    private val _videoPath: Property<String?, VideoView> = Property(
        "videoPath", null,
        VideoView::setVideoPath)

    var videoURI: Uri
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _videoURI.set(value)
            props += _videoURI
        }

    private val _videoURI: Property<Uri?, VideoView> = Property(
        "videoURI", null,
        VideoView::setVideoURI)

    var onPreparedListener: MediaPlayer.OnPreparedListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onPreparedListener.set(value)
            props += _onPreparedListener
        }

    private val _onPreparedListener: Property<MediaPlayer.OnPreparedListener?, VideoView> =
        Property("onPreparedListener", null, VideoView::setOnPreparedListener)

    var onCompletionListener: MediaPlayer.OnCompletionListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCompletionListener.set(value)
            props += _onCompletionListener
        }

    private val _onCompletionListener: Property<MediaPlayer.OnCompletionListener?, VideoView> =
        Property("onCompletionListener", null, VideoView::setOnCompletionListener)

    var onInfoListener: MediaPlayer.OnInfoListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onInfoListener.set(value)
            props += _onInfoListener
        }

    private val _onInfoListener: Property<MediaPlayer.OnInfoListener?, VideoView> =
        Property("onInfoListener", null, VideoView::setOnInfoListener)

    var onErrorListener: MediaPlayer.OnErrorListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onErrorListener.set(value)
            props += _onErrorListener
        }

    private val _onErrorListener: Property<MediaPlayer.OnErrorListener?, VideoView> =
        Property("onErrorListener", null, VideoView::setOnErrorListener)

    override fun createEmpty(context: Context) = VideoView(context)
}

fun numberPicker(f: NumberPicker_.() -> Unit) {
    val x = NumberPicker_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class NumberPicker_ : LinearLayout_() {
    var value: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _value.set(value)
            props += _value
        }

    private val _value: Property<Int, NumberPicker> = Property("value", 0, NumberPicker::setValue)

    var onScrollListener: NumberPicker.OnScrollListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onScrollListener.set(value)
            props += _onScrollListener
        }

    private val _onScrollListener: Property<NumberPicker.OnScrollListener?, NumberPicker> =
        Property("onScrollListener", null, NumberPicker::setOnScrollListener)

    var onValueChangedListener: NumberPicker.OnValueChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onValueChangedListener.set(value)
            props += _onValueChangedListener
        }

    private val _onValueChangedListener: Property<NumberPicker.OnValueChangeListener?, NumberPicker> =
        Property("onValueChangedListener", null, NumberPicker::setOnValueChangedListener)

    var wrapSelectorWheel: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _wrapSelectorWheel.set(value)
            props += _wrapSelectorWheel
        }

    private val _wrapSelectorWheel: Property<Boolean, NumberPicker> = Property(
        "wrapSelectorWheel",
        false, NumberPicker::setWrapSelectorWheel)

    var onLongPressUpdateInterval: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onLongPressUpdateInterval.set(value)
            props += _onLongPressUpdateInterval
        }

    private val _onLongPressUpdateInterval: Property<Long, NumberPicker> =
        Property("onLongPressUpdateInterval", 0L, NumberPicker::setOnLongPressUpdateInterval)

    var minValue: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minValue.set(value)
            props += _minValue
        }

    private val _minValue: Property<Int, NumberPicker> = Property(
        "minValue", 0,
        NumberPicker::setMinValue)

    var maxValue: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxValue.set(value)
            props += _maxValue
        }

    private val _maxValue: Property<Int, NumberPicker> = Property(
        "maxValue", 0,
        NumberPicker::setMaxValue)

    var displayedValues: Array<String>
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _displayedValues.set(value)
            props += _displayedValues
        }

    private val _displayedValues: Property<Array<String>?, NumberPicker> =
        Property("displayedValues", null, NumberPicker::setDisplayedValues)

    var formatter: NumberPicker.Formatter
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _formatter.set(value)
            props += _formatter
        }

    private val _formatter: Property<NumberPicker.Formatter?, NumberPicker> = Property(
        "formatter",
        null, NumberPicker::setFormatter)

    override fun createEmpty(context: Context) = NumberPicker(context)
}

fun zoomButton(f: ZoomButton_.() -> Unit) {
    val x = ZoomButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ZoomButton_ : ImageButton_() {
    var zoomSpeed: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _zoomSpeed.set(value)
            props += _zoomSpeed
        }

    private val _zoomSpeed: Property<Long, ZoomButton> = Property(
        "zoomSpeed", 0L,
        ZoomButton::setZoomSpeed)

    override fun createEmpty(context: Context) = ZoomButton(context)
}

fun ratingBar(f: RatingBar_.() -> Unit) {
    val x = RatingBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class RatingBar_ : AbsSeekBar_() {
    var isIndicator: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _isIndicator.set(value)
            props += _isIndicator
        }

    private val _isIndicator: Property<Boolean, RatingBar> = Property(
        "isIndicator", false,
        RatingBar::setIsIndicator)

    var numStars: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _numStars.set(value)
            props += _numStars
        }

    private val _numStars: Property<Int, RatingBar> = Property(
        "numStars", 0,
        RatingBar::setNumStars)

    var onRatingBarChangeListener: RatingBar.OnRatingBarChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onRatingBarChangeListener.set(value)
            props += _onRatingBarChangeListener
        }

    private val _onRatingBarChangeListener: Property<RatingBar.OnRatingBarChangeListener?,
        RatingBar> = Property(
        "onRatingBarChangeListener", null,
        RatingBar::setOnRatingBarChangeListener)

    var rating: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rating.set(value)
            props += _rating
        }

    private val _rating: Property<Float, RatingBar> = Property("rating", 0.0f, RatingBar::setRating)

    var stepSize: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stepSize.set(value)
            props += _stepSize
        }

    private val _stepSize: Property<Float, RatingBar> = Property(
        "stepSize", 0.0f,
        RatingBar::setStepSize)

    override fun createEmpty(context: Context) = RatingBar(context)
}

fun datePicker(f: DatePicker_.() -> Unit) {
    val x = DatePicker_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class DatePicker_ : FrameLayout_() {
    var minDate: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minDate.set(value)
            props += _minDate
        }

    private val _minDate: Property<Long, DatePicker> = Property(
        "minDate", 0L,
        DatePicker::setMinDate)

    var maxDate: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxDate.set(value)
            props += _maxDate
        }

    private val _maxDate: Property<Long, DatePicker> = Property(
        "maxDate", 0L,
        DatePicker::setMaxDate)

    var calendarViewShown: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _calendarViewShown.set(value)
            props += _calendarViewShown
        }

    private val _calendarViewShown: Property<Boolean, DatePicker> = Property(
        "calendarViewShown",
        false, DatePicker::setCalendarViewShown)

    var spinnersShown: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _spinnersShown.set(value)
            props += _spinnersShown
        }

    private val _spinnersShown: Property<Boolean, DatePicker> = Property(
        "spinnersShown", false,
        DatePicker::setSpinnersShown)

    var firstDayOfWeek: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _firstDayOfWeek.set(value)
            props += _firstDayOfWeek
        }

    private val _firstDayOfWeek: Property<Int, DatePicker> = Property(
        "firstDayOfWeek", 0,
        DatePicker::setFirstDayOfWeek)

    override fun createEmpty(context: Context) = DatePicker(context)
}

fun compoundButton(f: CompoundButton_.() -> Unit) {
    val x = CompoundButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class CompoundButton_ : Button_() {
    var checked: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _checked.set(value)
            props += _checked
        }

    private val _checked: Property<Boolean, CompoundButton> = Property(
        "checked", false,
        CompoundButton::setChecked)

    var buttonTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _buttonTintList.set(value)
            props += _buttonTintList
        }

    private val _buttonTintList: Property<ColorStateList?, CompoundButton> =
        Property("buttonTintList", null, CompoundButton::setButtonTintList)

    var onCheckedChangeListener: CompoundButton.OnCheckedChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCheckedChangeListener.set(value)
            props += _onCheckedChangeListener
        }

    private val _onCheckedChangeListener: Property<CompoundButton.OnCheckedChangeListener?,
        CompoundButton> = Property(
        "onCheckedChangeListener", null,
        CompoundButton::setOnCheckedChangeListener)

    var buttonTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _buttonTintMode.set(value)
            props += _buttonTintMode
        }

    private val _buttonTintMode: Property<PorterDuff.Mode?, CompoundButton> =
        Property("buttonTintMode", null, CompoundButton::setButtonTintMode)

    var buttonDrawable: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _buttonDrawable.set(value)
            props += _buttonDrawable
        }

    private val _buttonDrawable: Property<Int, CompoundButton> = Property(
        "buttonDrawable", 0,
        CompoundButton::setButtonDrawable)
}

fun imageButton(f: ImageButton_.() -> Unit) {
    val x = ImageButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ImageButton_ : ImageView_() {
    override fun createEmpty(context: Context) = ImageButton(context)
}

fun mediaController(f: MediaController_.() -> Unit) {
    val x = MediaController_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class MediaController_ : FrameLayout_() {
    var mediaPlayer: MediaController.MediaPlayerControl
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _mediaPlayer.set(value)
            props += _mediaPlayer
        }

    private val _mediaPlayer: Property<MediaController.MediaPlayerControl?, MediaController> =
        Property("mediaPlayer", null, MediaController::setMediaPlayer)

    var anchorView: View
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _anchorView.set(value)
            props += _anchorView
        }

    private val _anchorView: Property<View?, MediaController> = Property(
        "anchorView", null,
        MediaController::setAnchorView)

    override fun createEmpty(context: Context) = MediaController(context)
}

fun progressBar(f: ProgressBar_.() -> Unit) {
    val x = ProgressBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ProgressBar_ : View_() {
    var progress: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progress.set(value)
            props += _progress
        }

    private val _progress: Property<Int, ProgressBar> = Property(
        "progress", 0,
        ProgressBar::setProgress)

    var secondaryProgress: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _secondaryProgress.set(value)
            props += _secondaryProgress
        }

    private val _secondaryProgress: Property<Int, ProgressBar> = Property(
        "secondaryProgress", 0,
        ProgressBar::setSecondaryProgress)

    var max: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _max.set(value)
            props += _max
        }

    private val _max: Property<Int, ProgressBar> = Property("max", 0, ProgressBar::setMax)

    var indeterminate: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _indeterminate.set(value)
            props += _indeterminate
        }

    private val _indeterminate: Property<Boolean, ProgressBar> = Property(
        "indeterminate", false,
        ProgressBar::setIndeterminate)

    var indeterminateDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _indeterminateDrawable.set(value)
            props += _indeterminateDrawable
        }

    private val _indeterminateDrawable: Property<Drawable?, ProgressBar> =
        Property("indeterminateDrawable", null, ProgressBar::setIndeterminateDrawable)

    var indeterminateTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _indeterminateTintList.set(value)
            props += _indeterminateTintList
        }

    private val _indeterminateTintList: Property<ColorStateList?, ProgressBar> =
        Property("indeterminateTintList", null, ProgressBar::setIndeterminateTintList)

    var indeterminateTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _indeterminateTintMode.set(value)
            props += _indeterminateTintMode
        }

    private val _indeterminateTintMode: Property<PorterDuff.Mode?, ProgressBar> =
        Property("indeterminateTintMode", null, ProgressBar::setIndeterminateTintMode)

    var indeterminateDrawableTiled: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _indeterminateDrawableTiled.set(value)
            props += _indeterminateDrawableTiled
        }

    private val _indeterminateDrawableTiled: Property<Drawable?, ProgressBar> =
        Property("indeterminateDrawableTiled", null, ProgressBar::setIndeterminateDrawableTiled)

    var progressDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressDrawable.set(value)
            props += _progressDrawable
        }

    private val _progressDrawable: Property<Drawable?, ProgressBar> = Property(
        "progressDrawable",
        null, ProgressBar::setProgressDrawable)

    var progressTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressTintList.set(value)
            props += _progressTintList
        }

    private val _progressTintList: Property<ColorStateList?, ProgressBar> =
        Property("progressTintList", null, ProgressBar::setProgressTintList)

    var progressTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressTintMode.set(value)
            props += _progressTintMode
        }

    private val _progressTintMode: Property<PorterDuff.Mode?, ProgressBar> =
        Property("progressTintMode", null, ProgressBar::setProgressTintMode)

    var progressBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressBackgroundTintList.set(value)
            props += _progressBackgroundTintList
        }

    private val _progressBackgroundTintList: Property<ColorStateList?, ProgressBar> =
        Property("progressBackgroundTintList", null, ProgressBar::setProgressBackgroundTintList)

    var progressBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressBackgroundTintMode.set(value)
            props += _progressBackgroundTintMode
        }

    private val _progressBackgroundTintMode: Property<PorterDuff.Mode?, ProgressBar> =
        Property("progressBackgroundTintMode", null, ProgressBar::setProgressBackgroundTintMode)

    var secondaryProgressTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _secondaryProgressTintList.set(value)
            props += _secondaryProgressTintList
        }

    private val _secondaryProgressTintList: Property<ColorStateList?, ProgressBar> =
        Property("secondaryProgressTintList", null, ProgressBar::setSecondaryProgressTintList)

    var secondaryProgressTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _secondaryProgressTintMode.set(value)
            props += _secondaryProgressTintMode
        }

    private val _secondaryProgressTintMode: Property<PorterDuff.Mode?, ProgressBar> =
        Property("secondaryProgressTintMode", null, ProgressBar::setSecondaryProgressTintMode)

    var progressDrawableTiled: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _progressDrawableTiled.set(value)
            props += _progressDrawableTiled
        }

    private val _progressDrawableTiled: Property<Drawable?, ProgressBar> =
        Property("progressDrawableTiled", null, ProgressBar::setProgressDrawableTiled)

    var interpolator: Interpolator
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _interpolator.set(value)
            props += _interpolator
        }

    private val _interpolator: Property<Interpolator?, ProgressBar> = Property(
        "interpolator", null,
        ProgressBar::setInterpolator)

    override fun createEmpty(context: Context) = ProgressBar(context)
}

fun textView(f: TextView_.() -> Unit) {
    val x = TextView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TextView_ : View_() {
    var error: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _error.set(value)
            props += _error
        }

    private val _error: Property<CharSequence?, TextView> = Property(
        "error", null,
        TextView::setError)

    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, TextView> = Property("gravity", 0, TextView::setGravity)

    var ellipsize: TextUtils.TruncateAt
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _ellipsize.set(value)
            props += _ellipsize
        }

    private val _ellipsize: Property<TextUtils.TruncateAt?, TextView> = Property(
        "ellipsize", null,
        TextView::setEllipsize)

    var typeface: Typeface
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _typeface.set(value)
            props += _typeface
        }

    private val _typeface: Property<Typeface?, TextView> = Property(
        "typeface", null,
        TextView::setTypeface)

    var keyListener: KeyListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _keyListener.set(value)
            props += _keyListener
        }

    private val _keyListener: Property<KeyListener?, TextView> = Property(
        "keyListener", null,
        TextView::setKeyListener)

    var movementMethod: MovementMethod
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _movementMethod.set(value)
            props += _movementMethod
        }

    private val _movementMethod: Property<MovementMethod?, TextView> = Property(
        "movementMethod",
        null, TextView::setMovementMethod)

    var transformationMethod: TransformationMethod
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transformationMethod.set(value)
            props += _transformationMethod
        }

    private val _transformationMethod: Property<TransformationMethod?, TextView> =
        Property("transformationMethod", null, TextView::setTransformationMethod)

    var compoundDrawablePadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _compoundDrawablePadding.set(value)
            props += _compoundDrawablePadding
        }

    private val _compoundDrawablePadding: Property<Int, TextView> =
        Property("compoundDrawablePadding", 0, TextView::setCompoundDrawablePadding)

    var textLocale: Locale
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textLocale.set(value)
            props += _textLocale
        }

    private val _textLocale: Property<Locale?, TextView> = Property(
        "textLocale", null,
        TextView::setTextLocale)

    var textSize: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textSize.set(value)
            props += _textSize
        }

    private val _textSize: Property<Float, TextView> = Property(
        "textSize", 0.0f,
        TextView::setTextSize)

    var textScaleX: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textScaleX.set(value)
            props += _textScaleX
        }

    private val _textScaleX: Property<Float, TextView> = Property(
        "textScaleX", 0.0f,
        TextView::setTextScaleX)

    var elegantTextHeight: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _elegantTextHeight.set(value)
            props += _elegantTextHeight
        }

    private val _elegantTextHeight: Property<Boolean, TextView> = Property(
        "elegantTextHeight",
        false, TextView::setElegantTextHeight)

    var letterSpacing: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _letterSpacing.set(value)
            props += _letterSpacing
        }

    private val _letterSpacing: Property<Float, TextView> = Property(
        "letterSpacing", 0.0f,
        TextView::setLetterSpacing)

    var fontFeatureSettings: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fontFeatureSettings.set(value)
            props += _fontFeatureSettings
        }

    private val _fontFeatureSettings: Property<String?, TextView> = Property(
        "fontFeatureSettings",
        null, TextView::setFontFeatureSettings)

    var highlightColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _highlightColor.set(value)
            props += _highlightColor
        }

    private val _highlightColor: Property<Int, TextView> = Property(
        "highlightColor", 0,
        TextView::setHighlightColor)

    var showSoftInputOnFocus: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showSoftInputOnFocus.set(value)
            props += _showSoftInputOnFocus
        }

    private val _showSoftInputOnFocus: Property<Boolean, TextView> =
        Property("showSoftInputOnFocus", false, TextView::setShowSoftInputOnFocus)

    var autoLinkMask: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoLinkMask.set(value)
            props += _autoLinkMask
        }

    private val _autoLinkMask: Property<Int, TextView> = Property(
        "autoLinkMask", 0,
        TextView::setAutoLinkMask)

    var linksClickable: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _linksClickable.set(value)
            props += _linksClickable
        }

    private val _linksClickable: Property<Boolean, TextView> = Property(
        "linksClickable", false,
        TextView::setLinksClickable)

    var paintFlags: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _paintFlags.set(value)
            props += _paintFlags
        }

    private val _paintFlags: Property<Int, TextView> = Property(
        "paintFlags", 0,
        TextView::setPaintFlags)

    var horizontallyScrolling: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontallyScrolling.set(value)
            props += _horizontallyScrolling
        }

    private val _horizontallyScrolling: Property<Boolean, TextView> =
        Property("horizontallyScrolling", false, TextView::setHorizontallyScrolling)

    var minLines: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minLines.set(value)
            props += _minLines
        }

    private val _minLines: Property<Int, TextView> = Property("minLines", 0, TextView::setMinLines)

    var minHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minHeight.set(value)
            props += _minHeight
        }

    private val _minHeight: Property<Int, TextView> = Property(
        "minHeight", 0,
        TextView::setMinHeight)

    var maxLines: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxLines.set(value)
            props += _maxLines
        }

    private val _maxLines: Property<Int, TextView> = Property("maxLines", 0, TextView::setMaxLines)

    var maxHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxHeight.set(value)
            props += _maxHeight
        }

    private val _maxHeight: Property<Int, TextView> = Property(
        "maxHeight", 0,
        TextView::setMaxHeight)

    var lines: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _lines.set(value)
            props += _lines
        }

    private val _lines: Property<Int, TextView> = Property("lines", 0, TextView::setLines)

    var height: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _height.set(value)
            props += _height
        }

    private val _height: Property<Int, TextView> = Property("height", 0, TextView::setHeight)

    var minEms: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minEms.set(value)
            props += _minEms
        }

    private val _minEms: Property<Int, TextView> = Property("minEms", 0, TextView::setMinEms)

    var minWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minWidth.set(value)
            props += _minWidth
        }

    private val _minWidth: Property<Int, TextView> = Property("minWidth", 0, TextView::setMinWidth)

    var maxEms: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxEms.set(value)
            props += _maxEms
        }

    private val _maxEms: Property<Int, TextView> = Property("maxEms", 0, TextView::setMaxEms)

    var maxWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxWidth.set(value)
            props += _maxWidth
        }

    private val _maxWidth: Property<Int, TextView> = Property("maxWidth", 0, TextView::setMaxWidth)

    var ems: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _ems.set(value)
            props += _ems
        }

    private val _ems: Property<Int, TextView> = Property("ems", 0, TextView::setEms)

    var width: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _width.set(value)
            props += _width
        }

    private val _width: Property<Int, TextView> = Property("width", 0, TextView::setWidth)

    var freezesText: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _freezesText.set(value)
            props += _freezesText
        }

    private val _freezesText: Property<Boolean, TextView> = Property(
        "freezesText", false,
        TextView::setFreezesText)

    var editableFactory: Editable.Factory
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _editableFactory.set(value)
            props += _editableFactory
        }

    private val _editableFactory: Property<Editable.Factory?, TextView> =
        Property("editableFactory", null, TextView::setEditableFactory)

    var spannableFactory: Spannable.Factory
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _spannableFactory.set(value)
            props += _spannableFactory
        }

    private val _spannableFactory: Property<Spannable.Factory?, TextView> =
        Property("spannableFactory", null, TextView::setSpannableFactory)

    var textKeepState: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textKeepState.set(value)
            props += _textKeepState
        }

    private val _textKeepState: Property<CharSequence?, TextView> = Property(
        "textKeepState", null,
        TextView::setTextKeepState)

    var inputType: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inputType.set(value)
            props += _inputType
        }

    private val _inputType: Property<Int, TextView> = Property(
        "inputType", 0,
        TextView::setInputType)

    var rawInputType: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rawInputType.set(value)
            props += _rawInputType
        }

    private val _rawInputType: Property<Int, TextView> = Property(
        "rawInputType", 0,
        TextView::setRawInputType)

    var imeOptions: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imeOptions.set(value)
            props += _imeOptions
        }

    private val _imeOptions: Property<Int, TextView> = Property(
        "imeOptions", 0,
        TextView::setImeOptions)

    var onEditorActionListener: TextView.OnEditorActionListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onEditorActionListener.set(value)
            props += _onEditorActionListener
        }

    private val _onEditorActionListener: Property<TextView.OnEditorActionListener?, TextView> =
        Property("onEditorActionListener", null, TextView::setOnEditorActionListener)

    var privateImeOptions: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _privateImeOptions.set(value)
            props += _privateImeOptions
        }

    private val _privateImeOptions: Property<String?, TextView> = Property(
        "privateImeOptions",
        null, TextView::setPrivateImeOptions)

    var inputExtras: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inputExtras.set(value)
            props += _inputExtras
        }

    private val _inputExtras: Property<Int, TextView> = Property(
        "inputExtras", 0,
        TextView::setInputExtras)

    var filters: Array<InputFilter>
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filters.set(value)
            props += _filters
        }

    private val _filters: Property<Array<InputFilter>?, TextView> = Property(
        "filters", null,
        TextView::setFilters)

    var textIsSelectable: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textIsSelectable.set(value)
            props += _textIsSelectable
        }

    private val _textIsSelectable: Property<Boolean, TextView> = Property(
        "textIsSelectable", false,
        TextView::setTextIsSelectable)

    var extractedText: ExtractedText
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _extractedText.set(value)
            props += _extractedText
        }

    private val _extractedText: Property<ExtractedText?, TextView> = Property(
        "extractedText", null,
        TextView::setExtractedText)

    var includeFontPadding: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _includeFontPadding.set(value)
            props += _includeFontPadding
        }

    private val _includeFontPadding: Property<Boolean, TextView> = Property(
        "includeFontPadding",
        false, TextView::setIncludeFontPadding)

    var singleLine: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _singleLine.set(value)
            props += _singleLine
        }

    private val _singleLine: Property<Boolean, TextView> = Property(
        "singleLine", false,
        TextView::setSingleLine)

    var allCaps: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _allCaps.set(value)
            props += _allCaps
        }

    private val _allCaps: Property<Boolean, TextView> = Property(
        "allCaps", false,
        TextView::setAllCaps)

    var marqueeRepeatLimit: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _marqueeRepeatLimit.set(value)
            props += _marqueeRepeatLimit
        }

    private val _marqueeRepeatLimit: Property<Int, TextView> = Property(
        "marqueeRepeatLimit", 0,
        TextView::setMarqueeRepeatLimit)

    var selectAllOnFocus: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selectAllOnFocus.set(value)
            props += _selectAllOnFocus
        }

    private val _selectAllOnFocus: Property<Boolean, TextView> = Property(
        "selectAllOnFocus", false,
        TextView::setSelectAllOnFocus)

    var cursorVisible: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cursorVisible.set(value)
            props += _cursorVisible
        }

    private val _cursorVisible: Property<Boolean, TextView> = Property(
        "cursorVisible", false,
        TextView::setCursorVisible)

    var scroller: Scroller
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scroller.set(value)
            props += _scroller
        }

    private val _scroller: Property<Scroller?, TextView> = Property(
        "scroller", null,
        TextView::setScroller)

    var customSelectionActionModeCallback: ActionMode.Callback
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _customSelectionActionModeCallback.set(value)
            props += _customSelectionActionModeCallback
        }

    private val _customSelectionActionModeCallback: Property<ActionMode.Callback?, TextView> =
        Property(
            "customSelectionActionModeCallback", null,
            TextView::setCustomSelectionActionModeCallback)

    var hintTextColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hintTextColor.set(value)
            props += _hintTextColor
        }

    private val _hintTextColor: Property<Int, TextView> = Property(
        "hintTextColor", 0,
        TextView::setHintTextColor)

    var linkTextColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _linkTextColor.set(value)
            props += _linkTextColor
        }

    private val _linkTextColor: Property<Int, TextView> = Property(
        "linkTextColor", 0,
        TextView::setLinkTextColor)

    var textColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textColor.set(value)
            props += _textColor
        }

    private val _textColor: Property<Int, TextView> = Property(
        "textColor", 0,
        TextView::setTextColor)

    var hint: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hint.set(value)
            props += _hint
        }

    private val _hint: Property<CharSequence?, TextView> = Property("hint", null, TextView::setHint)

    var text: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _text.set(value)
            props += _text
        }

    private val _text: Property<CharSequence?, TextView> = Property("text", null, TextView::setText)

    override fun createEmpty(context: Context) = TextView(context)
}

fun spinner(f: Spinner_.() -> Unit) {
    val x = Spinner_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Spinner_ : AbsSpinner_() {
    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, Spinner> = Property("gravity", 0, Spinner::setGravity)

    var dropDownWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dropDownWidth.set(value)
            props += _dropDownWidth
        }

    private val _dropDownWidth: Property<Int, Spinner> = Property(
        "dropDownWidth", 0,
        Spinner::setDropDownWidth)

    var dropDownVerticalOffset: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dropDownVerticalOffset.set(value)
            props += _dropDownVerticalOffset
        }

    private val _dropDownVerticalOffset: Property<Int, Spinner> = Property(
        "dropDownVerticalOffset",
        0, Spinner::setDropDownVerticalOffset)

    var dropDownHorizontalOffset: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dropDownHorizontalOffset.set(value)
            props += _dropDownHorizontalOffset
        }

    private val _dropDownHorizontalOffset: Property<Int, Spinner> =
        Property("dropDownHorizontalOffset", 0, Spinner::setDropDownHorizontalOffset)

    var popupBackgroundDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _popupBackgroundDrawable.set(value)
            props += _popupBackgroundDrawable
        }

    private val _popupBackgroundDrawable: Property<Drawable?, Spinner> =
        Property("popupBackgroundDrawable", null, Spinner::setPopupBackgroundDrawable)

    var popupBackgroundResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _popupBackgroundResource.set(value)
            props += _popupBackgroundResource
        }

    private val _popupBackgroundResource: Property<Int, Spinner> =
        Property("popupBackgroundResource", 0, Spinner::setPopupBackgroundResource)

    var prompt: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _prompt.set(value)
            props += _prompt
        }

    private val _prompt: Property<CharSequence?, Spinner> = Property(
        "prompt", null,
        Spinner::setPrompt)

    var promptId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _promptId.set(value)
            props += _promptId
        }

    private val _promptId: Property<Int, Spinner> = Property("promptId", 0, Spinner::setPromptId)

    override fun createEmpty(context: Context) = Spinner(context)
}

fun absSpinner(f: AbsSpinner_.() -> Unit) {
    val x = AbsSpinner_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AbsSpinner_ : AdapterView_()

fun quickContactBadge(f: QuickContactBadge_.() -> Unit) {
    val x = QuickContactBadge_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class QuickContactBadge_ : ImageView_() {
    var overlay: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overlay.set(value)
            props += _overlay
        }

    private val _overlay: Property<Drawable?, QuickContactBadge> = Property(
        "overlay", null,
        QuickContactBadge::setOverlay)

    var excludeMimes: Array<String>
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _excludeMimes.set(value)
            props += _excludeMimes
        }

    private val _excludeMimes: Property<Array<String>?, QuickContactBadge> =
        Property("excludeMimes", null, QuickContactBadge::setExcludeMimes)

    var mode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _mode.set(value)
            props += _mode
        }

    private val _mode: Property<Int, QuickContactBadge> = Property(
        "mode", 0,
        QuickContactBadge::setMode)

    override fun createEmpty(context: Context) = QuickContactBadge(context)
}

fun textSwitcher(f: TextSwitcher_.() -> Unit) {
    val x = TextSwitcher_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TextSwitcher_ : ViewSwitcher_() {
    var currentText: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _currentText.set(value)
            props += _currentText
        }

    private val _currentText: Property<CharSequence?, TextSwitcher> = Property(
        "currentText", null,
        TextSwitcher::setCurrentText)

    var text: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _text.set(value)
            props += _text
        }

    private val _text: Property<CharSequence?, TextSwitcher> = Property(
        "text", null,
        TextSwitcher::setText)

    override fun createEmpty(context: Context) = TextSwitcher(context)
}

fun adapterViewFlipper(f: AdapterViewFlipper_.() -> Unit) {
    val x = AdapterViewFlipper_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AdapterViewFlipper_ : AdapterViewAnimator_() {
    var flipInterval: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _flipInterval.set(value)
            props += _flipInterval
        }

    private val _flipInterval: Property<Int, AdapterViewFlipper> = Property(
        "flipInterval", 0,
        AdapterViewFlipper::setFlipInterval)

    var autoStart: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoStart.set(value)
            props += _autoStart
        }

    private val _autoStart: Property<Boolean, AdapterViewFlipper> = Property(
        "autoStart", false,
        AdapterViewFlipper::setAutoStart)

    override fun createEmpty(context: Context) = AdapterViewFlipper(context)
}

fun expandableListView(f: ExpandableListView_.() -> Unit) {
    val x = ExpandableListView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ExpandableListView_ : ListView_() {
    var childDivider: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _childDivider.set(value)
            props += _childDivider
        }

    private val _childDivider: Property<Drawable?, ExpandableListView> = Property(
        "childDivider",
        null, ExpandableListView::setChildDivider)

    var onGroupCollapseListener: ExpandableListView.OnGroupCollapseListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onGroupCollapseListener.set(value)
            props += _onGroupCollapseListener
        }

    private val _onGroupCollapseListener: Property<ExpandableListView.OnGroupCollapseListener?,
        ExpandableListView> = Property(
        "onGroupCollapseListener", null,
        ExpandableListView::setOnGroupCollapseListener)

    var onGroupExpandListener: ExpandableListView.OnGroupExpandListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onGroupExpandListener.set(value)
            props += _onGroupExpandListener
        }

    private val _onGroupExpandListener: Property<ExpandableListView.OnGroupExpandListener?,
        ExpandableListView> = Property(
        "onGroupExpandListener", null,
        ExpandableListView::setOnGroupExpandListener)

    var onGroupClickListener: ExpandableListView.OnGroupClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onGroupClickListener.set(value)
            props += _onGroupClickListener
        }

    private val _onGroupClickListener: Property<ExpandableListView.OnGroupClickListener?,
        ExpandableListView> = Property(
        "onGroupClickListener", null,
        ExpandableListView::setOnGroupClickListener)

    var onChildClickListener: ExpandableListView.OnChildClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onChildClickListener.set(value)
            props += _onChildClickListener
        }

    private val _onChildClickListener: Property<ExpandableListView.OnChildClickListener?,
        ExpandableListView> = Property(
        "onChildClickListener", null,
        ExpandableListView::setOnChildClickListener)

    var selectedGroup: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selectedGroup.set(value)
            props += _selectedGroup
        }

    private val _selectedGroup: Property<Int, ExpandableListView> = Property(
        "selectedGroup", 0,
        ExpandableListView::setSelectedGroup)

    var childIndicator: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _childIndicator.set(value)
            props += _childIndicator
        }

    private val _childIndicator: Property<Drawable?, ExpandableListView> =
        Property("childIndicator", null, ExpandableListView::setChildIndicator)

    var groupIndicator: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _groupIndicator.set(value)
            props += _groupIndicator
        }

    private val _groupIndicator: Property<Drawable?, ExpandableListView> =
        Property("groupIndicator", null, ExpandableListView::setGroupIndicator)

    override fun createEmpty(context: Context) = ExpandableListView(context)
}

fun button(f: Button_.() -> Unit) {
    val x = Button_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Button_ : TextView_() {
    override fun createEmpty(context: Context) = Button(context)
}

fun frameLayout(f: FrameLayout_.() -> Unit) {
    val x = FrameLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class FrameLayout_ : ViewGroup_() {
    var foregroundGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _foregroundGravity.set(value)
            props += _foregroundGravity
        }

    private val _foregroundGravity: Property<Int, FrameLayout> = Property(
        "foregroundGravity", 0,
        FrameLayout::setForegroundGravity)

    var foreground: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _foreground.set(value)
            props += _foreground
        }

    private val _foreground: Property<Drawable?, FrameLayout> = Property(
        "foreground", null,
        FrameLayout::setForeground)

    var foregroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _foregroundTintList.set(value)
            props += _foregroundTintList
        }

    private val _foregroundTintList: Property<ColorStateList?, FrameLayout> =
        Property("foregroundTintList", null, FrameLayout::setForegroundTintList)

    var foregroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _foregroundTintMode.set(value)
            props += _foregroundTintMode
        }

    private val _foregroundTintMode: Property<PorterDuff.Mode?, FrameLayout> =
        Property("foregroundTintMode", null, FrameLayout::setForegroundTintMode)

    var measureAllChildren: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _measureAllChildren.set(value)
            props += _measureAllChildren
        }

    private val _measureAllChildren: Property<Boolean, FrameLayout> = Property(
        "measureAllChildren",
        false, FrameLayout::setMeasureAllChildren)

    override fun createEmpty(context: Context) = FrameLayout(context)
}

fun chronometer(f: Chronometer_.() -> Unit) {
    val x = Chronometer_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Chronometer_ : TextView_() {
    var base: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _base.set(value)
            props += _base
        }

    private val _base: Property<Long, Chronometer> = Property("base", 0L, Chronometer::setBase)

    var onChronometerTickListener: Chronometer.OnChronometerTickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onChronometerTickListener.set(value)
            props += _onChronometerTickListener
        }

    private val _onChronometerTickListener: Property<Chronometer.OnChronometerTickListener?,
        Chronometer> = Property(
        "onChronometerTickListener", null,
        Chronometer::setOnChronometerTickListener)

    var format: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _format.set(value)
            props += _format
        }

    private val _format: Property<String?, Chronometer> = Property(
        "format", null,
        Chronometer::setFormat)

    override fun createEmpty(context: Context) = Chronometer(context)
}

fun viewFlipper(f: ViewFlipper_.() -> Unit) {
    val x = ViewFlipper_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewFlipper_ : ViewAnimator_() {
    var flipInterval: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _flipInterval.set(value)
            props += _flipInterval
        }

    private val _flipInterval: Property<Int, ViewFlipper> = Property(
        "flipInterval", 0,
        ViewFlipper::setFlipInterval)

    var autoStart: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoStart.set(value)
            props += _autoStart
        }

    private val _autoStart: Property<Boolean, ViewFlipper> = Property(
        "autoStart", false,
        ViewFlipper::setAutoStart)

    override fun createEmpty(context: Context) = ViewFlipper(context)
}

fun textClock(f: TextClock_.() -> Unit) {
    val x = TextClock_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TextClock_ : TextView_() {
    var format12Hour: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _format12Hour.set(value)
            props += _format12Hour
        }

    private val _format12Hour: Property<CharSequence?, TextClock> = Property(
        "format12Hour", null,
        TextClock::setFormat12Hour)

    var format24Hour: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _format24Hour.set(value)
            props += _format24Hour
        }

    private val _format24Hour: Property<CharSequence?, TextClock> = Property(
        "format24Hour", null,
        TextClock::setFormat24Hour)

    var timeZone: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _timeZone.set(value)
            props += _timeZone
        }

    private val _timeZone: Property<String?, TextClock> = Property(
        "timeZone", null,
        TextClock::setTimeZone)

    override fun createEmpty(context: Context) = TextClock(context)
}

fun tableLayout(f: TableLayout_.() -> Unit) {
    val x = TableLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TableLayout_ : LinearLayout_() {
    var shrinkAllColumns: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _shrinkAllColumns.set(value)
            props += _shrinkAllColumns
        }

    private val _shrinkAllColumns: Property<Boolean, TableLayout> = Property(
        "shrinkAllColumns",
        false, TableLayout::setShrinkAllColumns)

    var stretchAllColumns: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stretchAllColumns.set(value)
            props += _stretchAllColumns
        }

    private val _stretchAllColumns: Property<Boolean, TableLayout> = Property(
        "stretchAllColumns",
        false, TableLayout::setStretchAllColumns)

    override fun createEmpty(context: Context) = TableLayout(context)
}

fun checkedTextView(f: CheckedTextView_.() -> Unit) {
    val x = CheckedTextView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class CheckedTextView_ : TextView_() {
    var checked: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _checked.set(value)
            props += _checked
        }

    private val _checked: Property<Boolean, CheckedTextView> = Property(
        "checked", false,
        CheckedTextView::setChecked)

    var checkMarkTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _checkMarkTintList.set(value)
            props += _checkMarkTintList
        }

    private val _checkMarkTintList: Property<ColorStateList?, CheckedTextView> =
        Property("checkMarkTintList", null, CheckedTextView::setCheckMarkTintList)

    var checkMarkTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _checkMarkTintMode.set(value)
            props += _checkMarkTintMode
        }

    private val _checkMarkTintMode: Property<PorterDuff.Mode?, CheckedTextView> =
        Property("checkMarkTintMode", null, CheckedTextView::setCheckMarkTintMode)

    var checkMarkDrawable: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _checkMarkDrawable.set(value)
            props += _checkMarkDrawable
        }

    private val _checkMarkDrawable: Property<Int, CheckedTextView> = Property(
        "checkMarkDrawable",
        0, CheckedTextView::setCheckMarkDrawable)

    override fun createEmpty(context: Context) = CheckedTextView(context)
}

fun viewAnimator(f: ViewAnimator_.() -> Unit) {
    val x = ViewAnimator_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewAnimator_ : FrameLayout_() {
    var displayedChild: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _displayedChild.set(value)
            props += _displayedChild
        }

    private val _displayedChild: Property<Int, ViewAnimator> = Property(
        "displayedChild", 0,
        ViewAnimator::setDisplayedChild)

    var inAnimation: Animation
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inAnimation.set(value)
            props += _inAnimation
        }

    private val _inAnimation: Property<Animation?, ViewAnimator> = Property(
        "inAnimation", null,
        ViewAnimator::setInAnimation)

    var outAnimation: Animation
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _outAnimation.set(value)
            props += _outAnimation
        }

    private val _outAnimation: Property<Animation?, ViewAnimator> = Property(
        "outAnimation", null,
        ViewAnimator::setOutAnimation)

    var animateFirstView: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animateFirstView.set(value)
            props += _animateFirstView
        }

    private val _animateFirstView: Property<Boolean, ViewAnimator> = Property(
        "animateFirstView",
        false, ViewAnimator::setAnimateFirstView)

    override fun createEmpty(context: Context) = ViewAnimator(context)
}

fun viewSwitcher(f: ViewSwitcher_.() -> Unit) {
    val x = ViewSwitcher_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewSwitcher_ : ViewAnimator_() {
    var factory: ViewSwitcher.ViewFactory
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _factory.set(value)
            props += _factory
        }

    private val _factory: Property<ViewSwitcher.ViewFactory?, ViewSwitcher> = Property(
        "factory",
        null, ViewSwitcher::setFactory)

    override fun createEmpty(context: Context) = ViewSwitcher(context)
}

fun absListView(f: AbsListView_.() -> Unit) {
    val x = AbsListView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AbsListView_ : AdapterView_() {
    var friction: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _friction.set(value)
            props += _friction
        }

    private val _friction: Property<Float, AbsListView> = Property(
        "friction", 0.0f,
        AbsListView::setFriction)

    var remoteViewsAdapter: Intent
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _remoteViewsAdapter.set(value)
            props += _remoteViewsAdapter
        }

    private val _remoteViewsAdapter: Property<Intent?, AbsListView> = Property(
        "remoteViewsAdapter",
        null, AbsListView::setRemoteViewsAdapter)

    var cacheColorHint: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cacheColorHint.set(value)
            props += _cacheColorHint
        }

    private val _cacheColorHint: Property<Int, AbsListView> = Property(
        "cacheColorHint", 0,
        AbsListView::setCacheColorHint)

    var choiceMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _choiceMode.set(value)
            props += _choiceMode
        }

    private val _choiceMode: Property<Int, AbsListView> = Property(
        "choiceMode", 0,
        AbsListView::setChoiceMode)

    var multiChoiceModeListener: AbsListView.MultiChoiceModeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _multiChoiceModeListener.set(value)
            props += _multiChoiceModeListener
        }

    private val _multiChoiceModeListener: Property<AbsListView.MultiChoiceModeListener?,
        AbsListView> = Property(
        "multiChoiceModeListener", null,
        AbsListView::setMultiChoiceModeListener)

    var fastScrollEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fastScrollEnabled.set(value)
            props += _fastScrollEnabled
        }

    private val _fastScrollEnabled: Property<Boolean, AbsListView> = Property(
        "fastScrollEnabled",
        false, AbsListView::setFastScrollEnabled)

    var fastScrollStyle: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fastScrollStyle.set(value)
            props += _fastScrollStyle
        }

    private val _fastScrollStyle: Property<Int, AbsListView> = Property(
        "fastScrollStyle", 0,
        AbsListView::setFastScrollStyle)

    var fastScrollAlwaysVisible: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fastScrollAlwaysVisible.set(value)
            props += _fastScrollAlwaysVisible
        }

    private val _fastScrollAlwaysVisible: Property<Boolean, AbsListView> =
        Property("fastScrollAlwaysVisible", false, AbsListView::setFastScrollAlwaysVisible)

    var smoothScrollbarEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _smoothScrollbarEnabled.set(value)
            props += _smoothScrollbarEnabled
        }

    private val _smoothScrollbarEnabled: Property<Boolean, AbsListView> =
        Property("smoothScrollbarEnabled", false, AbsListView::setSmoothScrollbarEnabled)

    var onScrollListener: AbsListView.OnScrollListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onScrollListener.set(value)
            props += _onScrollListener
        }

    private val _onScrollListener: Property<AbsListView.OnScrollListener?, AbsListView> =
        Property("onScrollListener", null, AbsListView::setOnScrollListener)

    var scrollingCacheEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollingCacheEnabled.set(value)
            props += _scrollingCacheEnabled
        }

    private val _scrollingCacheEnabled: Property<Boolean, AbsListView> =
        Property("scrollingCacheEnabled", false, AbsListView::setScrollingCacheEnabled)

    var textFilterEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textFilterEnabled.set(value)
            props += _textFilterEnabled
        }

    private val _textFilterEnabled: Property<Boolean, AbsListView> = Property(
        "textFilterEnabled",
        false, AbsListView::setTextFilterEnabled)

    var stackFromBottom: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stackFromBottom.set(value)
            props += _stackFromBottom
        }

    private val _stackFromBottom: Property<Boolean, AbsListView> = Property(
        "stackFromBottom",
        false, AbsListView::setStackFromBottom)

    var filterText: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filterText.set(value)
            props += _filterText
        }

    private val _filterText: Property<String?, AbsListView> = Property(
        "filterText", null,
        AbsListView::setFilterText)

    var drawSelectorOnTop: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawSelectorOnTop.set(value)
            props += _drawSelectorOnTop
        }

    private val _drawSelectorOnTop: Property<Boolean, AbsListView> = Property(
        "drawSelectorOnTop",
        false, AbsListView::setDrawSelectorOnTop)

    var velocityScale: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _velocityScale.set(value)
            props += _velocityScale
        }

    private val _velocityScale: Property<Float, AbsListView> = Property(
        "velocityScale", 0.0f,
        AbsListView::setVelocityScale)

    var transcriptMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transcriptMode.set(value)
            props += _transcriptMode
        }

    private val _transcriptMode: Property<Int, AbsListView> = Property(
        "transcriptMode", 0,
        AbsListView::setTranscriptMode)

    var recyclerListener: AbsListView.RecyclerListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _recyclerListener.set(value)
            props += _recyclerListener
        }

    private val _recyclerListener: Property<AbsListView.RecyclerListener?, AbsListView> =
        Property("recyclerListener", null, AbsListView::setRecyclerListener)

    var selector: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selector.set(value)
            props += _selector
        }

    private val _selector: Property<Int, AbsListView> = Property(
        "selector", 0,
        AbsListView::setSelector)
}

fun zoomControls(f: ZoomControls_.() -> Unit) {
    val x = ZoomControls_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ZoomControls_ : LinearLayout_() {
    var zoomSpeed: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _zoomSpeed.set(value)
            props += _zoomSpeed
        }

    private val _zoomSpeed: Property<Long, ZoomControls> = Property(
        "zoomSpeed", 0L,
        ZoomControls::setZoomSpeed)

    var isZoomInEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _isZoomInEnabled.set(value)
            props += _isZoomInEnabled
        }

    private val _isZoomInEnabled: Property<Boolean, ZoomControls> = Property(
        "isZoomInEnabled",
        false, ZoomControls::setIsZoomInEnabled)

    var onZoomInClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onZoomInClickListener.set(value)
            props += _onZoomInClickListener
        }

    private val _onZoomInClickListener: Property<View.OnClickListener?, ZoomControls> =
        Property("onZoomInClickListener", null, ZoomControls::setOnZoomInClickListener)

    var onZoomOutClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onZoomOutClickListener.set(value)
            props += _onZoomOutClickListener
        }

    private val _onZoomOutClickListener: Property<View.OnClickListener?, ZoomControls> =
        Property("onZoomOutClickListener", null, ZoomControls::setOnZoomOutClickListener)

    var isZoomOutEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _isZoomOutEnabled.set(value)
            props += _isZoomOutEnabled
        }

    private val _isZoomOutEnabled: Property<Boolean, ZoomControls> = Property(
        "isZoomOutEnabled",
        false, ZoomControls::setIsZoomOutEnabled)

    override fun createEmpty(context: Context) = ZoomControls(context)
}

fun horizontalScrollView(f: HorizontalScrollView_.() -> Unit) {
    val x = HorizontalScrollView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class HorizontalScrollView_ : FrameLayout_() {
    var fillViewport: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fillViewport.set(value)
            props += _fillViewport
        }

    private val _fillViewport: Property<Boolean, HorizontalScrollView> = Property(
        "fillViewport",
        false, HorizontalScrollView::setFillViewport)

    var smoothScrollingEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _smoothScrollingEnabled.set(value)
            props += _smoothScrollingEnabled
        }

    private val _smoothScrollingEnabled: Property<Boolean, HorizontalScrollView> =
        Property(
            "smoothScrollingEnabled", false,
            HorizontalScrollView::setSmoothScrollingEnabled)

    override fun createEmpty(context: Context) = HorizontalScrollView(context)
}

fun imageView(f: ImageView_.() -> Unit) {
    val x = ImageView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ImageView_ : View_() {
    var maxHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxHeight.set(value)
            props += _maxHeight
        }

    private val _maxHeight: Property<Int, ImageView> = Property(
        "maxHeight", 0,
        ImageView::setMaxHeight)

    var maxWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxWidth.set(value)
            props += _maxWidth
        }

    private val _maxWidth: Property<Int, ImageView> = Property(
        "maxWidth", 0,
        ImageView::setMaxWidth)

    var adjustViewBounds: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _adjustViewBounds.set(value)
            props += _adjustViewBounds
        }

    private val _adjustViewBounds: Property<Boolean, ImageView> = Property(
        "adjustViewBounds",
        false, ImageView::setAdjustViewBounds)

    var imageResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageResource.set(value)
            props += _imageResource
        }

    private val _imageResource: Property<Int, ImageView> = Property(
        "imageResource", 0,
        ImageView::setImageResource)

    var imageURI: Uri
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageURI.set(value)
            props += _imageURI
        }

    private val _imageURI: Property<Uri?, ImageView> = Property(
        "imageURI", null,
        ImageView::setImageURI)

    var imageDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageDrawable.set(value)
            props += _imageDrawable
        }

    private val _imageDrawable: Property<Drawable?, ImageView> = Property(
        "imageDrawable", null,
        ImageView::setImageDrawable)

    var imageTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageTintList.set(value)
            props += _imageTintList
        }

    private val _imageTintList: Property<ColorStateList?, ImageView> = Property(
        "imageTintList",
        null, ImageView::setImageTintList)

    var imageTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageTintMode.set(value)
            props += _imageTintMode
        }

    private val _imageTintMode: Property<PorterDuff.Mode?, ImageView> = Property(
        "imageTintMode",
        null, ImageView::setImageTintMode)

    var imageBitmap: Bitmap
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageBitmap.set(value)
            props += _imageBitmap
        }

    private val _imageBitmap: Property<Bitmap?, ImageView> = Property(
        "imageBitmap", null,
        ImageView::setImageBitmap)

    var imageLevel: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageLevel.set(value)
            props += _imageLevel
        }

    private val _imageLevel: Property<Int, ImageView> = Property(
        "imageLevel", 0,
        ImageView::setImageLevel)

    var scaleType: ImageView.ScaleType
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scaleType.set(value)
            props += _scaleType
        }

    private val _scaleType: Property<ImageView.ScaleType?, ImageView> = Property(
        "scaleType", null,
        ImageView::setScaleType)

    var imageMatrix: Matrix
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageMatrix.set(value)
            props += _imageMatrix
        }

    private val _imageMatrix: Property<Matrix?, ImageView> = Property(
        "imageMatrix", null,
        ImageView::setImageMatrix)

    var cropToPadding: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cropToPadding.set(value)
            props += _cropToPadding
        }

    private val _cropToPadding: Property<Boolean, ImageView> = Property(
        "cropToPadding", false,
        ImageView::setCropToPadding)

    var baseline: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baseline.set(value)
            props += _baseline
        }

    private val _baseline: Property<Int, ImageView> = Property(
        "baseline", 0,
        ImageView::setBaseline)

    var baselineAlignBottom: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAlignBottom.set(value)
            props += _baselineAlignBottom
        }

    private val _baselineAlignBottom: Property<Boolean, ImageView> = Property(
        "baselineAlignBottom",
        false, ImageView::setBaselineAlignBottom)

    var imageAlpha: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageAlpha.set(value)
            props += _imageAlpha
        }

    private val _imageAlpha: Property<Int, ImageView> = Property(
        "imageAlpha", 0,
        ImageView::setImageAlpha)

    var colorFilter: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _colorFilter.set(value)
            props += _colorFilter
        }

    private val _colorFilter: Property<Int, ImageView> = Property(
        "colorFilter", 0,
        ImageView::setColorFilter)

    override fun createEmpty(context: Context) = ImageView(context)
}

fun adapterView(f: AdapterView_.() -> Unit) {
    val x = AdapterView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AdapterView_ : ViewGroup_() {
    var adapter: Adapter
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _adapter.set(value)
            props += _adapter
        }

    private val _adapter: Property<Adapter?, AdapterView<Adapter>> = Property(
        "adapter", null,
        AdapterView<Adapter>::setAdapter)

    var selection: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selection.set(value)
            props += _selection
        }

    private val _selection: Property<Int, AdapterView<Adapter>> = Property(
        "selection", 0,
        AdapterView<Adapter>::setSelection)

    var onItemClickListener: AdapterView.OnItemClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onItemClickListener.set(value)
            props += _onItemClickListener
        }

    private val _onItemClickListener: Property<AdapterView.OnItemClickListener?,
        AdapterView<Adapter>> = Property(
        "onItemClickListener", null,
        AdapterView<Adapter>::setOnItemClickListener)

    var onItemLongClickListener: AdapterView.OnItemLongClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onItemLongClickListener.set(value)
            props += _onItemLongClickListener
        }

    private val _onItemLongClickListener: Property<AdapterView.OnItemLongClickListener?,
        AdapterView<Adapter>> = Property(
        "onItemLongClickListener", null,
        AdapterView<Adapter>::setOnItemLongClickListener)

    var onItemSelectedListener: AdapterView.OnItemSelectedListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onItemSelectedListener.set(value)
            props += _onItemSelectedListener
        }

    private val _onItemSelectedListener: Property<AdapterView.OnItemSelectedListener?,
        AdapterView<Adapter>> = Property(
        "onItemSelectedListener", null,
        AdapterView<Adapter>::setOnItemSelectedListener)

    var emptyView: View
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _emptyView.set(value)
            props += _emptyView
        }

    private val _emptyView: Property<View?, AdapterView<Adapter>> = Property(
        "emptyView", null,
        AdapterView<Adapter>::setEmptyView)
}

fun switch(f: Switch_.() -> Unit) {
    val x = Switch_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Switch_ : CompoundButton_() {
    var splitTrack: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _splitTrack.set(value)
            props += _splitTrack
        }

    private val _splitTrack: Property<Boolean, Switch> = Property(
        "splitTrack", false,
        Switch::setSplitTrack)

    var switchTypeface: Typeface
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchTypeface.set(value)
            props += _switchTypeface
        }

    private val _switchTypeface: Property<Typeface?, Switch> = Property(
        "switchTypeface", null,
        Switch::setSwitchTypeface)

    var switchPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchPadding.set(value)
            props += _switchPadding
        }

    private val _switchPadding: Property<Int, Switch> = Property(
        "switchPadding", 0,
        Switch::setSwitchPadding)

    var switchMinWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchMinWidth.set(value)
            props += _switchMinWidth
        }

    private val _switchMinWidth: Property<Int, Switch> = Property(
        "switchMinWidth", 0,
        Switch::setSwitchMinWidth)

    var thumbTextPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTextPadding.set(value)
            props += _thumbTextPadding
        }

    private val _thumbTextPadding: Property<Int, Switch> = Property(
        "thumbTextPadding", 0,
        Switch::setThumbTextPadding)

    var trackDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackDrawable.set(value)
            props += _trackDrawable
        }

    private val _trackDrawable: Property<Drawable?, Switch> = Property(
        "trackDrawable", null,
        Switch::setTrackDrawable)

    var trackResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackResource.set(value)
            props += _trackResource
        }

    private val _trackResource: Property<Int, Switch> = Property(
        "trackResource", 0,
        Switch::setTrackResource)

    var thumbDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbDrawable.set(value)
            props += _thumbDrawable
        }

    private val _thumbDrawable: Property<Drawable?, Switch> = Property(
        "thumbDrawable", null,
        Switch::setThumbDrawable)

    var thumbResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbResource.set(value)
            props += _thumbResource
        }

    private val _thumbResource: Property<Int, Switch> = Property(
        "thumbResource", 0,
        Switch::setThumbResource)

    var textOn: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOn.set(value)
            props += _textOn
        }

    private val _textOn: Property<CharSequence?, Switch> = Property(
        "textOn", null,
        Switch::setTextOn)

    var textOff: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOff.set(value)
            props += _textOff
        }

    private val _textOff: Property<CharSequence?, Switch> = Property(
        "textOff", null,
        Switch::setTextOff)

    var showText: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showText.set(value)
            props += _showText
        }

    private val _showText: Property<Boolean, Switch> = Property(
        "showText", false,
        Switch::setShowText)

    override fun createEmpty(context: Context) = Switch(context)
}

fun radioButton(f: RadioButton_.() -> Unit) {
    val x = RadioButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class RadioButton_ : CompoundButton_() {
    override fun createEmpty(context: Context) = RadioButton(context)
}

fun adapterViewAnimator(f: AdapterViewAnimator_.() -> Unit) {
    val x = AdapterViewAnimator_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AdapterViewAnimator_ : AdapterView_() {
    var remoteViewsAdapter: Intent
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _remoteViewsAdapter.set(value)
            props += _remoteViewsAdapter
        }

    private val _remoteViewsAdapter: Property<Intent?, AdapterViewAnimator> =
        Property("remoteViewsAdapter", null, AdapterViewAnimator::setRemoteViewsAdapter)

    var displayedChild: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _displayedChild.set(value)
            props += _displayedChild
        }

    private val _displayedChild: Property<Int, AdapterViewAnimator> = Property(
        "displayedChild", 0,
        AdapterViewAnimator::setDisplayedChild)

    var inAnimation: ObjectAnimator
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inAnimation.set(value)
            props += _inAnimation
        }

    private val _inAnimation: Property<ObjectAnimator?, AdapterViewAnimator> =
        Property("inAnimation", null, AdapterViewAnimator::setInAnimation)

    var outAnimation: ObjectAnimator
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _outAnimation.set(value)
            props += _outAnimation
        }

    private val _outAnimation: Property<ObjectAnimator?, AdapterViewAnimator> =
        Property("outAnimation", null, AdapterViewAnimator::setOutAnimation)

    var animateFirstView: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animateFirstView.set(value)
            props += _animateFirstView
        }

    private val _animateFirstView: Property<Boolean, AdapterViewAnimator> =
        Property("animateFirstView", false, AdapterViewAnimator::setAnimateFirstView)
}

fun dialerFilter(f: DialerFilter_.() -> Unit) {
    val x = DialerFilter_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class DialerFilter_ : RelativeLayout_() {
    var lettersWatcher: TextWatcher
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _lettersWatcher.set(value)
            props += _lettersWatcher
        }

    private val _lettersWatcher: Property<TextWatcher?, DialerFilter> = Property(
        "lettersWatcher",
        null, DialerFilter::setLettersWatcher)

    var digitsWatcher: TextWatcher
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _digitsWatcher.set(value)
            props += _digitsWatcher
        }

    private val _digitsWatcher: Property<TextWatcher?, DialerFilter> = Property(
        "digitsWatcher",
        null, DialerFilter::setDigitsWatcher)

    var filterWatcher: TextWatcher
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filterWatcher.set(value)
            props += _filterWatcher
        }

    private val _filterWatcher: Property<TextWatcher?, DialerFilter> = Property(
        "filterWatcher",
        null, DialerFilter::setFilterWatcher)

    var mode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _mode.set(value)
            props += _mode
        }

    private val _mode: Property<Int, DialerFilter> = Property("mode", 0, DialerFilter::setMode)

    override fun createEmpty(context: Context) = DialerFilter(context)
}

fun seekBar(f: SeekBar_.() -> Unit) {
    val x = SeekBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class SeekBar_ : AbsSeekBar_() {
    var onSeekBarChangeListener: SeekBar.OnSeekBarChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onSeekBarChangeListener.set(value)
            props += _onSeekBarChangeListener
        }

    private val _onSeekBarChangeListener: Property<SeekBar.OnSeekBarChangeListener?, SeekBar> =
        Property("onSeekBarChangeListener", null, SeekBar::setOnSeekBarChangeListener)

    override fun createEmpty(context: Context) = SeekBar(context)
}

fun checkBox(f: CheckBox_.() -> Unit) {
    val x = CheckBox_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class CheckBox_ : CompoundButton_() {
    override fun createEmpty(context: Context) = CheckBox(context)
}

fun stackView(f: StackView_.() -> Unit) {
    val x = StackView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class StackView_ : AdapterViewAnimator_() {
    override fun createEmpty(context: Context) = StackView(context)
}

fun imageSwitcher(f: ImageSwitcher_.() -> Unit) {
    val x = ImageSwitcher_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ImageSwitcher_ : ViewSwitcher_() {
    var imageResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageResource.set(value)
            props += _imageResource
        }

    private val _imageResource: Property<Int, ImageSwitcher> = Property(
        "imageResource", 0,
        ImageSwitcher::setImageResource)

    var imageURI: Uri
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageURI.set(value)
            props += _imageURI
        }

    private val _imageURI: Property<Uri?, ImageSwitcher> = Property(
        "imageURI", null,
        ImageSwitcher::setImageURI)

    var imageDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imageDrawable.set(value)
            props += _imageDrawable
        }

    private val _imageDrawable: Property<Drawable?, ImageSwitcher> = Property(
        "imageDrawable", null,
        ImageSwitcher::setImageDrawable)

    override fun createEmpty(context: Context) = ImageSwitcher(context)
}

fun toggleButton(f: ToggleButton_.() -> Unit) {
    val x = ToggleButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ToggleButton_ : CompoundButton_() {
    var textOn: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOn.set(value)
            props += _textOn
        }

    private val _textOn: Property<CharSequence?, ToggleButton> = Property(
        "textOn", null,
        ToggleButton::setTextOn)

    var textOff: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOff.set(value)
            props += _textOff
        }

    private val _textOff: Property<CharSequence?, ToggleButton> = Property(
        "textOff", null,
        ToggleButton::setTextOff)

    override fun createEmpty(context: Context) = ToggleButton(context)
}

fun calendarView(f: CalendarView_.() -> Unit) {
    val x = CalendarView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class CalendarView_ : FrameLayout_() {
    var shownWeekCount: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _shownWeekCount.set(value)
            props += _shownWeekCount
        }

    private val _shownWeekCount: Property<Int, CalendarView> = Property(
        "shownWeekCount", 0,
        CalendarView::setShownWeekCount)

    var selectedWeekBackgroundColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selectedWeekBackgroundColor.set(value)
            props += _selectedWeekBackgroundColor
        }

    private val _selectedWeekBackgroundColor: Property<Int, CalendarView> =
        Property("selectedWeekBackgroundColor", 0, CalendarView::setSelectedWeekBackgroundColor)

    var focusedMonthDateColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _focusedMonthDateColor.set(value)
            props += _focusedMonthDateColor
        }

    private val _focusedMonthDateColor: Property<Int, CalendarView> =
        Property("focusedMonthDateColor", 0, CalendarView::setFocusedMonthDateColor)

    var unfocusedMonthDateColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _unfocusedMonthDateColor.set(value)
            props += _unfocusedMonthDateColor
        }

    private val _unfocusedMonthDateColor: Property<Int, CalendarView> =
        Property("unfocusedMonthDateColor", 0, CalendarView::setUnfocusedMonthDateColor)

    var weekNumberColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weekNumberColor.set(value)
            props += _weekNumberColor
        }

    private val _weekNumberColor: Property<Int, CalendarView> = Property(
        "weekNumberColor", 0,
        CalendarView::setWeekNumberColor)

    var weekSeparatorLineColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weekSeparatorLineColor.set(value)
            props += _weekSeparatorLineColor
        }

    private val _weekSeparatorLineColor: Property<Int, CalendarView> =
        Property("weekSeparatorLineColor", 0, CalendarView::setWeekSeparatorLineColor)

    var weekDayTextAppearance: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weekDayTextAppearance.set(value)
            props += _weekDayTextAppearance
        }

    private val _weekDayTextAppearance: Property<Int, CalendarView> =
        Property("weekDayTextAppearance", 0, CalendarView::setWeekDayTextAppearance)

    var dateTextAppearance: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dateTextAppearance.set(value)
            props += _dateTextAppearance
        }

    private val _dateTextAppearance: Property<Int, CalendarView> = Property(
        "dateTextAppearance", 0,
        CalendarView::setDateTextAppearance)

    var showWeekNumber: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showWeekNumber.set(value)
            props += _showWeekNumber
        }

    private val _showWeekNumber: Property<Boolean, CalendarView> = Property(
        "showWeekNumber", false,
        CalendarView::setShowWeekNumber)

    var onDateChangeListener: CalendarView.OnDateChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onDateChangeListener.set(value)
            props += _onDateChangeListener
        }

    private val _onDateChangeListener: Property<CalendarView.OnDateChangeListener?, CalendarView> =
        Property("onDateChangeListener", null, CalendarView::setOnDateChangeListener)

    var minDate: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minDate.set(value)
            props += _minDate
        }

    private val _minDate: Property<Long, CalendarView> = Property(
        "minDate", 0L,
        CalendarView::setMinDate)

    var maxDate: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxDate.set(value)
            props += _maxDate
        }

    private val _maxDate: Property<Long, CalendarView> = Property(
        "maxDate", 0L,
        CalendarView::setMaxDate)

    var selectedDateVerticalBar: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selectedDateVerticalBar.set(value)
            props += _selectedDateVerticalBar
        }

    private val _selectedDateVerticalBar: Property<Int, CalendarView> =
        Property("selectedDateVerticalBar", 0, CalendarView::setSelectedDateVerticalBar)

    var firstDayOfWeek: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _firstDayOfWeek.set(value)
            props += _firstDayOfWeek
        }

    private val _firstDayOfWeek: Property<Int, CalendarView> = Property(
        "firstDayOfWeek", 0,
        CalendarView::setFirstDayOfWeek)

    var date: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _date.set(value)
            props += _date
        }

    private val _date: Property<Long, CalendarView> = Property("date", 0L, CalendarView::setDate)

    override fun createEmpty(context: Context) = CalendarView(context)
}

fun actionMenuView(f: ActionMenuView_.() -> Unit) {
    val x = ActionMenuView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ActionMenuView_ : LinearLayout_() {
    var popupTheme: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _popupTheme.set(value)
            props += _popupTheme
        }

    private val _popupTheme: Property<Int, ActionMenuView> = Property(
        "popupTheme", 0,
        ActionMenuView::setPopupTheme)

    var onMenuItemClickListener: ActionMenuView.OnMenuItemClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onMenuItemClickListener.set(value)
            props += _onMenuItemClickListener
        }

    private val _onMenuItemClickListener: Property<ActionMenuView.OnMenuItemClickListener?,
        ActionMenuView> = Property(
        "onMenuItemClickListener", null,
        ActionMenuView::setOnMenuItemClickListener)

    override fun createEmpty(context: Context) = ActionMenuView(context)
}

fun space(f: Space_.() -> Unit) {
    val x = Space_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Space_ : View_() {
    override fun createEmpty(context: Context) = Space(context)
}

fun gridLayout(f: GridLayout_.() -> Unit) {
    val x = GridLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class GridLayout_ : ViewGroup_() {
    var orientation: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, GridLayout> = Property(
        "orientation", 0,
        GridLayout::setOrientation)

    var rowCount: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rowCount.set(value)
            props += _rowCount
        }

    private val _rowCount: Property<Int, GridLayout> = Property(
        "rowCount", 0,
        GridLayout::setRowCount)

    var useDefaultMargins: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _useDefaultMargins.set(value)
            props += _useDefaultMargins
        }

    private val _useDefaultMargins: Property<Boolean, GridLayout> = Property(
        "useDefaultMargins",
        false, GridLayout::setUseDefaultMargins)

    var alignmentMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _alignmentMode.set(value)
            props += _alignmentMode
        }

    private val _alignmentMode: Property<Int, GridLayout> = Property(
        "alignmentMode", 0,
        GridLayout::setAlignmentMode)

    var rowOrderPreserved: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rowOrderPreserved.set(value)
            props += _rowOrderPreserved
        }

    private val _rowOrderPreserved: Property<Boolean, GridLayout> = Property(
        "rowOrderPreserved",
        false, GridLayout::setRowOrderPreserved)

    var columnOrderPreserved: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _columnOrderPreserved.set(value)
            props += _columnOrderPreserved
        }

    private val _columnOrderPreserved: Property<Boolean, GridLayout> =
        Property("columnOrderPreserved", false, GridLayout::setColumnOrderPreserved)

    var columnCount: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _columnCount.set(value)
            props += _columnCount
        }

    private val _columnCount: Property<Int, GridLayout> = Property(
        "columnCount", 0,
        GridLayout::setColumnCount)

    override fun createEmpty(context: Context) = GridLayout(context)
}

fun editText(f: EditText_.() -> Unit) {
    val x = EditText_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class EditText_ : TextView_() {
    var selection: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selection.set(value)
            props += _selection
        }

    private val _selection: Property<Int, EditText> = Property(
        "selection", 0,
        EditText::setSelection)

    override fun createEmpty(context: Context) = EditText(context)
}

fun gridView(f: GridView_.() -> Unit) {
    val x = GridView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class GridView_ : AbsListView_() {
    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, GridView> = Property("gravity", 0, GridView::setGravity)

    var horizontalSpacing: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalSpacing.set(value)
            props += _horizontalSpacing
        }

    private val _horizontalSpacing: Property<Int, GridView> = Property(
        "horizontalSpacing", 0,
        GridView::setHorizontalSpacing)

    var verticalSpacing: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalSpacing.set(value)
            props += _verticalSpacing
        }

    private val _verticalSpacing: Property<Int, GridView> = Property(
        "verticalSpacing", 0,
        GridView::setVerticalSpacing)

    var stretchMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stretchMode.set(value)
            props += _stretchMode
        }

    private val _stretchMode: Property<Int, GridView> = Property(
        "stretchMode", 0,
        GridView::setStretchMode)

    var columnWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _columnWidth.set(value)
            props += _columnWidth
        }

    private val _columnWidth: Property<Int, GridView> = Property(
        "columnWidth", 0,
        GridView::setColumnWidth)

    var numColumns: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _numColumns.set(value)
            props += _numColumns
        }

    private val _numColumns: Property<Int, GridView> = Property(
        "numColumns", 0,
        GridView::setNumColumns)

    override fun createEmpty(context: Context) = GridView(context)
}

fun tabWidget(f: TabWidget_.() -> Unit) {
    val x = TabWidget_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TabWidget_ : LinearLayout_() {
    var stripEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stripEnabled.set(value)
            props += _stripEnabled
        }

    private val _stripEnabled: Property<Boolean, TabWidget> = Property(
        "stripEnabled", false,
        TabWidget::setStripEnabled)

    var currentTab: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _currentTab.set(value)
            props += _currentTab
        }

    private val _currentTab: Property<Int, TabWidget> = Property(
        "currentTab", 0,
        TabWidget::setCurrentTab)

    var leftStripDrawable: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _leftStripDrawable.set(value)
            props += _leftStripDrawable
        }

    private val _leftStripDrawable: Property<Int, TabWidget> = Property(
        "leftStripDrawable", 0,
        TabWidget::setLeftStripDrawable)

    var rightStripDrawable: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rightStripDrawable.set(value)
            props += _rightStripDrawable
        }

    private val _rightStripDrawable: Property<Int, TabWidget> = Property(
        "rightStripDrawable", 0,
        TabWidget::setRightStripDrawable)

    override fun createEmpty(context: Context) = TabWidget(context)
}

fun tabHost(f: TabHost_.() -> Unit) {
    val x = TabHost_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TabHost_ : FrameLayout_() {
    var currentTab: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _currentTab.set(value)
            props += _currentTab
        }

    private val _currentTab: Property<Int, TabHost> = Property(
        "currentTab", 0,
        TabHost::setCurrentTab)

    var currentTabByTag: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _currentTabByTag.set(value)
            props += _currentTabByTag
        }

    private val _currentTabByTag: Property<String?, TabHost> = Property(
        "currentTabByTag", null,
        TabHost::setCurrentTabByTag)

    var onTabChangedListener: TabHost.OnTabChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onTabChangedListener.set(value)
            props += _onTabChangedListener
        }

    private val _onTabChangedListener: Property<TabHost.OnTabChangeListener?, TabHost> =
        Property("onTabChangedListener", null, TabHost::setOnTabChangedListener)

    override fun createEmpty(context: Context) = TabHost(context)
}

fun radioGroup(f: RadioGroup_.() -> Unit) {
    val x = RadioGroup_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class RadioGroup_ : LinearLayout_() {
    var onCheckedChangeListener: RadioGroup.OnCheckedChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCheckedChangeListener.set(value)
            props += _onCheckedChangeListener
        }

    private val _onCheckedChangeListener: Property<RadioGroup.OnCheckedChangeListener?, RadioGroup> =
        Property("onCheckedChangeListener", null, RadioGroup::setOnCheckedChangeListener)

    override fun createEmpty(context: Context) = RadioGroup(context)
}

fun scrollView(f: ScrollView_.() -> Unit) {
    val x = ScrollView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ScrollView_ : FrameLayout_() {
    var fillViewport: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fillViewport.set(value)
            props += _fillViewport
        }

    private val _fillViewport: Property<Boolean, ScrollView> = Property(
        "fillViewport", false,
        ScrollView::setFillViewport)

    var smoothScrollingEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _smoothScrollingEnabled.set(value)
            props += _smoothScrollingEnabled
        }

    private val _smoothScrollingEnabled: Property<Boolean, ScrollView> =
        Property("smoothScrollingEnabled", false, ScrollView::setSmoothScrollingEnabled)

    override fun createEmpty(context: Context) = ScrollView(context)
}

fun absSeekBar(f: AbsSeekBar_.() -> Unit) {
    val x = AbsSeekBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AbsSeekBar_ : ProgressBar_() {
    var thumb: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumb.set(value)
            props += _thumb
        }

    private val _thumb: Property<Drawable?, AbsSeekBar> = Property(
        "thumb", null,
        AbsSeekBar::setThumb)

    var thumbTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTintList.set(value)
            props += _thumbTintList
        }

    private val _thumbTintList: Property<ColorStateList?, AbsSeekBar> = Property(
        "thumbTintList",
        null, AbsSeekBar::setThumbTintList)

    var thumbTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTintMode.set(value)
            props += _thumbTintMode
        }

    private val _thumbTintMode: Property<PorterDuff.Mode?, AbsSeekBar> = Property(
        "thumbTintMode",
        null, AbsSeekBar::setThumbTintMode)

    var thumbOffset: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbOffset.set(value)
            props += _thumbOffset
        }

    private val _thumbOffset: Property<Int, AbsSeekBar> = Property(
        "thumbOffset", 0,
        AbsSeekBar::setThumbOffset)

    var splitTrack: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _splitTrack.set(value)
            props += _splitTrack
        }

    private val _splitTrack: Property<Boolean, AbsSeekBar> = Property(
        "splitTrack", false,
        AbsSeekBar::setSplitTrack)

    var keyProgressIncrement: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _keyProgressIncrement.set(value)
            props += _keyProgressIncrement
        }

    private val _keyProgressIncrement: Property<Int, AbsSeekBar> = Property(
        "keyProgressIncrement",
        0, AbsSeekBar::setKeyProgressIncrement)
}

fun linearLayout(f: LinearLayout_.() -> Unit) {
    val x = LinearLayout_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class LinearLayout_ : ViewGroup_() {
    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, LinearLayout> = Property(
        "gravity", 0,
        LinearLayout::setGravity)

    var horizontalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalGravity.set(value)
            props += _horizontalGravity
        }

    private val _horizontalGravity: Property<Int, LinearLayout> = Property(
        "horizontalGravity", 0,
        LinearLayout::setHorizontalGravity)

    var verticalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalGravity.set(value)
            props += _verticalGravity
        }

    private val _verticalGravity: Property<Int, LinearLayout> = Property(
        "verticalGravity", 0,
        LinearLayout::setVerticalGravity)

    var showDividers: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showDividers.set(value)
            props += _showDividers
        }

    private val _showDividers: Property<Int, LinearLayout> = Property(
        "showDividers", 0,
        LinearLayout::setShowDividers)

    var dividerDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerDrawable.set(value)
            props += _dividerDrawable
        }

    private val _dividerDrawable: Property<Drawable?, LinearLayout> = Property(
        "dividerDrawable",
        null, LinearLayout::setDividerDrawable)

    var dividerPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerPadding.set(value)
            props += _dividerPadding
        }

    private val _dividerPadding: Property<Int, LinearLayout> = Property(
        "dividerPadding", 0,
        LinearLayout::setDividerPadding)

    var baselineAligned: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAligned.set(value)
            props += _baselineAligned
        }

    private val _baselineAligned: Property<Boolean, LinearLayout> = Property(
        "baselineAligned",
        false, LinearLayout::setBaselineAligned)

    var measureWithLargestChildEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _measureWithLargestChildEnabled.set(value)
            props += _measureWithLargestChildEnabled
        }

    private val _measureWithLargestChildEnabled: Property<Boolean, LinearLayout> =
        Property(
            "measureWithLargestChildEnabled", false,
            LinearLayout::setMeasureWithLargestChildEnabled)

    var baselineAlignedChildIndex: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAlignedChildIndex.set(value)
            props += _baselineAlignedChildIndex
        }

    private val _baselineAlignedChildIndex: Property<Int, LinearLayout> =
        Property("baselineAlignedChildIndex", 0, LinearLayout::setBaselineAlignedChildIndex)

    var weightSum: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weightSum.set(value)
            props += _weightSum
        }

    private val _weightSum: Property<Float, LinearLayout> = Property(
        "weightSum", 0.0f,
        LinearLayout::setWeightSum)

    var orientation: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, LinearLayout> = Property(
        "orientation", 0,
        LinearLayout::setOrientation)

    override fun createEmpty(context: Context) = LinearLayout(context)
}

fun mediaRouteButton(f: MediaRouteButton_.() -> Unit) {
    val x = MediaRouteButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class MediaRouteButton_ : View_() {
    var routeTypes: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _routeTypes.set(value)
            props += _routeTypes
        }

    private val _routeTypes: Property<Int, MediaRouteButton> = Property(
        "routeTypes", 0,
        MediaRouteButton::setRouteTypes)

    var extendedSettingsClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _extendedSettingsClickListener.set(value)
            props += _extendedSettingsClickListener
        }

    private val _extendedSettingsClickListener: Property<View.OnClickListener?, MediaRouteButton> =
        Property(
            "extendedSettingsClickListener", null,
            MediaRouteButton::setExtendedSettingsClickListener)

    override fun createEmpty(context: Context) = MediaRouteButton(context)
}

fun tvView(f: TvView_.() -> Unit) {
    val x = TvView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TvView_ : ViewGroup_() {
    var captionEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _captionEnabled.set(value)
            props += _captionEnabled
        }

    private val _captionEnabled: Property<Boolean, TvView> = Property(
        "captionEnabled", false,
        TvView::setCaptionEnabled)

    var callback: TvView.TvInputCallback
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _callback.set(value)
            props += _callback
        }

    private val _callback: Property<TvView.TvInputCallback?, TvView> = Property(
        "callback", null,
        TvView::setCallback)

    var streamVolume: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _streamVolume.set(value)
            props += _streamVolume
        }

    private val _streamVolume: Property<Float, TvView> = Property(
        "streamVolume", 0.0f,
        TvView::setStreamVolume)

    var onUnhandledInputEventListener: TvView.OnUnhandledInputEventListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onUnhandledInputEventListener.set(value)
            props += _onUnhandledInputEventListener
        }

    private val _onUnhandledInputEventListener: Property<TvView.OnUnhandledInputEventListener?,
        TvView> = Property(
        "onUnhandledInputEventListener", null,
        TvView::setOnUnhandledInputEventListener)

    override fun createEmpty(context: Context) = TvView(context)
}

fun gestureOverlayView(f: GestureOverlayView_.() -> Unit) {
    val x = GestureOverlayView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class GestureOverlayView_ : FrameLayout_() {
    var orientation: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, GestureOverlayView> = Property(
        "orientation", 0,
        GestureOverlayView::setOrientation)

    var gestureColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureColor.set(value)
            props += _gestureColor
        }

    private val _gestureColor: Property<Int, GestureOverlayView> = Property(
        "gestureColor", 0,
        GestureOverlayView::setGestureColor)

    var uncertainGestureColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _uncertainGestureColor.set(value)
            props += _uncertainGestureColor
        }

    private val _uncertainGestureColor: Property<Int, GestureOverlayView> =
        Property("uncertainGestureColor", 0, GestureOverlayView::setUncertainGestureColor)

    var gestureStrokeWidth: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureStrokeWidth.set(value)
            props += _gestureStrokeWidth
        }

    private val _gestureStrokeWidth: Property<Float, GestureOverlayView> =
        Property("gestureStrokeWidth", 0.0f, GestureOverlayView::setGestureStrokeWidth)

    var gestureStrokeType: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureStrokeType.set(value)
            props += _gestureStrokeType
        }

    private val _gestureStrokeType: Property<Int, GestureOverlayView> =
        Property("gestureStrokeType", 0, GestureOverlayView::setGestureStrokeType)

    var gestureStrokeLengthThreshold: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureStrokeLengthThreshold.set(value)
            props += _gestureStrokeLengthThreshold
        }

    private val _gestureStrokeLengthThreshold: Property<Float, GestureOverlayView> =
        Property(
            "gestureStrokeLengthThreshold", 0.0f,
            GestureOverlayView::setGestureStrokeLengthThreshold)

    var gestureStrokeSquarenessTreshold: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureStrokeSquarenessTreshold.set(value)
            props += _gestureStrokeSquarenessTreshold
        }

    private val _gestureStrokeSquarenessTreshold: Property<Float, GestureOverlayView> =
        Property(
            "gestureStrokeSquarenessTreshold", 0.0f,
            GestureOverlayView::setGestureStrokeSquarenessTreshold)

    var gestureStrokeAngleThreshold: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureStrokeAngleThreshold.set(value)
            props += _gestureStrokeAngleThreshold
        }

    private val _gestureStrokeAngleThreshold: Property<Float, GestureOverlayView> =
        Property(
            "gestureStrokeAngleThreshold", 0.0f,
            GestureOverlayView::setGestureStrokeAngleThreshold)

    var eventsInterceptionEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _eventsInterceptionEnabled.set(value)
            props += _eventsInterceptionEnabled
        }

    private val _eventsInterceptionEnabled: Property<Boolean, GestureOverlayView> =
        Property(
            "eventsInterceptionEnabled", false,
            GestureOverlayView::setEventsInterceptionEnabled)

    var fadeEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fadeEnabled.set(value)
            props += _fadeEnabled
        }

    private val _fadeEnabled: Property<Boolean, GestureOverlayView> = Property(
        "fadeEnabled", false,
        GestureOverlayView::setFadeEnabled)

    var gesture: Gesture
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gesture.set(value)
            props += _gesture
        }

    private val _gesture: Property<Gesture?, GestureOverlayView> = Property(
        "gesture", null,
        GestureOverlayView::setGesture)

    var gestureVisible: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gestureVisible.set(value)
            props += _gestureVisible
        }

    private val _gestureVisible: Property<Boolean, GestureOverlayView> = Property(
        "gestureVisible",
        false, GestureOverlayView::setGestureVisible)

    var fadeOffset: Long
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fadeOffset.set(value)
            props += _fadeOffset
        }

    private val _fadeOffset: Property<Long, GestureOverlayView> = Property(
        "fadeOffset", 0L,
        GestureOverlayView::setFadeOffset)

    override fun createEmpty(context: Context) = GestureOverlayView(context)
}

fun surfaceView(f: SurfaceView_.() -> Unit) {
    val x = SurfaceView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class SurfaceView_ : View_() {
    var zOrderMediaOverlay: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _zOrderMediaOverlay.set(value)
            props += _zOrderMediaOverlay
        }

    private val _zOrderMediaOverlay: Property<Boolean, SurfaceView> = Property(
        "zOrderMediaOverlay",
        false, SurfaceView::setZOrderMediaOverlay)

    var zOrderOnTop: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _zOrderOnTop.set(value)
            props += _zOrderOnTop
        }

    private val _zOrderOnTop: Property<Boolean, SurfaceView> = Property(
        "zOrderOnTop", false,
        SurfaceView::setZOrderOnTop)

    var secure: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _secure.set(value)
            props += _secure
        }

    private val _secure: Property<Boolean, SurfaceView> = Property(
        "secure", false,
        SurfaceView::setSecure)

    override fun createEmpty(context: Context) = SurfaceView(context)
}

fun view(f: View_.() -> Unit) {
    val x = View_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class View_ : VirtualNode() {
    var fadingEdgeLength: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fadingEdgeLength.set(value)
            props += _fadingEdgeLength
        }

    private val _fadingEdgeLength: Property<Int, View> = Property(
        "fadingEdgeLength", 0,
        View::setFadingEdgeLength)

    var verticalScrollbarPosition: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalScrollbarPosition.set(value)
            props += _verticalScrollbarPosition
        }

    private val _verticalScrollbarPosition: Property<Int, View> =
        Property("verticalScrollbarPosition", 0, View::setVerticalScrollbarPosition)

    var onFocusChangeListener: View.OnFocusChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onFocusChangeListener.set(value)
            props += _onFocusChangeListener
        }

    private val _onFocusChangeListener: Property<View.OnFocusChangeListener?, View> =
        Property("onFocusChangeListener", null, View::setOnFocusChangeListener)

    var onClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onClickListener.set(value)
            props += _onClickListener
        }

    private val _onClickListener: Property<View.OnClickListener?, View> =
        Property("onClickListener", null, View::setOnClickListener)

    var onLongClickListener: View.OnLongClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onLongClickListener.set(value)
            props += _onLongClickListener
        }

    private val _onLongClickListener: Property<View.OnLongClickListener?, View> =
        Property("onLongClickListener", null, View::setOnLongClickListener)

    var onCreateContextMenuListener: View.OnCreateContextMenuListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCreateContextMenuListener.set(value)
            props += _onCreateContextMenuListener
        }

    private val _onCreateContextMenuListener: Property<View.OnCreateContextMenuListener?, View> =
        Property("onCreateContextMenuListener", null, View::setOnCreateContextMenuListener)

    var onKeyListener: View.OnKeyListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onKeyListener.set(value)
            props += _onKeyListener
        }

    private val _onKeyListener: Property<View.OnKeyListener?, View> = Property(
        "onKeyListener",
        null, View::setOnKeyListener)

    var onTouchListener: View.OnTouchListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onTouchListener.set(value)
            props += _onTouchListener
        }

    private val _onTouchListener: Property<View.OnTouchListener?, View> =
        Property("onTouchListener", null, View::setOnTouchListener)

    var onGenericMotionListener: View.OnGenericMotionListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onGenericMotionListener.set(value)
            props += _onGenericMotionListener
        }

    private val _onGenericMotionListener: Property<View.OnGenericMotionListener?, View> =
        Property("onGenericMotionListener", null, View::setOnGenericMotionListener)

    var onHoverListener: View.OnHoverListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onHoverListener.set(value)
            props += _onHoverListener
        }

    private val _onHoverListener: Property<View.OnHoverListener?, View> =
        Property("onHoverListener", null, View::setOnHoverListener)

    var onDragListener: View.OnDragListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onDragListener.set(value)
            props += _onDragListener
        }

    private val _onDragListener: Property<View.OnDragListener?, View> = Property(
        "onDragListener",
        null, View::setOnDragListener)

    var accessibilityDelegate: View.AccessibilityDelegate
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityDelegate.set(value)
            props += _accessibilityDelegate
        }

    private val _accessibilityDelegate: Property<View.AccessibilityDelegate?, View> =
        Property("accessibilityDelegate", null, View::setAccessibilityDelegate)

    var contentDescription: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _contentDescription.set(value)
            props += _contentDescription
        }

    private val _contentDescription: Property<CharSequence?, View> = Property(
        "contentDescription",
        null, View::setContentDescription)

    var accessibilityTraversalBefore: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityTraversalBefore.set(value)
            props += _accessibilityTraversalBefore
        }

    private val _accessibilityTraversalBefore: Property<Int, View> =
        Property("accessibilityTraversalBefore", 0, View::setAccessibilityTraversalBefore)

    var accessibilityTraversalAfter: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityTraversalAfter.set(value)
            props += _accessibilityTraversalAfter
        }

    private val _accessibilityTraversalAfter: Property<Int, View> =
        Property("accessibilityTraversalAfter", 0, View::setAccessibilityTraversalAfter)

    var labelFor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _labelFor.set(value)
            props += _labelFor
        }

    private val _labelFor: Property<Int, View> = Property("labelFor", 0, View::setLabelFor)

    var scrollContainer: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollContainer.set(value)
            props += _scrollContainer
        }

    private val _scrollContainer: Property<Boolean, View> = Property(
        "scrollContainer", false,
        View::setScrollContainer)

    var drawingCacheQuality: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheQuality.set(value)
            props += _drawingCacheQuality
        }

    private val _drawingCacheQuality: Property<Int, View> = Property(
        "drawingCacheQuality", 0,
        View::setDrawingCacheQuality)

    var keepScreenOn: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _keepScreenOn.set(value)
            props += _keepScreenOn
        }

    private val _keepScreenOn: Property<Boolean, View> = Property(
        "keepScreenOn", false,
        View::setKeepScreenOn)

    var nextFocusLeftId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusLeftId.set(value)
            props += _nextFocusLeftId
        }

    private val _nextFocusLeftId: Property<Int, View> = Property(
        "nextFocusLeftId", 0,
        View::setNextFocusLeftId)

    var nextFocusRightId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusRightId.set(value)
            props += _nextFocusRightId
        }

    private val _nextFocusRightId: Property<Int, View> = Property(
        "nextFocusRightId", 0,
        View::setNextFocusRightId)

    var nextFocusUpId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusUpId.set(value)
            props += _nextFocusUpId
        }

    private val _nextFocusUpId: Property<Int, View> = Property(
        "nextFocusUpId", 0,
        View::setNextFocusUpId)

    var nextFocusDownId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusDownId.set(value)
            props += _nextFocusDownId
        }

    private val _nextFocusDownId: Property<Int, View> = Property(
        "nextFocusDownId", 0,
        View::setNextFocusDownId)

    var nextFocusForwardId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nextFocusForwardId.set(value)
            props += _nextFocusForwardId
        }

    private val _nextFocusForwardId: Property<Int, View> = Property(
        "nextFocusForwardId", 0,
        View::setNextFocusForwardId)

    var onApplyWindowInsetsListener: View.OnApplyWindowInsetsListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onApplyWindowInsetsListener.set(value)
            props += _onApplyWindowInsetsListener
        }

    private val _onApplyWindowInsetsListener: Property<View.OnApplyWindowInsetsListener?, View> =
        Property("onApplyWindowInsetsListener", null, View::setOnApplyWindowInsetsListener)

    var fitsSystemWindows: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _fitsSystemWindows.set(value)
            props += _fitsSystemWindows
        }

    private val _fitsSystemWindows: Property<Boolean, View> = Property(
        "fitsSystemWindows", false,
        View::setFitsSystemWindows)

    var visibility: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _visibility.set(value)
            props += _visibility
        }

    private val _visibility: Property<Int, View> = Property("visibility", 0, View::setVisibility)

    var enabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _enabled.set(value)
            props += _enabled
        }

    private val _enabled: Property<Boolean, View> = Property("enabled", false, View::setEnabled)

    var focusable: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _focusable.set(value)
            props += _focusable
        }

    private val _focusable: Property<Boolean, View> = Property(
        "focusable", false,
        View::setFocusable)

    var focusableInTouchMode: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _focusableInTouchMode.set(value)
            props += _focusableInTouchMode
        }

    private val _focusableInTouchMode: Property<Boolean, View> = Property(
        "focusableInTouchMode",
        false, View::setFocusableInTouchMode)

    var soundEffectsEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _soundEffectsEnabled.set(value)
            props += _soundEffectsEnabled
        }

    private val _soundEffectsEnabled: Property<Boolean, View> = Property(
        "soundEffectsEnabled",
        false, View::setSoundEffectsEnabled)

    var hapticFeedbackEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hapticFeedbackEnabled.set(value)
            props += _hapticFeedbackEnabled
        }

    private val _hapticFeedbackEnabled: Property<Boolean, View> = Property(
        "hapticFeedbackEnabled",
        false, View::setHapticFeedbackEnabled)

    var layoutDirection: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutDirection.set(value)
            props += _layoutDirection
        }

    private val _layoutDirection: Property<Int, View> = Property(
        "layoutDirection", 0,
        View::setLayoutDirection)

    var hasTransientState: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hasTransientState.set(value)
            props += _hasTransientState
        }

    private val _hasTransientState: Property<Boolean, View> = Property(
        "hasTransientState", false,
        View::setHasTransientState)

    var willNotDraw: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _willNotDraw.set(value)
            props += _willNotDraw
        }

    private val _willNotDraw: Property<Boolean, View> = Property(
        "willNotDraw", false,
        View::setWillNotDraw)

    var willNotCacheDrawing: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _willNotCacheDrawing.set(value)
            props += _willNotCacheDrawing
        }

    private val _willNotCacheDrawing: Property<Boolean, View> = Property(
        "willNotCacheDrawing",
        false, View::setWillNotCacheDrawing)

    var clickable: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clickable.set(value)
            props += _clickable
        }

    private val _clickable: Property<Boolean, View> = Property(
        "clickable", false,
        View::setClickable)

    var longClickable: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _longClickable.set(value)
            props += _longClickable
        }

    private val _longClickable: Property<Boolean, View> = Property(
        "longClickable", false,
        View::setLongClickable)

    var pressed: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pressed.set(value)
            props += _pressed
        }

    private val _pressed: Property<Boolean, View> = Property("pressed", false, View::setPressed)

    var saveEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _saveEnabled.set(value)
            props += _saveEnabled
        }

    private val _saveEnabled: Property<Boolean, View> = Property(
        "saveEnabled", false,
        View::setSaveEnabled)

    var filterTouchesWhenObscured: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _filterTouchesWhenObscured.set(value)
            props += _filterTouchesWhenObscured
        }

    private val _filterTouchesWhenObscured: Property<Boolean, View> =
        Property("filterTouchesWhenObscured", false, View::setFilterTouchesWhenObscured)

    var saveFromParentEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _saveFromParentEnabled.set(value)
            props += _saveFromParentEnabled
        }

    private val _saveFromParentEnabled: Property<Boolean, View> = Property(
        "saveFromParentEnabled",
        false, View::setSaveFromParentEnabled)

    var accessibilityLiveRegion: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _accessibilityLiveRegion.set(value)
            props += _accessibilityLiveRegion
        }

    private val _accessibilityLiveRegion: Property<Int, View> = Property(
        "accessibilityLiveRegion",
        0, View::setAccessibilityLiveRegion)

    var importantForAccessibility: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _importantForAccessibility.set(value)
            props += _importantForAccessibility
        }

    private val _importantForAccessibility: Property<Int, View> =
        Property("importantForAccessibility", 0, View::setImportantForAccessibility)

    var hovered: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _hovered.set(value)
            props += _hovered
        }

    private val _hovered: Property<Boolean, View> = Property("hovered", false, View::setHovered)

    var touchDelegate: TouchDelegate
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _touchDelegate.set(value)
            props += _touchDelegate
        }

    private val _touchDelegate: Property<TouchDelegate?, View> = Property(
        "touchDelegate", null,
        View::setTouchDelegate)

    var scrollX: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollX.set(value)
            props += _scrollX
        }

    private val _scrollX: Property<Int, View> = Property("scrollX", 0, View::setScrollX)

    var scrollY: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollY.set(value)
            props += _scrollY
        }

    private val _scrollY: Property<Int, View> = Property("scrollY", 0, View::setScrollY)

    var cameraDistance: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _cameraDistance.set(value)
            props += _cameraDistance
        }

    private val _cameraDistance: Property<Float, View> = Property(
        "cameraDistance", 0.0f,
        View::setCameraDistance)

    var rotation: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotation.set(value)
            props += _rotation
        }

    private val _rotation: Property<Float, View> = Property("rotation", 0.0f, View::setRotation)

    var rotationY: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotationY.set(value)
            props += _rotationY
        }

    private val _rotationY: Property<Float, View> = Property("rotationY", 0.0f, View::setRotationY)

    var rotationX: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _rotationX.set(value)
            props += _rotationX
        }

    private val _rotationX: Property<Float, View> = Property("rotationX", 0.0f, View::setRotationX)

    var scaleX: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scaleX.set(value)
            props += _scaleX
        }

    private val _scaleX: Property<Float, View> = Property("scaleX", 0.0f, View::setScaleX)

    var scaleY: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scaleY.set(value)
            props += _scaleY
        }

    private val _scaleY: Property<Float, View> = Property("scaleY", 0.0f, View::setScaleY)

    var pivotX: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pivotX.set(value)
            props += _pivotX
        }

    private val _pivotX: Property<Float, View> = Property("pivotX", 0.0f, View::setPivotX)

    var pivotY: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _pivotY.set(value)
            props += _pivotY
        }

    private val _pivotY: Property<Float, View> = Property("pivotY", 0.0f, View::setPivotY)

    var alpha: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _alpha.set(value)
            props += _alpha
        }

    private val _alpha: Property<Float, View> = Property("alpha", 0.0f, View::setAlpha)

    var top: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _top.set(value)
            props += _top
        }

    private val _top: Property<Int, View> = Property("top", 0, View::setTop)

    var bottom: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _bottom.set(value)
            props += _bottom
        }

    private val _bottom: Property<Int, View> = Property("bottom", 0, View::setBottom)

    var left: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _left.set(value)
            props += _left
        }

    private val _left: Property<Int, View> = Property("left", 0, View::setLeft)

    var right: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _right.set(value)
            props += _right
        }

    private val _right: Property<Int, View> = Property("right", 0, View::setRight)

    var elevation: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _elevation.set(value)
            props += _elevation
        }

    private val _elevation: Property<Float, View> = Property("elevation", 0.0f, View::setElevation)

    var translationX: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationX.set(value)
            props += _translationX
        }

    private val _translationX: Property<Float, View> = Property(
        "translationX", 0.0f,
        View::setTranslationX)

    var translationY: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationY.set(value)
            props += _translationY
        }

    private val _translationY: Property<Float, View> = Property(
        "translationY", 0.0f,
        View::setTranslationY)

    var translationZ: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _translationZ.set(value)
            props += _translationZ
        }

    private val _translationZ: Property<Float, View> = Property(
        "translationZ", 0.0f,
        View::setTranslationZ)

    var stateListAnimator: StateListAnimator
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _stateListAnimator.set(value)
            props += _stateListAnimator
        }

    private val _stateListAnimator: Property<StateListAnimator?, View> =
        Property("stateListAnimator", null, View::setStateListAnimator)

    var clipToOutline: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipToOutline.set(value)
            props += _clipToOutline
        }

    private val _clipToOutline: Property<Boolean, View> = Property(
        "clipToOutline", false,
        View::setClipToOutline)

    var outlineProvider: ViewOutlineProvider
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _outlineProvider.set(value)
            props += _outlineProvider
        }

    private val _outlineProvider: Property<ViewOutlineProvider?, View> = Property(
        "outlineProvider",
        null, View::setOutlineProvider)

    var layoutParams: ViewGroup.LayoutParams
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutParams.set(value)
            props += _layoutParams
        }

    private val _layoutParams: Property<ViewGroup.LayoutParams?, View> = Property(
        "layoutParams",
        null, View::setLayoutParams)

    var horizontalFadingEdgeEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalFadingEdgeEnabled.set(value)
            props += _horizontalFadingEdgeEnabled
        }

    private val _horizontalFadingEdgeEnabled: Property<Boolean, View> =
        Property("horizontalFadingEdgeEnabled", false, View::setHorizontalFadingEdgeEnabled)

    var verticalFadingEdgeEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalFadingEdgeEnabled.set(value)
            props += _verticalFadingEdgeEnabled
        }

    private val _verticalFadingEdgeEnabled: Property<Boolean, View> =
        Property("verticalFadingEdgeEnabled", false, View::setVerticalFadingEdgeEnabled)

    var horizontalScrollBarEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalScrollBarEnabled.set(value)
            props += _horizontalScrollBarEnabled
        }

    private val _horizontalScrollBarEnabled: Property<Boolean, View> =
        Property("horizontalScrollBarEnabled", false, View::setHorizontalScrollBarEnabled)

    var verticalScrollBarEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalScrollBarEnabled.set(value)
            props += _verticalScrollBarEnabled
        }

    private val _verticalScrollBarEnabled: Property<Boolean, View> =
        Property("verticalScrollBarEnabled", false, View::setVerticalScrollBarEnabled)

    var scrollbarFadingEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollbarFadingEnabled.set(value)
            props += _scrollbarFadingEnabled
        }

    private val _scrollbarFadingEnabled: Property<Boolean, View> =
        Property("scrollbarFadingEnabled", false, View::setScrollbarFadingEnabled)

    var scrollBarDefaultDelayBeforeFade: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarDefaultDelayBeforeFade.set(value)
            props += _scrollBarDefaultDelayBeforeFade
        }

    private val _scrollBarDefaultDelayBeforeFade: Property<Int, View> =
        Property("scrollBarDefaultDelayBeforeFade", 0, View::setScrollBarDefaultDelayBeforeFade)

    var scrollBarFadeDuration: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarFadeDuration.set(value)
            props += _scrollBarFadeDuration
        }

    private val _scrollBarFadeDuration: Property<Int, View> = Property(
        "scrollBarFadeDuration", 0,
        View::setScrollBarFadeDuration)

    var scrollBarSize: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarSize.set(value)
            props += _scrollBarSize
        }

    private val _scrollBarSize: Property<Int, View> = Property(
        "scrollBarSize", 0,
        View::setScrollBarSize)

    var scrollBarStyle: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _scrollBarStyle.set(value)
            props += _scrollBarStyle
        }

    private val _scrollBarStyle: Property<Int, View> = Property(
        "scrollBarStyle", 0,
        View::setScrollBarStyle)

    var duplicateParentStateEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _duplicateParentStateEnabled.set(value)
            props += _duplicateParentStateEnabled
        }

    private val _duplicateParentStateEnabled: Property<Boolean, View> =
        Property("duplicateParentStateEnabled", false, View::setDuplicateParentStateEnabled)

    var layerPaint: Paint
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layerPaint.set(value)
            props += _layerPaint
        }

    private val _layerPaint: Property<Paint?, View> = Property(
        "layerPaint", null,
        View::setLayerPaint)

    var drawingCacheEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheEnabled.set(value)
            props += _drawingCacheEnabled
        }

    private val _drawingCacheEnabled: Property<Boolean, View> = Property(
        "drawingCacheEnabled",
        false, View::setDrawingCacheEnabled)

    var drawingCacheBackgroundColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _drawingCacheBackgroundColor.set(value)
            props += _drawingCacheBackgroundColor
        }

    private val _drawingCacheBackgroundColor: Property<Int, View> =
        Property("drawingCacheBackgroundColor", 0, View::setDrawingCacheBackgroundColor)

    var clipBounds: Rect
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipBounds.set(value)
            props += _clipBounds
        }

    private val _clipBounds: Property<Rect?, View> = Property(
        "clipBounds", null,
        View::setClipBounds)

    var backgroundColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundColor.set(value)
            props += _backgroundColor
        }

    private val _backgroundColor: Property<Int, View> = Property(
        "backgroundColor", 0,
        View::setBackgroundColor)

    var backgroundResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundResource.set(value)
            props += _backgroundResource
        }

    private val _backgroundResource: Property<Int, View> = Property(
        "backgroundResource", 0,
        View::setBackgroundResource)

    var background: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _background.set(value)
            props += _background
        }

    private val _background: Property<Drawable?, View> = Property(
        "background", null,
        View::setBackground)

    var backgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundTintList.set(value)
            props += _backgroundTintList
        }

    private val _backgroundTintList: Property<ColorStateList?, View> =
        Property("backgroundTintList", null, View::setBackgroundTintList)

    var backgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _backgroundTintMode.set(value)
            props += _backgroundTintMode
        }

    private val _backgroundTintMode: Property<PorterDuff.Mode?, View> =
        Property("backgroundTintMode", null, View::setBackgroundTintMode)

    var selected: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _selected.set(value)
            props += _selected
        }

    private val _selected: Property<Boolean, View> = Property("selected", false, View::setSelected)

    var activated: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _activated.set(value)
            props += _activated
        }

    private val _activated: Property<Boolean, View> = Property(
        "activated", false,
        View::setActivated)

    var id: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _id.set(value)
            props += _id
        }

    private val _id: Property<Int, View> = Property("id", 0, View::setId)

    var tag: Any
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _tag.set(value)
            props += _tag
        }

    private val _tag: Property<Any?, View> = Property("tag", null, View::setTag)

    var minimumHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minimumHeight.set(value)
            props += _minimumHeight
        }

    private val _minimumHeight: Property<Int, View> = Property(
        "minimumHeight", 0,
        View::setMinimumHeight)

    var minimumWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _minimumWidth.set(value)
            props += _minimumWidth
        }

    private val _minimumWidth: Property<Int, View> = Property(
        "minimumWidth", 0,
        View::setMinimumWidth)

    var animation: Animation
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animation.set(value)
            props += _animation
        }

    private val _animation: Property<Animation?, View> = Property(
        "animation", null,
        View::setAnimation)

    var systemUiVisibility: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _systemUiVisibility.set(value)
            props += _systemUiVisibility
        }

    private val _systemUiVisibility: Property<Int, View> = Property(
        "systemUiVisibility", 0,
        View::setSystemUiVisibility)

    var onSystemUiVisibilityChangeListener: View.OnSystemUiVisibilityChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onSystemUiVisibilityChangeListener.set(value)
            props += _onSystemUiVisibilityChangeListener
        }

    private val _onSystemUiVisibilityChangeListener:
        Property<View.OnSystemUiVisibilityChangeListener?, View> =
        Property(
            "onSystemUiVisibilityChangeListener", null,
            View::setOnSystemUiVisibilityChangeListener)

    var overScrollMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overScrollMode.set(value)
            props += _overScrollMode
        }

    private val _overScrollMode: Property<Int, View> = Property(
        "overScrollMode", 0,
        View::setOverScrollMode)

    var nestedScrollingEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _nestedScrollingEnabled.set(value)
            props += _nestedScrollingEnabled
        }

    private val _nestedScrollingEnabled: Property<Boolean, View> =
        Property("nestedScrollingEnabled", false, View::setNestedScrollingEnabled)

    var textDirection: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textDirection.set(value)
            props += _textDirection
        }

    private val _textDirection: Property<Int, View> = Property(
        "textDirection", 0,
        View::setTextDirection)

    var textAlignment: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textAlignment.set(value)
            props += _textAlignment
        }

    private val _textAlignment: Property<Int, View> = Property(
        "textAlignment", 0,
        View::setTextAlignment)

    var transitionName: String
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transitionName.set(value)
            props += _transitionName
        }

    private val _transitionName: Property<String?, View> = Property(
        "transitionName", null,
        View::setTransitionName)

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
    var descendantFocusability: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _descendantFocusability.set(value)
            props += _descendantFocusability
        }

    private val _descendantFocusability: Property<Int, ViewGroup> =
        Property("descendantFocusability", 0, ViewGroup::setDescendantFocusability)

    var touchscreenBlocksFocus: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _touchscreenBlocksFocus.set(value)
            props += _touchscreenBlocksFocus
        }

    private val _touchscreenBlocksFocus: Property<Boolean, ViewGroup> =
        Property("touchscreenBlocksFocus", false, ViewGroup::setTouchscreenBlocksFocus)

    var motionEventSplittingEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _motionEventSplittingEnabled.set(value)
            props += _motionEventSplittingEnabled
        }

    private val _motionEventSplittingEnabled: Property<Boolean, ViewGroup> =
        Property(
            "motionEventSplittingEnabled", false,
            ViewGroup::setMotionEventSplittingEnabled)

    var transitionGroup: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transitionGroup.set(value)
            props += _transitionGroup
        }

    private val _transitionGroup: Property<Boolean, ViewGroup> = Property(
        "transitionGroup", false,
        ViewGroup::setTransitionGroup)

    var clipChildren: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipChildren.set(value)
            props += _clipChildren
        }

    private val _clipChildren: Property<Boolean, ViewGroup> = Property(
        "clipChildren", false,
        ViewGroup::setClipChildren)

    var clipToPadding: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _clipToPadding.set(value)
            props += _clipToPadding
        }

    private val _clipToPadding: Property<Boolean, ViewGroup> = Property(
        "clipToPadding", false,
        ViewGroup::setClipToPadding)

    var onHierarchyChangeListener: ViewGroup.OnHierarchyChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onHierarchyChangeListener.set(value)
            props += _onHierarchyChangeListener
        }

    private val _onHierarchyChangeListener: Property<ViewGroup.OnHierarchyChangeListener?,
        ViewGroup> = Property(
        "onHierarchyChangeListener", null,
        ViewGroup::setOnHierarchyChangeListener)

    var layoutTransition: LayoutTransition
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutTransition.set(value)
            props += _layoutTransition
        }

    private val _layoutTransition: Property<LayoutTransition?, ViewGroup> =
        Property("layoutTransition", null, ViewGroup::setLayoutTransition)

    var layoutAnimation: LayoutAnimationController
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutAnimation.set(value)
            props += _layoutAnimation
        }

    private val _layoutAnimation: Property<LayoutAnimationController?, ViewGroup> =
        Property("layoutAnimation", null, ViewGroup::setLayoutAnimation)

    var animationCacheEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _animationCacheEnabled.set(value)
            props += _animationCacheEnabled
        }

    private val _animationCacheEnabled: Property<Boolean, ViewGroup> =
        Property("animationCacheEnabled", false, ViewGroup::setAnimationCacheEnabled)

    var alwaysDrawnWithCacheEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _alwaysDrawnWithCacheEnabled.set(value)
            props += _alwaysDrawnWithCacheEnabled
        }

    private val _alwaysDrawnWithCacheEnabled: Property<Boolean, ViewGroup> =
        Property(
            "alwaysDrawnWithCacheEnabled", false,
            ViewGroup::setAlwaysDrawnWithCacheEnabled)

    var persistentDrawingCache: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _persistentDrawingCache.set(value)
            props += _persistentDrawingCache
        }

    private val _persistentDrawingCache: Property<Int, ViewGroup> =
        Property("persistentDrawingCache", 0, ViewGroup::setPersistentDrawingCache)

    var layoutMode: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutMode.set(value)
            props += _layoutMode
        }

    private val _layoutMode: Property<Int, ViewGroup> = Property(
        "layoutMode", 0,
        ViewGroup::setLayoutMode)

    var addStatesFromChildren: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _addStatesFromChildren.set(value)
            props += _addStatesFromChildren
        }

    private val _addStatesFromChildren: Property<Boolean, ViewGroup> =
        Property("addStatesFromChildren", false, ViewGroup::setAddStatesFromChildren)

    var layoutAnimationListener: Animation.AnimationListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutAnimationListener.set(value)
            props += _layoutAnimationListener
        }

    private val _layoutAnimationListener: Property<Animation.AnimationListener?, ViewGroup> =
        Property("layoutAnimationListener", null, ViewGroup::setLayoutAnimationListener)
}

fun viewStub(f: ViewStub_.() -> Unit) {
    val x = ViewStub_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewStub_ : View_() {
    var layoutResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutResource.set(value)
            props += _layoutResource
        }

    private val _layoutResource: Property<Int, ViewStub> = Property(
        "layoutResource", 0,
        ViewStub::setLayoutResource)

    var inflatedId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inflatedId.set(value)
            props += _inflatedId
        }

    private val _inflatedId: Property<Int, ViewStub> = Property(
        "inflatedId", 0,
        ViewStub::setInflatedId)

    var layoutInflater: LayoutInflater
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutInflater.set(value)
            props += _layoutInflater
        }

    private val _layoutInflater: Property<LayoutInflater?, ViewStub> = Property(
        "layoutInflater",
        null, ViewStub::setLayoutInflater)

    var onInflateListener: ViewStub.OnInflateListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onInflateListener.set(value)
            props += _onInflateListener
        }

    private val _onInflateListener: Property<ViewStub.OnInflateListener?, ViewStub> =
        Property("onInflateListener", null, ViewStub::setOnInflateListener)

    override fun createEmpty(context: Context) = ViewStub(context)
}

fun textureView(f: TextureView_.() -> Unit) {
    val x = TextureView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class TextureView_ : View_() {
    var transform: Matrix
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _transform.set(value)
            props += _transform
        }

    private val _transform: Property<Matrix?, TextureView> = Property(
        "transform", null,
        TextureView::setTransform)

    var opaque: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _opaque.set(value)
            props += _opaque
        }

    private val _opaque: Property<Boolean, TextureView> = Property(
        "opaque", false,
        TextureView::setOpaque)

    var surfaceTexture: SurfaceTexture
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _surfaceTexture.set(value)
            props += _surfaceTexture
        }

    private val _surfaceTexture: Property<SurfaceTexture?, TextureView> = Property(
        "surfaceTexture",
        null, TextureView::setSurfaceTexture)

    var surfaceTextureListener: TextureView.SurfaceTextureListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _surfaceTextureListener.set(value)
            props += _surfaceTextureListener
        }

    private val _surfaceTextureListener: Property<TextureView.SurfaceTextureListener?, TextureView> =
        Property("surfaceTextureListener", null, TextureView::setSurfaceTextureListener)

    override fun createEmpty(context: Context) = TextureView(context)
}
