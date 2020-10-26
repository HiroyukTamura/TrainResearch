// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.Animator;
import com.rd.animation.data.Value;
import android.animation.TypeEvaluator;
import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.FillAnimationValue;

public class FillAnimation extends ColorAnimation
{
    private static final String ANIMATION_RADIUS = "ANIMATION_RADIUS";
    private static final String ANIMATION_RADIUS_REVERSE = "ANIMATION_RADIUS_REVERSE";
    private static final String ANIMATION_STROKE = "ANIMATION_STROKE";
    private static final String ANIMATION_STROKE_REVERSE = "ANIMATION_STROKE_REVERSE";
    public static final int DEFAULT_STROKE_DP = 1;
    private int radius;
    private int stroke;
    private FillAnimationValue value;
    
    public FillAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new FillAnimationValue();
    }
    
    @NonNull
    private PropertyValuesHolder createRadiusPropertyHolder(final boolean b) {
        String s;
        int radius;
        int radius2;
        if (b) {
            s = "ANIMATION_RADIUS_REVERSE";
            radius = this.radius / 2;
            radius2 = this.radius;
        }
        else {
            s = "ANIMATION_RADIUS";
            radius = this.radius;
            radius2 = this.radius / 2;
        }
        final PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(s, new int[] { radius, radius2 });
        ofInt.setEvaluator((TypeEvaluator)new IntEvaluator());
        return ofInt;
    }
    
    @NonNull
    private PropertyValuesHolder createStrokePropertyHolder(final boolean b) {
        String s;
        int radius;
        int radius2;
        if (b) {
            s = "ANIMATION_STROKE_REVERSE";
            radius = this.radius;
            radius2 = 0;
        }
        else {
            s = "ANIMATION_STROKE";
            radius = 0;
            radius2 = this.radius;
        }
        final PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(s, new int[] { radius, radius2 });
        ofInt.setEvaluator((TypeEvaluator)new IntEvaluator());
        return ofInt;
    }
    
    private boolean hasChanges(final int n, final int n2, final int n3, final int n4) {
        return this.colorStart != n || this.colorEnd != n2 || this.radius != n3 || this.stroke != n4;
    }
    
    private void onAnimateUpdated(@NonNull final ValueAnimator valueAnimator) {
        final int intValue = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR");
        final int intValue2 = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE");
        final int intValue3 = (int)valueAnimator.getAnimatedValue("ANIMATION_RADIUS");
        final int intValue4 = (int)valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE");
        final int intValue5 = (int)valueAnimator.getAnimatedValue("ANIMATION_STROKE");
        final int intValue6 = (int)valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE");
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
        this.value.setStroke(intValue5);
        this.value.setStrokeReverse(intValue6);
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }
    
    @NonNull
    @Override
    public ValueAnimator createAnimator() {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                FillAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
    
    @NonNull
    public FillAnimation with(final int colorStart, final int colorEnd, final int radius, final int stroke) {
        if (this.animator != null && this.hasChanges(colorStart, colorEnd, radius, stroke)) {
            this.colorStart = colorStart;
            this.colorEnd = colorEnd;
            this.radius = radius;
            this.stroke = stroke;
            ((ValueAnimator)this.animator).setValues(new PropertyValuesHolder[] { this.createColorPropertyHolder(false), this.createColorPropertyHolder(true), this.createRadiusPropertyHolder(false), this.createRadiusPropertyHolder(true), this.createStrokePropertyHolder(false), this.createStrokePropertyHolder(true) });
        }
        return this;
    }
}
