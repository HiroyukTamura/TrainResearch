// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable>
{
    public GifDrawableResource(final GifDrawable gifDrawable) {
        super(gifDrawable);
    }
    
    @Override
    public int getSize() {
        return Util.getBitmapByteSize(((GifDrawable)this.drawable).getFirstFrame()) + ((GifDrawable)this.drawable).getData().length;
    }
    
    @Override
    public void recycle() {
        ((GifDrawable)this.drawable).stop();
        ((GifDrawable)this.drawable).recycle();
    }
}
