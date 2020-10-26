// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import java.util.Iterator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.Animator;
import com.rd.animation.data.Value;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.WormAnimationValue;
import android.animation.AnimatorSet;

public class WormAnimation extends BaseAnimation<AnimatorSet>
{
    int coordinateEnd;
    int coordinateStart;
    boolean isRightSide;
    int radius;
    int rectLeftEdge;
    int rectRightEdge;
    private WormAnimationValue value;
    
    public WormAnimation(@NonNull final ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.value = new WormAnimationValue();
    }
    
    private void onAnimateUpdated(@NonNull final WormAnimationValue wormAnimationValue, @NonNull final ValueAnimator valueAnimator, final boolean b) {
        final int intValue = (int)valueAnimator.getAnimatedValue();
        if (this.isRightSide) {
            if (!b) {
                wormAnimationValue.setRectEnd(intValue);
            }
            else {
                wormAnimationValue.setRectStart(intValue);
            }
        }
        else if (!b) {
            wormAnimationValue.setRectStart(intValue);
        }
        else {
            wormAnimationValue.setRectEnd(intValue);
        }
        if (this.listener != null) {
            this.listener.onValueUpdated(wormAnimationValue);
        }
    }
    
    @NonNull
    @Override
    public AnimatorSet createAnimator() {
        final AnimatorSet set = new AnimatorSet();
        set.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        return set;
    }
    
    @NonNull
    RectValues createRectValues(final boolean b) {
        int n;
        int n2;
        int n3;
        int n4;
        if (b) {
            n = this.coordinateStart + this.radius;
            n2 = this.coordinateEnd + this.radius;
            n3 = this.coordinateStart - this.radius;
            n4 = this.coordinateEnd - this.radius;
        }
        else {
            n = this.coordinateStart - this.radius;
            n2 = this.coordinateEnd - this.radius;
            n3 = this.coordinateStart + this.radius;
            n4 = this.coordinateEnd + this.radius;
        }
        return new RectValues(n, n2, n3, n4);
    }
    
    ValueAnimator createWormAnimator(final int n, final int n2, final long duration, final boolean b, final WormAnimationValue wormAnimationValue) {
        final ValueAnimator ofInt = ValueAnimator.ofInt(new int[] { n, n2 });
        ofInt.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        ofInt.setDuration(duration);
        ofInt.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                WormAnimation.this.onAnimateUpdated(wormAnimationValue, valueAnimator, b);
            }
        });
        return ofInt;
    }
    
    @Override
    public WormAnimation duration(final long n) {
        super.duration(n);
        return this;
    }
    
    boolean hasChanges(final int n, final int n2, final int n3, final boolean b) {
        return this.coordinateStart != n || this.coordinateEnd != n2 || this.radius != n3 || this.isRightSide != b;
    }
    
    @Override
    public WormAnimation progress(final float n) {
        if (this.animator != null) {
            long n2 = (long)(this.animationDuration * n);
            for (final ValueAnimator valueAnimator : ((AnimatorSet)this.animator).getChildAnimations()) {
                final long duration = valueAnimator.getDuration();
                long currentPlayTime;
                if ((currentPlayTime = n2) > duration) {
                    currentPlayTime = duration;
                }
                valueAnimator.setCurrentPlayTime(currentPlayTime);
                n2 -= currentPlayTime;
            }
        }
        return this;
    }
    
    public WormAnimation with(final int coordinateStart, final int coordinateEnd, final int radius, final boolean isRightSide) {
        if (this.hasChanges(coordinateStart, coordinateEnd, radius, isRightSide)) {
            this.animator = (T)this.createAnimator();
            this.coordinateStart = coordinateStart;
            this.coordinateEnd = coordinateEnd;
            this.radius = radius;
            this.isRightSide = isRightSide;
            this.rectLeftEdge = coordinateStart - radius;
            this.rectRightEdge = coordinateStart + radius;
            this.value.setRectStart(this.rectLeftEdge);
            this.value.setRectEnd(this.rectRightEdge);
            final RectValues rectValues = this.createRectValues(isRightSide);
            final long n = this.animationDuration / 2L;
            ((AnimatorSet)this.animator).playSequentially(new Animator[] { (Animator)this.createWormAnimator(rectValues.fromX, rectValues.toX, n, false, this.value), (Animator)this.createWormAnimator(rectValues.reverseFromX, rectValues.reverseToX, n, true, this.value) });
        }
        return this;
    }
    
    class RectValues
    {
        final int fromX;
        final int reverseFromX;
        final int reverseToX;
        final int toX;
        
        RectValues(final int fromX, final int toX, final int reverseFromX, final int reverseToX) {
            this.fromX = fromX;
            this.toX = toX;
            this.reverseFromX = reverseFromX;
            this.reverseToX = reverseToX;
        }
    }
}
