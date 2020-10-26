// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import android.media.MediaMetadataRetriever;
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.os.ParcelFileDescriptor;

public class VideoBitmapDecoder implements BitmapDecoder<ParcelFileDescriptor>
{
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY;
    private static final int NO_FRAME = -1;
    private MediaMetadataRetrieverFactory factory;
    private int frame;
    
    static {
        DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    }
    
    public VideoBitmapDecoder() {
        this(VideoBitmapDecoder.DEFAULT_FACTORY, -1);
    }
    
    public VideoBitmapDecoder(final int n) {
        this(VideoBitmapDecoder.DEFAULT_FACTORY, checkValidFrame(n));
    }
    
    VideoBitmapDecoder(final MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this(mediaMetadataRetrieverFactory, -1);
    }
    
    VideoBitmapDecoder(final MediaMetadataRetrieverFactory factory, final int frame) {
        this.factory = factory;
        this.frame = frame;
    }
    
    private static int checkValidFrame(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Requested frame must be non-negative");
        }
        return n;
    }
    
    @Override
    public Bitmap decode(final ParcelFileDescriptor parcelFileDescriptor, final BitmapPool bitmapPool, final int n, final int n2, final DecodeFormat decodeFormat) throws IOException {
        final MediaMetadataRetriever build = this.factory.build();
        build.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap bitmap;
        if (this.frame >= 0) {
            bitmap = build.getFrameAtTime((long)this.frame);
        }
        else {
            bitmap = build.getFrameAtTime();
        }
        build.release();
        parcelFileDescriptor.close();
        return bitmap;
    }
    
    @Override
    public String getId() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
    
    static class MediaMetadataRetrieverFactory
    {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }
}
