// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.controller;

import com.rd.animation.data.Value;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.rd.animation.type.WormAnimation;
import com.rd.animation.type.ThinWormAnimation;
import com.rd.animation.type.SwapAnimation;
import com.rd.animation.type.SlideAnimation;
import com.rd.animation.type.ScaleAnimation;
import com.rd.animation.type.FillAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.ColorAnimation;

public class ValueController
{
    private ColorAnimation colorAnimation;
    private DropAnimation dropAnimation;
    private FillAnimation fillAnimation;
    private ScaleAnimation scaleAnimation;
    private SlideAnimation slideAnimation;
    private SwapAnimation swapAnimation;
    private ThinWormAnimation thinWormAnimation;
    private UpdateListener updateListener;
    private WormAnimation wormAnimation;
    
    public ValueController(@Nullable final UpdateListener updateListener) {
        this.updateListener = updateListener;
    }
    
    @NonNull
    public ColorAnimation color() {
        if (this.colorAnimation == null) {
            this.colorAnimation = new ColorAnimation(this.updateListener);
        }
        return this.colorAnimation;
    }
    
    @NonNull
    public DropAnimation drop() {
        if (this.dropAnimation == null) {
            this.dropAnimation = new DropAnimation(this.updateListener);
        }
        return this.dropAnimation;
    }
    
    @NonNull
    public FillAnimation fill() {
        if (this.fillAnimation == null) {
            this.fillAnimation = new FillAnimation(this.updateListener);
        }
        return this.fillAnimation;
    }
    
    @NonNull
    public ScaleAnimation scale() {
        if (this.scaleAnimation == null) {
            this.scaleAnimation = new ScaleAnimation(this.updateListener);
        }
        return this.scaleAnimation;
    }
    
    @NonNull
    public SlideAnimation slide() {
        if (this.slideAnimation == null) {
            this.slideAnimation = new SlideAnimation(this.updateListener);
        }
        return this.slideAnimation;
    }
    
    @NonNull
    public SwapAnimation swap() {
        if (this.swapAnimation == null) {
            this.swapAnimation = new SwapAnimation(this.updateListener);
        }
        return this.swapAnimation;
    }
    
    @NonNull
    public ThinWormAnimation thinWorm() {
        if (this.thinWormAnimation == null) {
            this.thinWormAnimation = new ThinWormAnimation(this.updateListener);
        }
        return this.thinWormAnimation;
    }
    
    @NonNull
    public WormAnimation worm() {
        if (this.wormAnimation == null) {
            this.wormAnimation = new WormAnimation(this.updateListener);
        }
        return this.wormAnimation;
    }
    
    public interface UpdateListener
    {
        void onValueUpdated(@Nullable final Value p0);
    }
}
