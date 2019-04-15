@file:Suppress("ClassName", "unused", "DEPRECATION")

package y2k.virtual.ui

import android.app.SearchableInfo
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatCheckedTextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.ViewStubCompat
import androidx.core.text.PrecomputedTextCompat
import androidx.cursoradapter.widget.CursorAdapter
import java.util.concurrent.Future
import kotlin.Boolean
import kotlin.CharSequence
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Unit

fun appCompatButton(f: AppCompatButton_.() -> Unit) {
    val x = AppCompatButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatButton_ : Button_() {
    var supportAllCaps: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportAllCaps.set(value)
            props += _supportAllCaps
        }

    private val _supportAllCaps: Property<Boolean, AppCompatButton> = Property(
        "supportAllCaps",
        false, AppCompatButton::setSupportAllCaps
    )

    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatButton> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatButton::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatButton> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatButton::setSupportBackgroundTintMode
        )

    var autoSizeTextTypeWithDefaults: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoSizeTextTypeWithDefaults.set(value)
            props += _autoSizeTextTypeWithDefaults
        }

    private val _autoSizeTextTypeWithDefaults: Property<Int, AppCompatButton> =
        Property(
            "autoSizeTextTypeWithDefaults", 0,
            AppCompatButton::setAutoSizeTextTypeWithDefaults
        )

    override fun createEmpty(context: Context) = AppCompatButton(context)
}

fun appCompatCheckBox(f: AppCompatCheckBox_.() -> Unit) {
    val x = AppCompatCheckBox_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatCheckBox_ : CheckBox_() {
    var supportButtonTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportButtonTintList.set(value)
            props += _supportButtonTintList
        }

    private val _supportButtonTintList: Property<ColorStateList?, AppCompatCheckBox> =
        Property("supportButtonTintList", null, AppCompatCheckBox::setSupportButtonTintList)

    var supportButtonTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportButtonTintMode.set(value)
            props += _supportButtonTintMode
        }

    private val _supportButtonTintMode: Property<PorterDuff.Mode?, AppCompatCheckBox> =
        Property("supportButtonTintMode", null, AppCompatCheckBox::setSupportButtonTintMode)

    override fun createEmpty(context: Context) = AppCompatCheckBox(context)
}

fun appCompatCheckedTextView(f: AppCompatCheckedTextView_.() -> Unit) {
    val x = AppCompatCheckedTextView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatCheckedTextView_ : CheckedTextView_() {
    override fun createEmpty(context: Context) = AppCompatCheckedTextView(context)
}

fun appCompatEditText(f: AppCompatEditText_.() -> Unit) {
    val x = AppCompatEditText_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatEditText_ : EditText_() {
    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatEditText> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatEditText::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatEditText> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatEditText::setSupportBackgroundTintMode
        )

    override fun createEmpty(context: Context) = AppCompatEditText(context)
}

fun appCompatImageButton(f: AppCompatImageButton_.() -> Unit) {
    val x = AppCompatImageButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatImageButton_ : ImageButton_() {
    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatImageButton> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatImageButton::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatImageButton> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatImageButton::setSupportBackgroundTintMode
        )

    var supportImageTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportImageTintList.set(value)
            props += _supportImageTintList
        }

    private val _supportImageTintList: Property<ColorStateList?, AppCompatImageButton> =
        Property("supportImageTintList", null, AppCompatImageButton::setSupportImageTintList)

    var supportImageTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportImageTintMode.set(value)
            props += _supportImageTintMode
        }

    private val _supportImageTintMode: Property<PorterDuff.Mode?, AppCompatImageButton> =
        Property("supportImageTintMode", null, AppCompatImageButton::setSupportImageTintMode)

    override fun createEmpty(context: Context) = AppCompatImageButton(context)
}

