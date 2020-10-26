// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gif;

import java.io.IOException;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;

class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap>
{
    private final BitmapPool bitmapPool;
    
    public GifFrameResourceDecoder(final BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public Resource<Bitmap> decode(final GifDecoder gifDecoder, final int n, final int n2) {
        return BitmapResource.obtain(gifDecoder.getNextFrame(), this.bitmapPool);
    }
    
    @Override
    public String getId() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
