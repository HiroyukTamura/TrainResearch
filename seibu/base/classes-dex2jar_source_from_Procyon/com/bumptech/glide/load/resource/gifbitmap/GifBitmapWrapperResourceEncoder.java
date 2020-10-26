// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceEncoder;

public class GifBitmapWrapperResourceEncoder implements ResourceEncoder<GifBitmapWrapper>
{
    private final ResourceEncoder<Bitmap> bitmapEncoder;
    private final ResourceEncoder<GifDrawable> gifEncoder;
    private String id;
    
    public GifBitmapWrapperResourceEncoder(final ResourceEncoder<Bitmap> bitmapEncoder, final ResourceEncoder<GifDrawable> gifEncoder) {
        this.bitmapEncoder = bitmapEncoder;
        this.gifEncoder = gifEncoder;
    }
    
    @Override
    public boolean encode(final Resource<GifBitmapWrapper> resource, final OutputStream outputStream) {
        final GifBitmapWrapper gifBitmapWrapper = resource.get();
        final Resource<Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapEncoder.encode(bitmapResource, outputStream);
        }
        return this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }
    
    @Override
    public String getId() {
        if (this.id == null) {
            this.id = this.bitmapEncoder.getId() + this.gifEncoder.getId();
        }
        return this.id;
    }
}
