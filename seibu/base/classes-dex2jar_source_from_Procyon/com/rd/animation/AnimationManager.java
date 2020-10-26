// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation;

import com.rd.animation.controller.ValueController;
import android.support.annotation.NonNull;
import com.rd.draw.data.Indicator;
import com.rd.animation.controller.AnimationController;

public class AnimationManager
{
    private AnimationController animationController;
    
    public AnimationManager(@NonNull final Indicator indicator, @NonNull final ValueController.UpdateListener updateListener) {
        this.animationController = new AnimationController(indicator, updateListener);
    }
    
    public void basic() {
        if (this.animationController != null) {
            this.animationController.end();
            this.animationController.basic();
        }
    }
    
    public void end() {
        if (this.animationController != null) {
            this.animationController.end();
        }
    }
    
    public void interactive(final float n) {
        if (this.animationController != null) {
            this.animationController.interactive(n);
        }
    }
}
