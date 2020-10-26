// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import java.util.Iterator;
import android.animation.Animator;
import com.rd.animation.data.Value;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.DropAnimationValue;
import android.animation.AnimatorSet;

public class DropAnimation extends BaseAnimation<AnimatorSet>
{
    private int heightEnd;
    private int heightStart;
    private int radius;
    private DropAnimationValue value;
    private int widthEnd;
    private int widthStart;
    
    public DropAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new DropAnimationValue();
    }
    
    private ValueAnimator createValueAnimation(final int n, final int n2, final long duration, final AnimationType animationType) {
        final ValueAnimator ofInt = ValueAnimator.ofInt(new int[] { n, n2 });
        ofInt.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        ofInt.setDuration(duration);
        ofInt.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                DropAnimation.this.onAnimatorUpdate(valueAnimator, animationType);
            }
        });
        return ofInt;
    }
    
    private boolean hasChanges(final int n, final int n2, final int n3, final int n4, final int n5) {
        return this.widthStart != n || this.widthEnd != n2 || this.heightStart != n3 || this.heightEnd != n4 || this.radius != n5;
    }
    
    private void onAnimatorUpdate(@NonNull final ValueAnimator valueAnimator, @NonNull final AnimationType animationType) {
        final int intValue = (int)valueAnimator.getAnimatedValue();
        switch (animationType) {
            case Width: {
                this.value.setWidth(intValue);
                break;
            }
            case Height: {
                this.value.setHeight(intValue);
                break;
            }
            case Radius: {
                this.value.setRadius(intValue);
                break;
            }
        }
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }
    
    @NonNull
    @Override
    public AnimatorSet createAnimator() {
        final AnimatorSet set = new AnimatorSet();
        set.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        return set;
    }
    
    @Override
    public DropAnimation duration(final long n) {
        super.duration(n);
        return this;
    }
    
    @Override
    public DropAnimation progress(final float n) {
        if (this.animator != null) {
            final long n2 = (long)(this.animationDuration * n);
            int n3 = 0;
            for (final ValueAnimator valueAnimator : ((AnimatorSet)this.animator).getChildAnimations()) {
                final long duration = valueAnimator.getDuration();
                long n5;
                final long n4 = n5 = n2;
                if (n3 != 0) {
                    n5 = n4 - duration;
                }
                if (n5 >= 0L) {
                    long currentPlayTime = n5;
                    if (n5 >= duration) {
                        currentPlayTime = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(currentPlayTime);
                    }
                    if (n3 != 0 || duration < this.animationDuration) {
                        continue;
                    }
                    n3 = 1;
                }
            }
        }
        return this;
    }
    
    public DropAnimation with(final int widthStart, final int widthEnd, final int heightStart, final int heightEnd, final int radius) {
        if (this.hasChanges(widthStart, widthEnd, heightStart, heightEnd, radius)) {
            this.animator = (T)this.createAnimator();
            this.widthStart = widthStart;
            this.widthEnd = widthEnd;
            this.heightStart = heightStart;
            this.heightEnd = heightEnd;
            this.radius = radius;
            final int n = (int)(radius / 1.5);
            final long n2 = this.animationDuration / 2L;
            ((AnimatorSet)this.animator).play((Animator)this.createValueAnimation(heightStart, heightEnd, n2, AnimationType.Height)).with((Animator)this.createValueAnimation(radius, n, n2, AnimationType.Radius)).with((Animator)this.createValueAnimation(widthStart, widthEnd, this.animationDuration, AnimationType.Width)).before((Animator)this.createValueAnimation(heightEnd, heightStart, n2, AnimationType.Height)).before((Animator)this.createValueAnimation(n, radius, n2, AnimationType.Radius));
        }
        return this;
    }
    
    private enum AnimationType
    {
        Height, 
        Radius, 
        Width;
    }
}