fun appCompatImageView(f: AppCompatImageView_.() -> Unit) {
    val x = AppCompatImageView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatImageView_ : ImageView_() {
    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatImageView> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatImageView::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatImageView> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatImageView::setSupportBackgroundTintMode
        )

    var supportImageTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportImageTintList.set(value)
            props += _supportImageTintList
        }

    private val _supportImageTintList: Property<ColorStateList?, AppCompatImageView> =
        Property("supportImageTintList", null, AppCompatImageView::setSupportImageTintList)

    var supportImageTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportImageTintMode.set(value)
            props += _supportImageTintMode
        }

    private val _supportImageTintMode: Property<PorterDuff.Mode?, AppCompatImageView> =
        Property("supportImageTintMode", null, AppCompatImageView::setSupportImageTintMode)

    override fun createEmpty(context: Context) = AppCompatImageView(context)
}

fun appCompatRadioButton(f: AppCompatRadioButton_.() -> Unit) {
    val x = AppCompatRadioButton_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatRadioButton_ : RadioButton_() {
    var supportButtonTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportButtonTintList.set(value)
            props += _supportButtonTintList
        }

    private val _supportButtonTintList: Property<ColorStateList?, AppCompatRadioButton> =
        Property("supportButtonTintList", null, AppCompatRadioButton::setSupportButtonTintList)

    var supportButtonTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportButtonTintMode.set(value)
            props += _supportButtonTintMode
        }

    private val _supportButtonTintMode: Property<PorterDuff.Mode?, AppCompatRadioButton> =
        Property("supportButtonTintMode", null, AppCompatRadioButton::setSupportButtonTintMode)

    override fun createEmpty(context: Context) = AppCompatRadioButton(context)
}

fun appCompatRatingBar(f: AppCompatRatingBar_.() -> Unit) {
    val x = AppCompatRatingBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatRatingBar_ : RatingBar_() {
    override fun createEmpty(context: Context) = AppCompatRatingBar(context)
}

fun appCompatSeekBar(f: AppCompatSeekBar_.() -> Unit) {
    val x = AppCompatSeekBar_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatSeekBar_ : SeekBar_() {
    override fun createEmpty(context: Context) = AppCompatSeekBar(context)
}

fun appCompatSpinner(f: AppCompatSpinner_.() -> Unit) {
    val x = AppCompatSpinner_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatSpinner_ : Spinner_() {
    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatSpinner> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatSpinner::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatSpinner> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatSpinner::setSupportBackgroundTintMode
        )

    override fun createEmpty(context: Context) = AppCompatSpinner(context)
}

fun appCompatTextView(f: AppCompatTextView_.() -> Unit) {
    val x = AppCompatTextView_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class AppCompatTextView_ : TextView_() {
    var supportBackgroundTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintList.set(value)
            props += _supportBackgroundTintList
        }

    private val _supportBackgroundTintList: Property<ColorStateList?, AppCompatTextView> =
        Property(
            "supportBackgroundTintList", null,
            AppCompatTextView::setSupportBackgroundTintList
        )

    var supportBackgroundTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _supportBackgroundTintMode.set(value)
            props += _supportBackgroundTintMode
        }

    private val _supportBackgroundTintMode: Property<PorterDuff.Mode?, AppCompatTextView> =
        Property(
            "supportBackgroundTintMode", null,
            AppCompatTextView::setSupportBackgroundTintMode
        )

    var autoSizeTextTypeWithDefaults: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _autoSizeTextTypeWithDefaults.set(value)
            props += _autoSizeTextTypeWithDefaults
        }

    private val _autoSizeTextTypeWithDefaults: Property<Int, AppCompatTextView> =
        Property(
            "autoSizeTextTypeWithDefaults", 0,
            AppCompatTextView::setAutoSizeTextTypeWithDefaults
        )

    var firstBaselineToTopHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _firstBaselineToTopHeight.set(value)
            props += _firstBaselineToTopHeight
        }

    private val _firstBaselineToTopHeight: Property<Int, AppCompatTextView> =
        Property("firstBaselineToTopHeight", 0, AppCompatTextView::setFirstBaselineToTopHeight)

    var lastBaselineToBottomHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _lastBaselineToBottomHeight.set(value)
            props += _lastBaselineToBottomHeight
        }

    private val _lastBaselineToBottomHeight: Property<Int, AppCompatTextView> =
        Property(
            "lastBaselineToBottomHeight", 0,
            AppCompatTextView::setLastBaselineToBottomHeight
        )

    var lineHeight: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _lineHeight.set(value)
            props += _lineHeight
        }

    private val _lineHeight: Property<Int, AppCompatTextView> = Property(
        "lineHeight", 0,
        AppCompatTextView::setLineHeight
    )

