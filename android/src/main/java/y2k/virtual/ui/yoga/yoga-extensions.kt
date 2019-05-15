@file:Suppress("unused", "UsePropertyAccessSyntax")

package y2k.virtual.ui.yoga

import com.facebook.yoga.*
import com.facebook.yoga.android.VirtualYogaLayout
import com.facebook.yoga.android.YogaLayout
import y2k.virtual.ui.Property
import y2k.virtual.ui.VirtualYogaLayout_
import y2k.virtual.ui.YogaLayout_
import y2k.virtual.ui.updateProp

var VirtualYogaLayout_.isReferenceBaseline: Boolean
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Boolean, VirtualYogaLayout>(
                true,
                "isReferenceBaseline",
                false,
                { w, a -> w.yogaNode.setIsReferenceBaseline(a) })
        )
    }

var VirtualYogaLayout_.direction: YogaDirection
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaDirection, VirtualYogaLayout>(
                true,
                "direction",
                YogaDirection.fromInt(0),
                { w, a -> w.yogaNode.setDirection(a) })
        )
    }

var VirtualYogaLayout_.flexDirection: YogaFlexDirection
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaFlexDirection, VirtualYogaLayout>(
                true,
                "flexDirection",
                YogaFlexDirection.fromInt(0),
                { w, a -> w.yogaNode.setFlexDirection(a) })
        )
    }

var VirtualYogaLayout_.justifyContent: YogaJustify
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaJustify, VirtualYogaLayout>(
                true,
                "justifyContent",
                YogaJustify.fromInt(0),
                { w, a -> w.yogaNode.setJustifyContent(a) })
        )
    }

var VirtualYogaLayout_.alignItems: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, VirtualYogaLayout>(
                true,
                "alignItems",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignItems(a) })
        )
    }

var VirtualYogaLayout_.alignSelf: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, VirtualYogaLayout>(
                true,
                "alignSelf",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignSelf(a) })
        )
    }

var VirtualYogaLayout_.alignContent: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, VirtualYogaLayout>(
                true,
                "alignContent",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignContent(a) })
        )
    }

var VirtualYogaLayout_.positionType: YogaPositionType
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaPositionType, VirtualYogaLayout>(
                true,
                "positionType",
                YogaPositionType.fromInt(0),
                { w, a -> w.yogaNode.setPositionType(a) })
        )
    }

var VirtualYogaLayout_.wrap: YogaWrap
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaWrap, VirtualYogaLayout>(
                true,
                "wrap",
                YogaWrap.fromInt(0),
                { w, a -> w.yogaNode.setWrap(a) })
        )
    }

var VirtualYogaLayout_.overflow: YogaOverflow
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaOverflow, VirtualYogaLayout>(
                true,
                "overflow",
                YogaOverflow.fromInt(0),
                { w, a -> w.yogaNode.setOverflow(a) })
        )
    }

var VirtualYogaLayout_.display: YogaDisplay
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaDisplay, VirtualYogaLayout>(
                true,
                "display",
                YogaDisplay.fromInt(0),
                { w, a -> w.yogaNode.setDisplay(a) })
        )
    }

var VirtualYogaLayout_.flex: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "flex",
                0.0f,
                { w, a -> w.yogaNode.setFlex(a) })
        )
    }

var VirtualYogaLayout_.flexGrow: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "flexGrow",
                0.0f,
                { w, a -> w.yogaNode.setFlexGrow(a) })
        )
    }

var VirtualYogaLayout_.flexShrink: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "flexShrink",
                0.0f,
                { w, a -> w.yogaNode.setFlexShrink(a) })
        )
    }

var VirtualYogaLayout_.flexBasis: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "flexBasis",
                0.0f,
                { w, a -> w.yogaNode.setFlexBasis(a) })
        )
    }

var VirtualYogaLayout_.flexBasisPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "flexBasisPercent",
                0.0f,
                { w, a -> w.yogaNode.setFlexBasisPercent(a) })
        )
    }

