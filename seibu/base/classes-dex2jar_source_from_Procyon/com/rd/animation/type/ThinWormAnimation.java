// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import android.animation.Animator;
import com.rd.animation.data.type.WormAnimationValue;
import android.animation.AnimatorSet;
import com.rd.animation.data.Value;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ThinWormAnimationValue;

public class ThinWormAnimation extends WormAnimation
{
    private ThinWormAnimationValue value;
    
    public ThinWormAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new ThinWormAnimationValue();
    }
    
    private ValueAnimator createHeightAnimator(final int n, final int n2, final long duration) {
        final ValueAnimator ofInt = ValueAnimator.ofInt(new int[] { n, n2 });
        ofInt.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        ofInt.setDuration(duration);
        ofInt.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                ThinWormAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return ofInt;
    }
    
    private void onAnimateUpdated(@NonNull final ValueAnimator valueAnimator) {
        this.value.setHeight((int)valueAnimator.getAnimatedValue());
        if (this.listener != null) {
            this.listener.onValueUpdated(this.value);
        }
    }
    
    @Override
    public ThinWormAnimation duration(final long n) {
        super.duration(n);
        return this;
    }
    
    @Override
    public ThinWormAnimation progress(final float n) {
        if (this.animator != null) {
            final long n2 = (long)(this.animationDuration * n);
            for (int size = ((AnimatorSet)this.animator).getChildAnimations().size(), i = 0; i < size; ++i) {
                final ValueAnimator valueAnimator = ((AnimatorSet)this.animator).getChildAnimations().get(i);
                final long n3 = n2 - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (n3 <= duration) {
                    duration = n3;
                    if (n3 < 0L) {
                        duration = 0L;
                    }
                }
                if ((i != size - 1 || duration > 0L) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(duration);
                }
            }
        }
        return this;
    }
    
    @Override
    public WormAnimation with(final int coordinateStart, int n, final int radius, final boolean isRightSide) {
        if (this.hasChanges(coordinateStart, n, radius, isRightSide)) {
            this.animator = (T)this.createAnimator();
            this.coordinateStart = coordinateStart;
            this.coordinateEnd = n;
            this.radius = radius;
            this.isRightSide = isRightSide;
            n = radius * 2;
            this.rectLeftEdge = coordinateStart - radius;
            this.rectRightEdge = coordinateStart + radius;
            this.value.setRectStart(this.rectLeftEdge);
            this.value.setRectEnd(this.rectRightEdge);
            this.value.setHeight(n);
            final RectValues rectValues = this.createRectValues(isRightSide);
            final long n2 = (long)(this.animationDuration * 0.8);
            final long startDelay = (long)(this.animationDuration * 0.2);
            final long n3 = (long)(this.animationDuration * 0.5);
            final long startDelay2 = (long)(this.animationDuration * 0.5);
            final ValueAnimator wormAnimator = this.createWormAnimator(rectValues.fromX, rectValues.toX, n2, false, this.value);
            final ValueAnimator wormAnimator2 = this.createWormAnimator(rectValues.reverseFromX, rectValues.reverseToX, n2, true, this.value);
            wormAnimator2.setStartDelay(startDelay);
            final ValueAnimator heightAnimator = this.createHeightAnimator(n, radius, n3);
            final ValueAnimator heightAnimator2 = this.createHeightAnimator(radius, n, n3);
            heightAnimator2.setStartDelay(startDelay2);
            ((AnimatorSet)this.animator).playTogether(new Animator[] { (Animator)wormAnimator, (Animator)wormAnimator2, (Animator)heightAnimator, (Animator)heightAnimator2 });
        }
        return this;
    }
}