//    var textMetricsParamsCompat: PrecomputedTextCompat.Params
//        @Deprecated("", level = DeprecationLevel.HIDDEN)
//        get() {
//            throw IllegalStateException()
//        }
//        set(value) {
//            _textMetricsParamsCompat.set(value)
//            props += _textMetricsParamsCompat
//        }
//
//    private val _textMetricsParamsCompat: Property<PrecomputedTextCompat.Params?, AppCompatTextView> = Property(
//        "textMetricsParamsCompat", null,
//        AppCompatTextView::setTextMetricsParamsCompat
//    )
//
//    var precomputedText: PrecomputedTextCompat
//        @Deprecated("", level = DeprecationLevel.HIDDEN)
//        get() {
//            throw IllegalStateException()
//        }
//        set(value) {
//            _precomputedText.set(value)
//            props += _precomputedText
//        }
//
//    private val _precomputedText: Property<PrecomputedTextCompat?, AppCompatTextView> =
//        Property("precomputedText", null, AppCompatTextView::setPrecomputedText)
//
//    var textFuture: Future
//        @Deprecated("", level = DeprecationLevel.HIDDEN)
//        get() {
//            throw IllegalStateException()
//        }
//        set(value) {
//            _textFuture.set(value)
//            props += _textFuture
//        }
//
//    private val _textFuture: Property<Future?, AppCompatTextView> = Property(
//        "textFuture", null,
//        AppCompatTextView::setTextFuture
//    )

    override fun createEmpty(context: Context) = AppCompatTextView(context)
}

fun linearLayoutCompat(f: LinearLayoutCompat_.() -> Unit) {
    val x = LinearLayoutCompat_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class LinearLayoutCompat_ : ViewGroup_() {
    var gravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _gravity.set(value)
            props += _gravity
        }

    private val _gravity: Property<Int, LinearLayoutCompat> = Property(
        "gravity", 0,
        LinearLayoutCompat::setGravity
    )

    var showDividers: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showDividers.set(value)
            props += _showDividers
        }

    private val _showDividers: Property<Int, LinearLayoutCompat> = Property(
        "showDividers", 0,
        LinearLayoutCompat::setShowDividers
    )

    var dividerDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerDrawable.set(value)
            props += _dividerDrawable
        }

    private val _dividerDrawable: Property<Drawable?, LinearLayoutCompat> =
        Property("dividerDrawable", null, LinearLayoutCompat::setDividerDrawable)

    var dividerPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _dividerPadding.set(value)
            props += _dividerPadding
        }

    private val _dividerPadding: Property<Int, LinearLayoutCompat> = Property(
        "dividerPadding", 0,
        LinearLayoutCompat::setDividerPadding
    )

    var baselineAligned: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAligned.set(value)
            props += _baselineAligned
        }

    private val _baselineAligned: Property<Boolean, LinearLayoutCompat> =
        Property("baselineAligned", false, LinearLayoutCompat::setBaselineAligned)

    var measureWithLargestChildEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _measureWithLargestChildEnabled.set(value)
            props += _measureWithLargestChildEnabled
        }

    private val _measureWithLargestChildEnabled: Property<Boolean, LinearLayoutCompat> =
        Property(
            "measureWithLargestChildEnabled", false,
            LinearLayoutCompat::setMeasureWithLargestChildEnabled
        )

    var baselineAlignedChildIndex: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _baselineAlignedChildIndex.set(value)
            props += _baselineAlignedChildIndex
        }

    private val _baselineAlignedChildIndex: Property<Int, LinearLayoutCompat> =
        Property(
            "baselineAlignedChildIndex", 0,
            LinearLayoutCompat::setBaselineAlignedChildIndex
        )

    var weightSum: Float
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _weightSum.set(value)
            props += _weightSum
        }

    private val _weightSum: Property<Float, LinearLayoutCompat> = Property(
        "weightSum", 0.0f,
        LinearLayoutCompat::setWeightSum
    )

    var orientation: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _orientation.set(value)
            props += _orientation
        }

    private val _orientation: Property<Int, LinearLayoutCompat> = Property(
        "orientation", 0,
        LinearLayoutCompat::setOrientation
    )

    var horizontalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _horizontalGravity.set(value)
            props += _horizontalGravity
        }

    private val _horizontalGravity: Property<Int, LinearLayoutCompat> =
        Property("horizontalGravity", 0, LinearLayoutCompat::setHorizontalGravity)

    var verticalGravity: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _verticalGravity.set(value)
            props += _verticalGravity
        }

    private val _verticalGravity: Property<Int, LinearLayoutCompat> = Property(
        "verticalGravity", 0,
        LinearLayoutCompat::setVerticalGravity
    )

    override fun createEmpty(context: Context) = LinearLayoutCompat(context)
}

