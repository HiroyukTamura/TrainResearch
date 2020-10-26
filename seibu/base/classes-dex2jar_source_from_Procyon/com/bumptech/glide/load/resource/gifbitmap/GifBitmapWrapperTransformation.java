// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;

public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper>
{
    private final Transformation<Bitmap> bitmapTransformation;
    private final Transformation<GifDrawable> gifDataTransformation;
    
    GifBitmapWrapperTransformation(final Transformation<Bitmap> bitmapTransformation, final Transformation<GifDrawable> gifDataTransformation) {
        this.bitmapTransformation = bitmapTransformation;
        this.gifDataTransformation = gifDataTransformation;
    }
    
    public GifBitmapWrapperTransformation(final BitmapPool bitmapPool, final Transformation<Bitmap> transformation) {
        this(transformation, new GifDrawableTransformation(transformation, bitmapPool));
    }
    
    @Override
    public String getId() {
        return this.bitmapTransformation.getId();
    }
    
    @Override
    public Resource<GifBitmapWrapper> transform(final Resource<GifBitmapWrapper> resource, final int n, final int n2) {
        final Resource<Bitmap> bitmapResource = resource.get().getBitmapResource();
        final Resource<GifDrawable> gifResource = resource.get().getGifResource();
        Resource<GifBitmapWrapper> resource2;
        if (bitmapResource != null && this.bitmapTransformation != null) {
            final Resource<Bitmap> transform = this.bitmapTransformation.transform(bitmapResource, n, n2);
            resource2 = resource;
            if (!bitmapResource.equals(transform)) {
                resource2 = new GifBitmapWrapperResource(new GifBitmapWrapper(transform, resource.get().getGifResource()));
            }
        }
        else {
            resource2 = resource;
            if (gifResource != null) {
                resource2 = resource;
                if (this.gifDataTransformation != null) {
                    final Resource<GifDrawable> transform2 = this.gifDataTransformation.transform(gifResource, n, n2);
                    resource2 = resource;
                    if (!gifResource.equals(transform2)) {
                        return new GifBitmapWrapperResource(new GifBitmapWrapper(resource.get().getBitmapResource(), transform2));
                    }
                }
            }
        }
        return resource2;
    }
}
