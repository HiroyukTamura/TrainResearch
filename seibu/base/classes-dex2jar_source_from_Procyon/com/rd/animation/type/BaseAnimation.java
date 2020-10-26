// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.type;

import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.rd.animation.controller.ValueController;
import android.animation.Animator;

public abstract class BaseAnimation<T extends Animator>
{
    public static final int DEFAULT_ANIMATION_TIME = 350;
    protected long animationDuration;
    protected T animator;
    protected ValueController.UpdateListener listener;
    
    public BaseAnimation(@Nullable final ValueController.UpdateListener listener) {
        this.animationDuration = 350L;
        this.listener = listener;
        this.animator = this.createAnimator();
    }
    
    @NonNull
    public abstract T createAnimator();
    
    public BaseAnimation duration(final long animationDuration) {
        this.animationDuration = animationDuration;
        if (this.animator instanceof ValueAnimator) {
            this.animator.setDuration(this.animationDuration);
        }
        return this;
    }
    
    public void end() {
        if (this.animator != null && this.animator.isStarted()) {
            this.animator.end();
        }
    }
    
    public abstract BaseAnimation progress(final float p0);
    
    public void start() {
        if (this.animator != null && !this.animator.isRunning()) {
            this.animator.start();
        }
    }
}