fun searchView(f: SearchView_.() -> Unit) {
    val x = SearchView_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class SearchView_ : LinearLayoutCompat_() {
    var maxWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _maxWidth.set(value)
            props += _maxWidth
        }

    private val _maxWidth: Property<Int, SearchView> = Property(
        "maxWidth", 0,
        SearchView::setMaxWidth
    )

    var inputType: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inputType.set(value)
            props += _inputType
        }

    private val _inputType: Property<Int, SearchView> = Property(
        "inputType", 0,
        SearchView::setInputType
    )

    var imeOptions: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _imeOptions.set(value)
            props += _imeOptions
        }

    private val _imeOptions: Property<Int, SearchView> = Property(
        "imeOptions", 0,
        SearchView::setImeOptions
    )

    var searchableInfo: SearchableInfo
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _searchableInfo.set(value)
            props += _searchableInfo
        }

    private val _searchableInfo: Property<SearchableInfo?, SearchView> = Property(
        "searchableInfo",
        null, SearchView::setSearchableInfo
    )

    var appSearchData: Bundle
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _appSearchData.set(value)
            props += _appSearchData
        }

    private val _appSearchData: Property<Bundle?, SearchView> = Property(
        "appSearchData", null,
        SearchView::setAppSearchData
    )

    var onQueryTextListener: SearchView.OnQueryTextListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onQueryTextListener.set(value)
            props += _onQueryTextListener
        }

    private val _onQueryTextListener: Property<SearchView.OnQueryTextListener?, SearchView> =
        Property("onQueryTextListener", null, SearchView::setOnQueryTextListener)

    var onCloseListener: SearchView.OnCloseListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onCloseListener.set(value)
            props += _onCloseListener
        }

    private val _onCloseListener: Property<SearchView.OnCloseListener?, SearchView> =
        Property("onCloseListener", null, SearchView::setOnCloseListener)

    var onQueryTextFocusChangeListener: View.OnFocusChangeListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onQueryTextFocusChangeListener.set(value)
            props += _onQueryTextFocusChangeListener
        }

    private val _onQueryTextFocusChangeListener: Property<View.OnFocusChangeListener?, SearchView> =
        Property(
            "onQueryTextFocusChangeListener", null,
            SearchView::setOnQueryTextFocusChangeListener
        )

    var onSuggestionListener: SearchView.OnSuggestionListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onSuggestionListener.set(value)
            props += _onSuggestionListener
        }

    private val _onSuggestionListener: Property<SearchView.OnSuggestionListener?, SearchView> =
        Property("onSuggestionListener", null, SearchView::setOnSuggestionListener)

    var onSearchClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onSearchClickListener.set(value)
            props += _onSearchClickListener
        }

    private val _onSearchClickListener: Property<View.OnClickListener?, SearchView> =
        Property("onSearchClickListener", null, SearchView::setOnSearchClickListener)

    var queryHint: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _queryHint.set(value)
            props += _queryHint
        }

    private val _queryHint: Property<CharSequence?, SearchView> = Property(
        "queryHint", null,
        SearchView::setQueryHint
    )

    var iconifiedByDefault: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _iconifiedByDefault.set(value)
            props += _iconifiedByDefault
        }

    private val _iconifiedByDefault: Property<Boolean, SearchView> = Property(
        "iconifiedByDefault",
        false, SearchView::setIconifiedByDefault
    )

    var iconified: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _iconified.set(value)
            props += _iconified
        }

    private val _iconified: Property<Boolean, SearchView> = Property(
        "iconified", false,
        SearchView::setIconified
    )

    var submitButtonEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _submitButtonEnabled.set(value)
            props += _submitButtonEnabled
        }

    private val _submitButtonEnabled: Property<Boolean, SearchView> =
        Property("submitButtonEnabled", false, SearchView::setSubmitButtonEnabled)

    var queryRefinementEnabled: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _queryRefinementEnabled.set(value)
            props += _queryRefinementEnabled
        }

    private val _queryRefinementEnabled: Property<Boolean, SearchView> =
        Property("queryRefinementEnabled", false, SearchView::setQueryRefinementEnabled)

    var suggestionsAdapter: CursorAdapter
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _suggestionsAdapter.set(value)
            props += _suggestionsAdapter
        }

    private val _suggestionsAdapter: Property<CursorAdapter?, SearchView> =
        Property("suggestionsAdapter", null, SearchView::setSuggestionsAdapter)

    override fun createEmpty(context: Context) = SearchView(context)
}

