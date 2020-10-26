// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapper
{
    private final Resource<Bitmap> bitmapResource;
    private final Resource<GifDrawable> gifResource;
    
    public GifBitmapWrapper(final Resource<Bitmap> bitmapResource, final Resource<GifDrawable> gifResource) {
        if (bitmapResource != null && gifResource != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (bitmapResource == null && gifResource == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.bitmapResource = bitmapResource;
        this.gifResource = gifResource;
    }
    
    public Resource<Bitmap> getBitmapResource() {
        return this.bitmapResource;
    }
    
    public Resource<GifDrawable> getGifResource() {
        return this.gifResource;
    }
    
    public int getSize() {
        if (this.bitmapResource != null) {
            return this.bitmapResource.getSize();
        }
        return this.gifResource.getSize();
    }
}
