// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Encoder;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;
import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoDataLoadProvider implements DataLoadProvider<ImageVideoWrapper, Bitmap>
{
    private final ResourceDecoder<File, Bitmap> cacheDecoder;
    private final ResourceEncoder<Bitmap> encoder;
    private final ImageVideoBitmapDecoder sourceDecoder;
    private final ImageVideoWrapperEncoder sourceEncoder;
    
    public ImageVideoDataLoadProvider(final DataLoadProvider<InputStream, Bitmap> dataLoadProvider, final DataLoadProvider<ParcelFileDescriptor, Bitmap> dataLoadProvider2) {
        this.encoder = dataLoadProvider.getEncoder();
        this.sourceEncoder = new ImageVideoWrapperEncoder(dataLoadProvider.getSourceEncoder(), dataLoadProvider2.getSourceEncoder());
        this.cacheDecoder = dataLoadProvider.getCacheDecoder();
        this.sourceDecoder = new ImageVideoBitmapDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder());
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
    public ResourceDecoder<ImageVideoWrapper, Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }
    
    @Override
    public Encoder<ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