fun switchCompat(f: SwitchCompat_.() -> Unit) {
    val x = SwitchCompat_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class SwitchCompat_ : CompoundButton_() {
    var thumbTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTintList.set(value)
            props += _thumbTintList
        }

    private val _thumbTintList: Property<ColorStateList?, SwitchCompat> = Property(
        "thumbTintList",
        null, SwitchCompat::setThumbTintList
    )

    var thumbTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTintMode.set(value)
            props += _thumbTintMode
        }

    private val _thumbTintMode: Property<PorterDuff.Mode?, SwitchCompat> = Property(
        "thumbTintMode",
        null, SwitchCompat::setThumbTintMode
    )

    var splitTrack: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _splitTrack.set(value)
            props += _splitTrack
        }

    private val _splitTrack: Property<Boolean, SwitchCompat> = Property(
        "splitTrack", false,
        SwitchCompat::setSplitTrack
    )

    var switchTypeface: Typeface
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchTypeface.set(value)
            props += _switchTypeface
        }

    private val _switchTypeface: Property<Typeface?, SwitchCompat> = Property(
        "switchTypeface",
        null, SwitchCompat::setSwitchTypeface
    )

    var switchPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchPadding.set(value)
            props += _switchPadding
        }

    private val _switchPadding: Property<Int, SwitchCompat> = Property(
        "switchPadding", 0,
        SwitchCompat::setSwitchPadding
    )

    var switchMinWidth: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _switchMinWidth.set(value)
            props += _switchMinWidth
        }

    private val _switchMinWidth: Property<Int, SwitchCompat> = Property(
        "switchMinWidth", 0,
        SwitchCompat::setSwitchMinWidth
    )

    var thumbTextPadding: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbTextPadding.set(value)
            props += _thumbTextPadding
        }

    private val _thumbTextPadding: Property<Int, SwitchCompat> = Property(
        "thumbTextPadding", 0,
        SwitchCompat::setThumbTextPadding
    )

    var trackDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackDrawable.set(value)
            props += _trackDrawable
        }

    private val _trackDrawable: Property<Drawable?, SwitchCompat> = Property(
        "trackDrawable", null,
        SwitchCompat::setTrackDrawable
    )

    var trackResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackResource.set(value)
            props += _trackResource
        }

    private val _trackResource: Property<Int, SwitchCompat> = Property(
        "trackResource", 0,
        SwitchCompat::setTrackResource
    )

    var trackTintList: ColorStateList
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackTintList.set(value)
            props += _trackTintList
        }

    private val _trackTintList: Property<ColorStateList?, SwitchCompat> = Property(
        "trackTintList",
        null, SwitchCompat::setTrackTintList
    )

    var trackTintMode: PorterDuff.Mode
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _trackTintMode.set(value)
            props += _trackTintMode
        }

    private val _trackTintMode: Property<PorterDuff.Mode?, SwitchCompat> = Property(
        "trackTintMode",
        null, SwitchCompat::setTrackTintMode
    )

    var thumbDrawable: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbDrawable.set(value)
            props += _thumbDrawable
        }

    private val _thumbDrawable: Property<Drawable?, SwitchCompat> = Property(
        "thumbDrawable", null,
        SwitchCompat::setThumbDrawable
    )

    var thumbResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _thumbResource.set(value)
            props += _thumbResource
        }

    private val _thumbResource: Property<Int, SwitchCompat> = Property(
        "thumbResource", 0,
        SwitchCompat::setThumbResource
    )

    var textOn: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOn.set(value)
            props += _textOn
        }

    private val _textOn: Property<CharSequence?, SwitchCompat> = Property(
        "textOn", null,
        SwitchCompat::setTextOn
    )

    var textOff: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _textOff.set(value)
            props += _textOff
        }

    private val _textOff: Property<CharSequence?, SwitchCompat> = Property(
        "textOff", null,
        SwitchCompat::setTextOff
    )

    var showText: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _showText.set(value)
            props += _showText
        }

    private val _showText: Property<Boolean, SwitchCompat> = Property(
        "showText", false,
        SwitchCompat::setShowText
    )

    override fun createEmpty(context: Context) = SwitchCompat(context)
}

