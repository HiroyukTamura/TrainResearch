// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import android.graphics.Bitmap;
import java.io.InputStream;
import com.bumptech.glide.provider.DataLoadProvider;

public class StreamBitmapDataLoadProvider implements DataLoadProvider<InputStream, Bitmap>
{
    private final FileToStreamDecoder<Bitmap> cacheDecoder;
    private final StreamBitmapDecoder decoder;
    private final BitmapEncoder encoder;
    private final StreamEncoder sourceEncoder;
    
    public StreamBitmapDataLoadProvider(final BitmapPool bitmapPool, final DecodeFormat decodeFormat) {
        this.sourceEncoder = new StreamEncoder();
        this.decoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.encoder = new BitmapEncoder();
        this.cacheDecoder = new FileToStreamDecoder<Bitmap>(this.decoder);
    }
    
    @Override
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    @Override
    public ResourceEncoder<Bitmap> getEncoder() {
        return this.encoder;
    }
    
    @Override
    public ResourceDecoder<InputStream, Bitmap> getSourceDecoder() {
        return this.decoder;
    }
    
    @Override
    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
