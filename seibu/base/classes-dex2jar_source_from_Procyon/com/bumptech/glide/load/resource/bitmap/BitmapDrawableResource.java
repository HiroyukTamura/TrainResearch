// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class BitmapDrawableResource extends DrawableResource<BitmapDrawable>
{
    private final BitmapPool bitmapPool;
    
    public BitmapDrawableResource(final BitmapDrawable bitmapDrawable, final BitmapPool bitmapPool) {
        super((Drawable)bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public int getSize() {
        return Util.getBitmapByteSize(((BitmapDrawable)this.drawable).getBitmap());
    }
    
    @Override
    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable)this.drawable).getBitmap());
    }
}