fun toolbar(f: Toolbar_.() -> Unit) {
    val x = Toolbar_()
    globalViewStack.push(x)
    x.f()
    globalViewStack.pop()
    globalViewStack.lastOrNull()?.children?.add(x)
}

open class Toolbar_ : ViewGroup_() {
    var logo: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _logo.set(value)
            props += _logo
        }

    private val _logo: Property<Int, Toolbar> = Property("logo", 0, Toolbar::setLogo)

    var navigationIcon: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _navigationIcon.set(value)
            props += _navigationIcon
        }

    private val _navigationIcon: Property<Int, Toolbar> = Property(
        "navigationIcon", 0,
        Toolbar::setNavigationIcon
    )

    var logoDescription: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _logoDescription.set(value)
            props += _logoDescription
        }

    private val _logoDescription: Property<CharSequence?, Toolbar> = Property(
        "logoDescription",
        null, Toolbar::setLogoDescription
    )

    var navigationContentDescription: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _navigationContentDescription.set(value)
            props += _navigationContentDescription
        }

    private val _navigationContentDescription: Property<CharSequence?, Toolbar> =
        Property("navigationContentDescription", null, Toolbar::setNavigationContentDescription)

    var subtitle: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _subtitle.set(value)
            props += _subtitle
        }

    private val _subtitle: Property<CharSequence?, Toolbar> = Property(
        "subtitle", null,
        Toolbar::setSubtitle
    )

    var title: CharSequence
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _title.set(value)
            props += _title
        }

    private val _title: Property<CharSequence?, Toolbar> = Property(
        "title", null,
        Toolbar::setTitle
    )

    var navigationOnClickListener: View.OnClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _navigationOnClickListener.set(value)
            props += _navigationOnClickListener
        }

    private val _navigationOnClickListener: Property<View.OnClickListener?, Toolbar> =
        Property("navigationOnClickListener", null, Toolbar::setNavigationOnClickListener)

    var titleMarginStart: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _titleMarginStart.set(value)
            props += _titleMarginStart
        }

    private val _titleMarginStart: Property<Int, Toolbar> = Property(
        "titleMarginStart", 0,
        Toolbar::setTitleMarginStart
    )

    var titleMarginTop: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _titleMarginTop.set(value)
            props += _titleMarginTop
        }

    private val _titleMarginTop: Property<Int, Toolbar> = Property(
        "titleMarginTop", 0,
        Toolbar::setTitleMarginTop
    )

    var titleMarginEnd: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _titleMarginEnd.set(value)
            props += _titleMarginEnd
        }

    private val _titleMarginEnd: Property<Int, Toolbar> = Property(
        "titleMarginEnd", 0,
        Toolbar::setTitleMarginEnd
    )

    var titleMarginBottom: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _titleMarginBottom.set(value)
            props += _titleMarginBottom
        }

    private val _titleMarginBottom: Property<Int, Toolbar> = Property(
        "titleMarginBottom", 0,
        Toolbar::setTitleMarginBottom
    )

    var titleTextColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _titleTextColor.set(value)
            props += _titleTextColor
        }

    private val _titleTextColor: Property<Int, Toolbar> = Property(
        "titleTextColor", 0,
        Toolbar::setTitleTextColor
    )

    var subtitleTextColor: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _subtitleTextColor.set(value)
            props += _subtitleTextColor
        }

    private val _subtitleTextColor: Property<Int, Toolbar> = Property(
        "subtitleTextColor", 0,
        Toolbar::setSubtitleTextColor
    )

    var contentInsetStartWithNavigation: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _contentInsetStartWithNavigation.set(value)
            props += _contentInsetStartWithNavigation
        }

    private val _contentInsetStartWithNavigation: Property<Int, Toolbar> =
        Property(
            "contentInsetStartWithNavigation", 0,
            Toolbar::setContentInsetStartWithNavigation
        )

    var contentInsetEndWithActions: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _contentInsetEndWithActions.set(value)
            props += _contentInsetEndWithActions
        }

    private val _contentInsetEndWithActions: Property<Int, Toolbar> =
        Property("contentInsetEndWithActions", 0, Toolbar::setContentInsetEndWithActions)

    var onMenuItemClickListener: Toolbar.OnMenuItemClickListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onMenuItemClickListener.set(value)
            props += _onMenuItemClickListener
        }

    private val _onMenuItemClickListener: Property<Toolbar.OnMenuItemClickListener?, Toolbar> =
        Property("onMenuItemClickListener", null, Toolbar::setOnMenuItemClickListener)

    var collapsible: Boolean
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _collapsible.set(value)
            props += _collapsible
        }

    private val _collapsible: Property<Boolean, Toolbar> = Property(
        "collapsible", false,
        Toolbar::setCollapsible
    )

    var popupTheme: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _popupTheme.set(value)
            props += _popupTheme
        }

    private val _popupTheme: Property<Int, Toolbar> = Property(
        "popupTheme", 0,
        Toolbar::setPopupTheme
    )

    var overflowIcon: Drawable
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _overflowIcon.set(value)
            props += _overflowIcon
        }

    private val _overflowIcon: Property<Drawable?, Toolbar> = Property(
        "overflowIcon", null,
        Toolbar::setOverflowIcon
    )

    override fun createEmpty(context: Context) = Toolbar(context)
}

