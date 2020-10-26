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
import android.support.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SlideAnimationValue;
import android.animation.ValueAnimator;

public class SlideAnimation extends BaseAnimation<ValueAnimator>
{
    private static final String ANIMATION_COORDINATE = "ANIMATION_COORDINATE";
    private static final int COORDINATE_NONE = -1;
    private int coordinateEnd;
    private int coordinateStart;
    private SlideAnimationValue value;
    
    public SlideAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.coordinateStart = -1;
        this.coordinateEnd = -1;
        this.value = new SlideAnimationValue();
    }
    
    private PropertyValuesHolder createSlidePropertyHolder() {
        final PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", new int[] { this.coordinateStart, this.coordinateEnd });
        ofInt.setEvaluator((TypeEvaluator)new IntEvaluator());
        return ofInt;
    }
    
    private boolean hasChanges(final int n, final int n2) {
        return this.coordinateStart != n || this.coordinateEnd != n2;
    }
    
    private void onAnimateUpdated(@NonNull final ValueAnimator valueAnimator) {
        this.value.setCoordinate((int)valueAnimator.getAnimatedValue("ANIMATION_COORDINATE"));
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
                SlideAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
    
    @Override
    public SlideAnimation progress(final float n) {
        if (this.animator != null) {
            final long currentPlayTime = (long)(this.animationDuration * n);
            if (((ValueAnimator)this.animator).getValues() != null && ((ValueAnimator)this.animator).getValues().length > 0) {
                ((ValueAnimator)this.animator).setCurrentPlayTime(currentPlayTime);
            }
        }
        return this;
    }
    
    @NonNull
    public SlideAnimation with(final int coordinateStart, final int coordinateEnd) {
        if (this.animator != null && this.hasChanges(coordinateStart, coordinateEnd)) {
            this.coordinateStart = coordinateStart;
            this.coordinateEnd = coordinateEnd;
            ((ValueAnimator)this.animator).setValues(new PropertyValuesHolder[] { this.createSlidePropertyHolder() });
        }
        return this;
    }
}
