// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;

public abstract class BitmapTransformation implements Transformation<Bitmap>
{
    private BitmapPool bitmapPool;
    
    public BitmapTransformation(final Context context) {
        this(Glide.get(context).getBitmapPool());
    }
    
    public BitmapTransformation(final BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }
    
    protected abstract Bitmap transform(final BitmapPool p0, final Bitmap p1, final int p2, final int p3);
    
    @Override
    public final Resource<Bitmap> transform(final Resource<Bitmap> resource, int width, int height) {
        if (!Util.isValidDimensions(width, height)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + width + " or height: " + height + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        final Bitmap bitmap = resource.get();
        if (width == Integer.MIN_VALUE) {
            width = bitmap.getWidth();
        }
        if (height == Integer.MIN_VALUE) {
            height = bitmap.getHeight();
        }
        final Bitmap transform = this.transform(this.bitmapPool, bitmap, width, height);
        if (bitmap.equals(transform)) {
            return resource;
        }
        return BitmapResource.obtain(transform, this.bitmapPool);
    }
}