var VirtualYogaLayout_.margin: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "margin",
                null,
                { w, a -> w.yogaNode.setMargin(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.marginPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "marginPercent",
                null,
                { w, a -> w.yogaNode.setMarginPercent(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.marginAuto: YogaEdge
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaEdge, VirtualYogaLayout>(
                true,
                "marginAuto",
                null,
                { w, a -> w.yogaNode.setMarginAuto(a) })
        )
    }

var VirtualYogaLayout_.padding2: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "padding",
                null,
                { w, a -> w.yogaNode.setPadding(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.paddingPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "paddingPercent",
                null,
                { w, a -> w.yogaNode.setPaddingPercent(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.border: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "border",
                null,
                { w, a -> w.yogaNode.setBorder(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.position: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "position",
                null,
                { w, a -> w.yogaNode.setPosition(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.positionPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, VirtualYogaLayout>(
                true,
                "positionPercent",
                null,
                { w, a -> w.yogaNode.setPositionPercent(a.first, a.second) })
        )
    }

var VirtualYogaLayout_.width: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "width",
                0.0f,
                { w, a -> w.yogaNode.setWidth(a) })
        )
    }

var VirtualYogaLayout_.widthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "widthPercent",
                0.0f,
                { w, a -> w.yogaNode.setWidthPercent(a) })
        )
    }

var VirtualYogaLayout_.height: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "height",
                0.0f,
                { w, a -> w.yogaNode.setHeight(a) })
        )
    }

var VirtualYogaLayout_.heightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "heightPercent",
                0.0f,
                { w, a -> w.yogaNode.setHeightPercent(a) })
        )
    }

var VirtualYogaLayout_.minWidth: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "minWidth",
                0.0f,
                { w, a -> w.yogaNode.setMinWidth(a) })
        )
    }

var VirtualYogaLayout_.minWidthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "minWidthPercent",
                0.0f,
                { w, a -> w.yogaNode.setMinWidthPercent(a) })
        )
    }

var VirtualYogaLayout_.minHeight: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "minHeight",
                0.0f,
                { w, a -> w.yogaNode.setMinHeight(a) })
        )
    }

var VirtualYogaLayout_.minHeightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "minHeightPercent",
                0.0f,
                { w, a -> w.yogaNode.setMinHeightPercent(a) })
        )
    }

var VirtualYogaLayout_.maxWidth: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "maxWidth",
                0.0f,
                { w, a -> w.yogaNode.setMaxWidth(a) })
        )
    }

var VirtualYogaLayout_.maxWidthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "maxWidthPercent",
                0.0f,
                { w, a -> w.yogaNode.setMaxWidthPercent(a) })
        )
    }

var VirtualYogaLayout_.maxHeight: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "maxHeight",
                0.0f,
                { w, a -> w.yogaNode.setMaxHeight(a) })
        )
    }

var VirtualYogaLayout_.maxHeightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "maxHeightPercent",
                0.0f,
                { w, a -> w.yogaNode.setMaxHeightPercent(a) })
        )
    }

var VirtualYogaLayout_.aspectRatio: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, VirtualYogaLayout>(
                true,
                "aspectRatio",
                0.0f,
                { w, a -> w.yogaNode.setAspectRatio(a) })
        )
    }

var VirtualYogaLayout_.measureFunction: YogaMeasureFunction
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaMeasureFunction, VirtualYogaLayout>(
                true,
                "measureFunction",
                null,
                { w, a -> w.yogaNode.setMeasureFunction(a) })
        )
    }

var VirtualYogaLayout_.baselineFunction: YogaBaselineFunction
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaBaselineFunction, VirtualYogaLayout>(
                true,
                "baselineFunction",
                null,
                { w, a -> w.yogaNode.setBaselineFunction(a) })
        )
    }

var VirtualYogaLayout_.data: Any
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Any, VirtualYogaLayout>(
                true,
                "data",
                null,
                { w, a -> w.yogaNode.setData(a) })
        )
    }

