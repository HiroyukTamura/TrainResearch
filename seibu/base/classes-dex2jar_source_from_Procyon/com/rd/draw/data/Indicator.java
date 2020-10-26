// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.data;

import android.support.annotation.NonNull;
import com.rd.animation.type.AnimationType;

public class Indicator
{
    public static final int COUNT_NONE = -1;
    public static final int DEFAULT_COUNT = 3;
    public static final int DEFAULT_PADDING_DP = 8;
    public static final int DEFAULT_RADIUS_DP = 6;
    public static final int MIN_COUNT = 1;
    private long animationDuration;
    private AnimationType animationType;
    private boolean autoVisibility;
    private int count;
    private boolean dynamicCount;
    private int height;
    private boolean interactiveAnimation;
    private int lastSelectedPosition;
    private Orientation orientation;
    private int padding;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int radius;
    private RtlMode rtlMode;
    private float scaleFactor;
    private int selectedColor;
    private int selectedPosition;
    private int selectingPosition;
    private int stroke;
    private int unselectedColor;
    private int viewPagerId;
    private int width;
    
    public Indicator() {
        this.count = 3;
        this.viewPagerId = -1;
    }
    
    public long getAnimationDuration() {
        return this.animationDuration;
    }
    
    @NonNull
    public AnimationType getAnimationType() {
        if (this.animationType == null) {
            this.animationType = AnimationType.NONE;
        }
        return this.animationType;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLastSelectedPosition() {
        return this.lastSelectedPosition;
    }
    
    @NonNull
    public Orientation getOrientation() {
        if (this.orientation == null) {
            this.orientation = Orientation.HORIZONTAL;
        }
        return this.orientation;
    }
    
    public int getPadding() {
        return this.padding;
    }
    
    public int getPaddingBottom() {
        return this.paddingBottom;
    }
    
    public int getPaddingLeft() {
        return this.paddingLeft;
    }
    
    public int getPaddingRight() {
        return this.paddingRight;
    }
    
    public int getPaddingTop() {
        return this.paddingTop;
    }
    
    public int getRadius() {
        return this.radius;
    }
    
    @NonNull
    public RtlMode getRtlMode() {
        if (this.rtlMode == null) {
            this.rtlMode = RtlMode.Off;
        }
        return this.rtlMode;
    }
    
    public float getScaleFactor() {
        return this.scaleFactor;
    }
    
    public int getSelectedColor() {
        return this.selectedColor;
    }
    
    public int getSelectedPosition() {
        return this.selectedPosition;
    }
    
    public int getSelectingPosition() {
        return this.selectingPosition;
    }
    
    public int getStroke() {
        return this.stroke;
    }
    
    public int getUnselectedColor() {
        return this.unselectedColor;
    }
    
    public int getViewPagerId() {
        return this.viewPagerId;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public boolean isAutoVisibility() {
        return this.autoVisibility;
    }
    
    public boolean isDynamicCount() {
        return this.dynamicCount;
    }
    
    public boolean isInteractiveAnimation() {
        return this.interactiveAnimation && this.viewPagerId != -1;
    }
    
    public void setAnimationDuration(final long animationDuration) {
        this.animationDuration = animationDuration;
    }
    
    public void setAnimationType(final AnimationType animationType) {
        this.animationType = animationType;
    }
    
    public void setAutoVisibility(final boolean autoVisibility) {
        this.autoVisibility = autoVisibility;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public void setDynamicCount(final boolean dynamicCount) {
        this.dynamicCount = dynamicCount;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setInteractiveAnimation(final boolean interactiveAnimation) {
        this.interactiveAnimation = interactiveAnimation;
    }
    
    public void setLastSelectedPosition(final int lastSelectedPosition) {
        this.lastSelectedPosition = lastSelectedPosition;
    }
    
    public void setOrientation(final Orientation orientation) {
        this.orientation = orientation;
    }
    
    public void setPadding(final int padding) {
        this.padding = padding;
    }
    
    public void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }
    
    public void setPaddingLeft(final int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }
    
    public void setPaddingRight(final int paddingRight) {
        this.paddingRight = paddingRight;
    }
    
    public void setPaddingTop(final int paddingTop) {
        this.paddingTop = paddingTop;
    }
    
    public void setRadius(final int radius) {
        this.radius = radius;
    }
    
    public void setRtlMode(final RtlMode rtlMode) {
        this.rtlMode = rtlMode;
    }
    
    public void setScaleFactor(final float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }
    
    public void setSelectedColor(final int selectedColor) {
        this.selectedColor = selectedColor;
    }
    
    public void setSelectedPosition(final int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
    
    public void setSelectingPosition(final int selectingPosition) {
        this.selectingPosition = selectingPosition;
    }
    
    public void setStroke(final int stroke) {
        this.stroke = stroke;
    }
    
    public void setUnselectedColor(final int unselectedColor) {
        this.unselectedColor = unselectedColor;
    }
    
    public void setViewPagerId(final int viewPagerId) {
        this.viewPagerId = viewPagerId;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
