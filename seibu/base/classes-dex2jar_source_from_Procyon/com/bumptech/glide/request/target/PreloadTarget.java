// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;

public final class PreloadTarget<Z> extends SimpleTarget<Z>
{
    private PreloadTarget(final int n, final int n2) {
        super(n, n2);
    }
    
    public static <Z> PreloadTarget<Z> obtain(final int n, final int n2) {
        return new PreloadTarget<Z>(n, n2);
    }
    
    @Override
    public void onResourceReady(final Z b, final GlideAnimation<? super Z> glideAnimation) {
        Glide.clear(this);
    }
}
