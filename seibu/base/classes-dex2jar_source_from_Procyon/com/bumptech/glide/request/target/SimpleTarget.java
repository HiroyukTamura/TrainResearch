// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

public abstract class SimpleTarget<Z> extends BaseTarget<Z>
{
    private final int height;
    private final int width;
    
    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public SimpleTarget(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public final void getSize(final SizeReadyCallback sizeReadyCallback) {
        if (!Util.isValidDimensions(this.width, this.height)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor" + " or call override()");
        }
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }
}
