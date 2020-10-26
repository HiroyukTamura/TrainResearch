// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GlideBitmapDrawableResource extends DrawableResource<GlideBitmapDrawable>
{
    private final BitmapPool bitmapPool;
    
    public GlideBitmapDrawableResource(final GlideBitmapDrawable glideBitmapDrawable, final BitmapPool bitmapPool) {
        super(glideBitmapDrawable);
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public int getSize() {
        return Util.getBitmapByteSize(((GlideBitmapDrawable)this.drawable).getBitmap());
    }
    
    @Override
    public void recycle() {
        this.bitmapPool.put(((GlideBitmapDrawable)this.drawable).getBitmap());
    }
}
