// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.controller;

import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.content.Context;
import com.rd.utils.DensityUtils;
import com.rd.draw.data.Orientation;
import android.graphics.Color;
import com.rd.pageindicatorview.R;
import android.content.res.TypedArray;
import com.rd.draw.data.RtlMode;
import com.rd.animation.type.AnimationType;
import android.support.annotation.NonNull;
import com.rd.draw.data.Indicator;

public class AttributeController
{
    private Indicator indicator;
    
    public AttributeController(@NonNull final Indicator indicator) {
        this.indicator = indicator;
    }
    
    private AnimationType getAnimationType(final int n) {
        switch (n) {
            default: {
                return AnimationType.NONE;
            }
            case 0: {
                return AnimationType.NONE;
            }
            case 1: {
                return AnimationType.COLOR;
            }
            case 2: {
                return AnimationType.SCALE;
            }
            case 3: {
                return AnimationType.WORM;
            }
            case 4: {
                return AnimationType.SLIDE;
            }
            case 5: {
                return AnimationType.FILL;
            }
            case 6: {
                return AnimationType.THIN_WORM;
            }
            case 7: {
                return AnimationType.DROP;
            }
            case 8: {
                return AnimationType.SWAP;
            }
        }
    }
    
    private RtlMode getRtlMode(final int n) {
        switch (n) {
            default: {
                return RtlMode.Auto;
            }
            case 0: {
                return RtlMode.On;
            }
            case 1: {
                return RtlMode.Off;
            }
            case 2: {
                return RtlMode.Auto;
            }
        }
    }
    
    private void initAnimationAttribute(@NonNull final TypedArray typedArray) {
        final boolean boolean1 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_interactiveAnimation, false);
        int int1;
        if ((int1 = typedArray.getInt(R.styleable.PageIndicatorView_piv_animationDuration, 350)) < 0) {
            int1 = 0;
        }
        final AnimationType animationType = this.getAnimationType(typedArray.getInt(R.styleable.PageIndicatorView_piv_animationType, AnimationType.NONE.ordinal()));
        final RtlMode rtlMode = this.getRtlMode(typedArray.getInt(R.styleable.PageIndicatorView_piv_rtl_mode, RtlMode.Off.ordinal()));
        this.indicator.setAnimationDuration(int1);
        this.indicator.setInteractiveAnimation(boolean1);
        this.indicator.setAnimationType(animationType);
        this.indicator.setRtlMode(rtlMode);
    }
    
    private void initColorAttribute(@NonNull final TypedArray typedArray) {
        final int color = typedArray.getColor(R.styleable.PageIndicatorView_piv_unselectedColor, Color.parseColor("#33ffffff"));
        final int color2 = typedArray.getColor(R.styleable.PageIndicatorView_piv_selectedColor, Color.parseColor("#ffffff"));
        this.indicator.setUnselectedColor(color);
        this.indicator.setSelectedColor(color2);
    }
    
    private void initCountAttribute(@NonNull final TypedArray typedArray) {
        final int resourceId = typedArray.getResourceId(R.styleable.PageIndicatorView_piv_viewPager, -1);
        final boolean boolean1 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_autoVisibility, true);
        final boolean boolean2 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_dynamicCount, false);
        int int1;
        if ((int1 = typedArray.getInt(R.styleable.PageIndicatorView_piv_count, -1)) == -1) {
            int1 = 3;
        }
        final int int2 = typedArray.getInt(R.styleable.PageIndicatorView_piv_select, 0);
        int lastSelectedPosition;
        if (int2 < 0) {
            lastSelectedPosition = 0;
        }
        else {
            lastSelectedPosition = int2;
            if (int1 > 0 && (lastSelectedPosition = int2) > int1 - 1) {
                lastSelectedPosition = int1 - 1;
            }
        }
        this.indicator.setViewPagerId(resourceId);
        this.indicator.setAutoVisibility(boolean1);
        this.indicator.setDynamicCount(boolean2);
        this.indicator.setCount(int1);
        this.indicator.setSelectedPosition(lastSelectedPosition);
        this.indicator.setSelectingPosition(lastSelectedPosition);
        this.indicator.setLastSelectedPosition(lastSelectedPosition);
    }
    
    private void initSizeAttribute(@NonNull final TypedArray typedArray) {
        Orientation orientation;
        if (typedArray.getInt(R.styleable.PageIndicatorView_piv_orientation, Orientation.HORIZONTAL.ordinal()) == 0) {
            orientation = Orientation.HORIZONTAL;
        }
        else {
            orientation = Orientation.VERTICAL;
        }
        int radius;
        if ((radius = (int)typedArray.getDimension(R.styleable.PageIndicatorView_piv_radius, (float)DensityUtils.dpToPx(6))) < 0) {
            radius = 0;
        }
        int padding;
        if ((padding = (int)typedArray.getDimension(R.styleable.PageIndicatorView_piv_padding, (float)DensityUtils.dpToPx(8))) < 0) {
            padding = 0;
        }
        final float float1 = typedArray.getFloat(R.styleable.PageIndicatorView_piv_scaleFactor, 0.7f);
        float scaleFactor;
        if (float1 < 0.3f) {
            scaleFactor = 0.3f;
        }
        else {
            scaleFactor = float1;
            if (float1 > 1.0f) {
                scaleFactor = 1.0f;
            }
        }
        int stroke;
        if ((stroke = (int)typedArray.getDimension(R.styleable.PageIndicatorView_piv_strokeWidth, (float)DensityUtils.dpToPx(1))) > radius) {
            stroke = radius;
        }
        if (this.indicator.getAnimationType() != AnimationType.FILL) {
            stroke = 0;
        }
        this.indicator.setRadius(radius);
        this.indicator.setOrientation(orientation);
        this.indicator.setPadding(padding);
        this.indicator.setScaleFactor(scaleFactor);
        this.indicator.setStroke(stroke);
    }
    
    public void init(@NonNull final Context context, @Nullable final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.PageIndicatorView, 0, 0);
        this.initCountAttribute(obtainStyledAttributes);
        this.initColorAttribute(obtainStyledAttributes);
        this.initAnimationAttribute(obtainStyledAttributes);
        this.initSizeAttribute(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
