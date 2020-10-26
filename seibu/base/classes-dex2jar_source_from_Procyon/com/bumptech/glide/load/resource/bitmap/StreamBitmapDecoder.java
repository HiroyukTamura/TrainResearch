// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.Glide;
import android.content.Context;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import java.io.InputStream;
import com.bumptech.glide.load.ResourceDecoder;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap>
{
    private static final String ID = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    private BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private final Downsampler downsampler;
    private String id;
    
    public StreamBitmapDecoder(final Context context) {
        this(Glide.get(context).getBitmapPool());
    }
    
    public StreamBitmapDecoder(final Context context, final DecodeFormat decodeFormat) {
        this(Glide.get(context).getBitmapPool(), decodeFormat);
    }
    
    public StreamBitmapDecoder(final BitmapPool bitmapPool) {
        this(bitmapPool, DecodeFormat.DEFAULT);
    }
    
    public StreamBitmapDecoder(final BitmapPool bitmapPool, final DecodeFormat decodeFormat) {
        this(Downsampler.AT_LEAST, bitmapPool, decodeFormat);
    }
    
    public StreamBitmapDecoder(final Downsampler downsampler, final BitmapPool bitmapPool, final DecodeFormat decodeFormat) {
        this.downsampler = downsampler;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }
    
    @Override
    public Resource<Bitmap> decode(final InputStream inputStream, final int n, final int n2) {
        return BitmapResource.obtain(this.downsampler.decode(inputStream, this.bitmapPool, n, n2, this.decodeFormat), this.bitmapPool);
    }
    
    @Override
    public String getId() {
        if (this.id == null) {
            this.id = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.downsampler.getId() + this.decodeFormat.name();
        }
        return this.id;
    }
}
