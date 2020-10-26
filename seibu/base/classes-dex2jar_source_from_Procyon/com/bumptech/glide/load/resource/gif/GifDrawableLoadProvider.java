// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.content.Context;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import java.io.InputStream;
import com.bumptech.glide.provider.DataLoadProvider;

public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable>
{
    private final FileToStreamDecoder<GifDrawable> cacheDecoder;
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;
    
    public GifDrawableLoadProvider(final Context context, final BitmapPool bitmapPool) {
        this.decoder = new GifResourceDecoder(context, bitmapPool);
        this.cacheDecoder = new FileToStreamDecoder<GifDrawable>(this.decoder);
        this.encoder = new GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new StreamEncoder();
    }
    
    @Override
    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    @Override
    public ResourceEncoder<GifDrawable> getEncoder() {
        return this.encoder;
    }
    
    @Override
    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return this.decoder;
    }
    
    @Override
    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
