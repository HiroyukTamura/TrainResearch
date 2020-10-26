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
import com.rd.animation.data.type.ScaleAnimationValue;

public class ScaleAnimation extends ColorAnimation
{
    private static final String ANIMATION_SCALE = "ANIMATION_SCALE";
    private static final String ANIMATION_SCALE_REVERSE = "ANIMATION_SCALE_REVERSE";
    public static final float DEFAULT_SCALE_FACTOR = 0.7f;
    public static final float MAX_SCALE_FACTOR = 1.0f;
    public static final float MIN_SCALE_FACTOR = 0.3f;
    private int radius;
    private float scaleFactor;
    private ScaleAnimationValue value;
    
    public ScaleAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new ScaleAnimationValue();
    }
    
    @NonNull
    private PropertyValuesHolder createScalePropertyHolder(final boolean b) {
        String s;
        int radius;
        int radius2;
        if (b) {
            s = "ANIMATION_SCALE_REVERSE";
            radius = this.radius;
            radius2 = (int)(this.radius * this.scaleFactor);
        }
        else {
            s = "ANIMATION_SCALE";
            radius = (int)(this.radius * this.scaleFactor);
            radius2 = this.radius;
        }
        final PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(s, new int[] { radius, radius2 });
        ofInt.setEvaluator((TypeEvaluator)new IntEvaluator());
        return ofInt;
    }
    
    private boolean hasChanges(final int n, final int n2, final int n3, final float n4) {
        return this.colorStart != n || this.colorEnd != n2 || this.radius != n3 || this.scaleFactor != n4;
    }
    
    private void onAnimateUpdated(@NonNull final ValueAnimator valueAnimator) {
        final int intValue = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR");
        final int intValue2 = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE");
        final int intValue3 = (int)valueAnimator.getAnimatedValue("ANIMATION_SCALE");
        final int intValue4 = (int)valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE");
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
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
                ScaleAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
    
    @NonNull
    public ScaleAnimation with(final int colorStart, final int colorEnd, final int radius, final float scaleFactor) {
        if (this.animator != null && this.hasChanges(colorStart, colorEnd, radius, scaleFactor)) {
            this.colorStart = colorStart;
            this.colorEnd = colorEnd;
            this.radius = radius;
            this.scaleFactor = scaleFactor;
            ((ValueAnimator)this.animator).setValues(new PropertyValuesHolder[] { this.createColorPropertyHolder(false), this.createColorPropertyHolder(true), this.createScalePropertyHolder(false), this.createScalePropertyHolder(true) });
        }
        return this;
    }
}