fun viewStubCompat(f: ViewStubCompat_.() -> Unit) {
    val x = ViewStubCompat_()

    x.f()

    globalViewStack.lastOrNull()?.children?.add(x)
}

open class ViewStubCompat_ : View_() {
    var inflatedId: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _inflatedId.set(value)
            props += _inflatedId
        }

    private val _inflatedId: Property<Int, ViewStubCompat> = Property(
        "inflatedId", 0,
        ViewStubCompat::setInflatedId
    )

    var layoutResource: Int
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutResource.set(value)
            props += _layoutResource
        }

    private val _layoutResource: Property<Int, ViewStubCompat> = Property(
        "layoutResource", 0,
        ViewStubCompat::setLayoutResource
    )

    var onInflateListener: ViewStubCompat.OnInflateListener
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _onInflateListener.set(value)
            props += _onInflateListener
        }

    private val _onInflateListener: Property<ViewStubCompat.OnInflateListener?, ViewStubCompat> =
        Property("onInflateListener", null, ViewStubCompat::setOnInflateListener)

    var layoutInflater: LayoutInflater
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        get() {
            throw IllegalStateException()
        }
        set(value) {
            _layoutInflater.set(value)
            props += _layoutInflater
        }

    private val _layoutInflater: Property<LayoutInflater?, ViewStubCompat> =
        Property("layoutInflater", null, ViewStubCompat::setLayoutInflater)

    //    override fun createEmpty(context: Context) = ViewStubCompat(context)
    override fun createEmpty(context: Context): ViewStubCompat = TODO()
}
