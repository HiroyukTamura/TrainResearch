// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.gifdecoder.GifDecoder;

class GifBitmapProvider implements BitmapProvider
{
    private final BitmapPool bitmapPool;
    
    public GifBitmapProvider(final BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public Bitmap obtain(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return this.bitmapPool.getDirty(n, n2, bitmap$Config);
    }
    
    @Override
    public void release(final Bitmap bitmap) {
        if (!this.bitmapPool.put(bitmap)) {
            bitmap.recycle();
        }
    }
}