var VirtualYogaLayout_.styleInputs: Pair<FloatArray, Int>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<FloatArray, Int>, VirtualYogaLayout>(
                true,
                "styleInputs",
                Pair(floatArrayOf(), 0),
                { w, a -> w.yogaNode.setStyleInputs(a.first, a.second) })
        )
    }

//
//
//
//
//

var YogaLayout_.isReferenceBaseline: Boolean
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Boolean, YogaLayout>(
                true,
                "isReferenceBaseline",
                false,
                { w, a -> w.yogaNode.setIsReferenceBaseline(a) })
        )
    }

var YogaLayout_.direction: YogaDirection
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaDirection, YogaLayout>(
                true,
                "direction",
                YogaDirection.fromInt(0),
                { w, a -> w.yogaNode.setDirection(a) })
        )
    }

var YogaLayout_.flexDirection: YogaFlexDirection
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaFlexDirection, YogaLayout>(
                true,
                "flexDirection",
                YogaFlexDirection.fromInt(0),
                { w, a -> w.yogaNode.setFlexDirection(a) })
        )
    }

var YogaLayout_.justifyContent: YogaJustify
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaJustify, YogaLayout>(
                true,
                "justifyContent",
                YogaJustify.fromInt(0),
                { w, a -> w.yogaNode.setJustifyContent(a) })
        )
    }

var YogaLayout_.alignItems: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, YogaLayout>(
                true,
                "alignItems",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignItems(a) })
        )
    }

var YogaLayout_.alignSelf: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, YogaLayout>(
                true,
                "alignSelf",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignSelf(a) })
        )
    }

var YogaLayout_.alignContent: YogaAlign
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaAlign, YogaLayout>(
                true,
                "alignContent",
                YogaAlign.fromInt(0),
                { w, a -> w.yogaNode.setAlignContent(a) })
        )
    }

var YogaLayout_.positionType: YogaPositionType
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaPositionType, YogaLayout>(
                true,
                "positionType",
                YogaPositionType.fromInt(0),
                { w, a -> w.yogaNode.setPositionType(a) })
        )
    }

var YogaLayout_.wrap: YogaWrap
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaWrap, YogaLayout>(
                true,
                "wrap",
                YogaWrap.fromInt(0),
                { w, a -> w.yogaNode.setWrap(a) })
        )
    }

var YogaLayout_.overflow: YogaOverflow
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaOverflow, YogaLayout>(
                true,
                "overflow",
                YogaOverflow.fromInt(0),
                { w, a -> w.yogaNode.setOverflow(a) })
        )
    }

var YogaLayout_.display: YogaDisplay
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaDisplay, YogaLayout>(
                true,
                "display",
                YogaDisplay.fromInt(0),
                { w, a -> w.yogaNode.setDisplay(a) })
        )
    }

var YogaLayout_.flex: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "flex",
                0.0f,
                { w, a -> w.yogaNode.setFlex(a) })
        )
    }

var YogaLayout_.flexGrow: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "flexGrow",
                0.0f,
                { w, a -> w.yogaNode.setFlexGrow(a) })
        )
    }

var YogaLayout_.flexShrink: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "flexShrink",
                0.0f,
                { w, a -> w.yogaNode.setFlexShrink(a) })
        )
    }

var YogaLayout_.flexBasis: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "flexBasis",
                0.0f,
                { w, a -> w.yogaNode.setFlexBasis(a) })
        )
    }

var YogaLayout_.flexBasisPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "flexBasisPercent",
                0.0f,
                { w, a -> w.yogaNode.setFlexBasisPercent(a) })
        )
    }

var YogaLayout_.margin: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "margin",
                null,
                { w, a -> w.yogaNode.setMargin(a.first, a.second) })
        )
    }

var YogaLayout_.marginPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "marginPercent",
                null,
                { w, a -> w.yogaNode.setMarginPercent(a.first, a.second) })
        )
    }

var YogaLayout_.marginAuto: YogaEdge
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaEdge, YogaLayout>(
                true,
                "marginAuto",
                null,
                { w, a -> w.yogaNode.setMarginAuto(a) })
        )
    }

