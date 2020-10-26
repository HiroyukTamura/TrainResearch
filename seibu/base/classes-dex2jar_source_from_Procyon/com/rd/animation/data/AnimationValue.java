// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data;

import android.support.annotation.NonNull;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.data.type.SwapAnimationValue;
import com.rd.animation.data.type.ScaleAnimationValue;
import com.rd.animation.data.type.FillAnimationValue;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.animation.data.type.ColorAnimationValue;

public class AnimationValue
{
    private ColorAnimationValue colorAnimationValue;
    private DropAnimationValue dropAnimationValue;
    private FillAnimationValue fillAnimationValue;
    private ScaleAnimationValue scaleAnimationValue;
    private SwapAnimationValue swapAnimationValue;
    private ThinWormAnimationValue thinWormAnimationValue;
    private WormAnimationValue wormAnimationValue;
    
    @NonNull
    public ColorAnimationValue getColorAnimationValue() {
        if (this.colorAnimationValue == null) {
            this.colorAnimationValue = new ColorAnimationValue();
        }
        return this.colorAnimationValue;
    }
    
    @NonNull
    public DropAnimationValue getDropAnimationValue() {
        if (this.dropAnimationValue == null) {
            this.dropAnimationValue = new DropAnimationValue();
        }
        return this.dropAnimationValue;
    }
    
    @NonNull
    public FillAnimationValue getFillAnimationValue() {
        if (this.fillAnimationValue == null) {
            this.fillAnimationValue = new FillAnimationValue();
        }
        return this.fillAnimationValue;
    }
    
    @NonNull
    public ScaleAnimationValue getScaleAnimationValue() {
        if (this.scaleAnimationValue == null) {
            this.scaleAnimationValue = new ScaleAnimationValue();
        }
        return this.scaleAnimationValue;
    }
    
    @NonNull
    public SwapAnimationValue getSwapAnimationValue() {
        if (this.swapAnimationValue == null) {
            this.swapAnimationValue = new SwapAnimationValue();
        }
        return this.swapAnimationValue;
    }
    
    @NonNull
    public ThinWormAnimationValue getThinWormAnimationValue() {
        if (this.thinWormAnimationValue == null) {
            this.thinWormAnimationValue = new ThinWormAnimationValue();
        }
        return this.thinWormAnimationValue;
    }
    
    @NonNull
    public WormAnimationValue getWormAnimationValue() {
        if (this.wormAnimationValue == null) {
            this.wormAnimationValue = new WormAnimationValue();
        }
        return this.wormAnimationValue;
    }
}
