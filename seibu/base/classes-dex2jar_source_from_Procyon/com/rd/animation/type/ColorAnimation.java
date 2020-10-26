// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import android.animation.TypeEvaluator;
import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.Animator;
import com.rd.animation.data.Value;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ColorAnimationValue;
import android.animation.ValueAnimator;

public class ColorAnimation extends BaseAnimation<ValueAnimator>
{
    static final String ANIMATION_COLOR = "ANIMATION_COLOR";
    static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    public static final String DEFAULT_SELECTED_COLOR = "#ffffff";
    public static final String DEFAULT_UNSELECTED_COLOR = "#33ffffff";
    int colorEnd;
    int colorStart;
    private ColorAnimationValue value;
    
    public ColorAnimation(@Nullable final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new ColorAnimationValue();
    }
    
    private boolean hasChanges(final int n, final int n2) {
        return this.colorStart != n || this.colorEnd != n2;
    }
    
    private void onAnimateUpdated(@NonNull final ValueAnimator valueAnimator) {
        final int intValue = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR");
        final int intValue2 = (int)valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE");
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
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
                ColorAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
    
    PropertyValuesHolder createColorPropertyHolder(final boolean b) {
        String s;
        int n;
        int n2;
        if (b) {
            s = "ANIMATION_COLOR_REVERSE";
            n = this.colorEnd;
            n2 = this.colorStart;
        }
        else {
            s = "ANIMATION_COLOR";
            n = this.colorStart;
            n2 = this.colorEnd;
        }
        final PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(s, new int[] { n, n2 });
        ofInt.setEvaluator((TypeEvaluator)new ArgbEvaluator());
        return ofInt;
    }
    
    @Override
    public ColorAnimation progress(final float n) {
        if (this.animator != null) {
            final long currentPlayTime = (long)(this.animationDuration * n);
            if (((ValueAnimator)this.animator).getValues() != null && ((ValueAnimator)this.animator).getValues().length > 0) {
                ((ValueAnimator)this.animator).setCurrentPlayTime(currentPlayTime);
            }
        }
        return this;
    }
    
    @NonNull
    public ColorAnimation with(final int colorStart, final int colorEnd) {
        if (this.animator != null && this.hasChanges(colorStart, colorEnd)) {
            this.colorStart = colorStart;
            this.colorEnd = colorEnd;
            ((ValueAnimator)this.animator).setValues(new PropertyValuesHolder[] { this.createColorPropertyHolder(false), this.createColorPropertyHolder(true) });
        }
        return this;
    }
}