var YogaLayout_.padding2: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "padding",
                null,
                { w, a -> w.yogaNode.setPadding(a.first, a.second) })
        )
    }

var YogaLayout_.paddingPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "paddingPercent",
                null,
                { w, a -> w.yogaNode.setPaddingPercent(a.first, a.second) })
        )
    }

var YogaLayout_.border: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "border",
                null,
                { w, a -> w.yogaNode.setBorder(a.first, a.second) })
        )
    }

var YogaLayout_.position: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "position",
                null,
                { w, a -> w.yogaNode.setPosition(a.first, a.second) })
        )
    }

var YogaLayout_.positionPercent: Pair<YogaEdge, Float>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<YogaEdge, Float>, YogaLayout>(
                true,
                "positionPercent",
                null,
                { w, a -> w.yogaNode.setPositionPercent(a.first, a.second) })
        )
    }

var YogaLayout_.width: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "width",
                0.0f,
                { w, a -> w.yogaNode.setWidth(a) })
        )
    }

var YogaLayout_.widthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "widthPercent",
                0.0f,
                { w, a -> w.yogaNode.setWidthPercent(a) })
        )
    }

var YogaLayout_.height: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "height",
                0.0f,
                { w, a -> w.yogaNode.setHeight(a) })
        )
    }

var YogaLayout_.heightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "heightPercent",
                0.0f,
                { w, a -> w.yogaNode.setHeightPercent(a) })
        )
    }

var YogaLayout_.minWidth: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "minWidth",
                0.0f,
                { w, a -> w.yogaNode.setMinWidth(a) })
        )
    }

var YogaLayout_.minWidthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "minWidthPercent",
                0.0f,
                { w, a -> w.yogaNode.setMinWidthPercent(a) })
        )
    }

var YogaLayout_.minHeight: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "minHeight",
                0.0f,
                { w, a -> w.yogaNode.setMinHeight(a) })
        )
    }

var YogaLayout_.minHeightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "minHeightPercent",
                0.0f,
                { w, a -> w.yogaNode.setMinHeightPercent(a) })
        )
    }

var YogaLayout_.maxWidth: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "maxWidth",
                0.0f,
                { w, a -> w.yogaNode.setMaxWidth(a) })
        )
    }

var YogaLayout_.maxWidthPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "maxWidthPercent",
                0.0f,
                { w, a -> w.yogaNode.setMaxWidthPercent(a) })
        )
    }

var YogaLayout_.maxHeight: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "maxHeight",
                0.0f,
                { w, a -> w.yogaNode.setMaxHeight(a) })
        )
    }

var YogaLayout_.maxHeightPercent: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "maxHeightPercent",
                0.0f,
                { w, a -> w.yogaNode.setMaxHeightPercent(a) })
        )
    }

var YogaLayout_.aspectRatio: Float
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Float, YogaLayout>(
                true,
                "aspectRatio",
                0.0f,
                { w, a -> w.yogaNode.setAspectRatio(a) })
        )
    }

var YogaLayout_.measureFunction: YogaMeasureFunction
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaMeasureFunction, YogaLayout>(
                true,
                "measureFunction",
                null,
                { w, a -> w.yogaNode.setMeasureFunction(a) })
        )
    }

var YogaLayout_.baselineFunction: YogaBaselineFunction
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<YogaBaselineFunction, YogaLayout>(
                true,
                "baselineFunction",
                null,
                { w, a -> w.yogaNode.setBaselineFunction(a) })
        )
    }

var YogaLayout_.data: Any
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Any, YogaLayout>(
                true,
                "data",
                null,
                { w, a -> w.yogaNode.setData(a) })
        )
    }

var YogaLayout_.styleInputs: Pair<FloatArray, Int>
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    get() = throw IllegalStateException()
    set(value) {
        updateProp(
            value,
            Property<Pair<FloatArray, Int>, YogaLayout>(
                true,
                "styleInputs",
                Pair(floatArrayOf(), 0),
                { w, a -> w.yogaNode.setStyleInputs(a.first, a.second) })
        )
    }
