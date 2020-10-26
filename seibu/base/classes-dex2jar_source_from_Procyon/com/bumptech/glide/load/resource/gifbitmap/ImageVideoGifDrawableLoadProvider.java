// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.InputStream;
import android.graphics.Bitmap;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoGifDrawableLoadProvider implements DataLoadProvider<ImageVideoWrapper, GifBitmapWrapper>
{
    private final ResourceDecoder<File, GifBitmapWrapper> cacheDecoder;
    private final ResourceEncoder<GifBitmapWrapper> encoder;
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> sourceDecoder;
    private final Encoder<ImageVideoWrapper> sourceEncoder;
    
    public ImageVideoGifDrawableLoadProvider(final DataLoadProvider<ImageVideoWrapper, Bitmap> dataLoadProvider, final DataLoadProvider<InputStream, GifDrawable> dataLoadProvider2, final BitmapPool bitmapPool) {
        final GifBitmapWrapperResourceDecoder sourceDecoder = new GifBitmapWrapperResourceDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder(), bitmapPool);
        this.cacheDecoder = new FileToStreamDecoder<GifBitmapWrapper>((ResourceDecoder<InputStream, Object>)new GifBitmapWrapperStreamResourceDecoder(sourceDecoder));
        this.sourceDecoder = sourceDecoder;
        this.encoder = new GifBitmapWrapperResourceEncoder(dataLoadProvider.getEncoder(), dataLoadProvider2.getEncoder());
        this.sourceEncoder = dataLoadProvider.getSourceEncoder();
    }
    
    @Override
    public ResourceDecoder<File, GifBitmapWrapper> getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    @Override
    public ResourceEncoder<GifBitmapWrapper> getEncoder() {
        return this.encoder;
    }
    
    @Override
    public ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> getSourceDecoder() {
        return this.sourceDecoder;
    }
    
    @Override
    public Encoder<ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
