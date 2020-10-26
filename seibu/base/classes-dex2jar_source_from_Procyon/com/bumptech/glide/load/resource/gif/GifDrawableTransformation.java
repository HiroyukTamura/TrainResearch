// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.engine.Resource;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.Transformation;

public class GifDrawableTransformation implements Transformation<GifDrawable>
{
    private final BitmapPool bitmapPool;
    private final Transformation<Bitmap> wrapped;
    
    public GifDrawableTransformation(final Transformation<Bitmap> wrapped, final BitmapPool bitmapPool) {
        this.wrapped = wrapped;
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public String getId() {
        return this.wrapped.getId();
    }
    
    @Override
    public Resource<GifDrawable> transform(Resource<GifDrawable> gifDrawableResource, final int n, final int n2) {
        final GifDrawable gifDrawable = gifDrawableResource.get();
        final Bitmap firstFrame = gifDrawableResource.get().getFirstFrame();
        final Bitmap bitmap = this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), n, n2).get();
        if (!bitmap.equals(firstFrame)) {
            gifDrawableResource = new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped));
        }
        return gifDrawableResource;
    }
}
