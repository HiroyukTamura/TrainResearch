// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import java.io.IOException;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.InputStream;
import com.bumptech.glide.load.ResourceDecoder;

public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder<InputStream, GifBitmapWrapper>
{
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder;
    
    public GifBitmapWrapperStreamResourceDecoder(final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder) {
        this.gifBitmapDecoder = gifBitmapDecoder;
    }
    
    @Override
    public Resource<GifBitmapWrapper> decode(final InputStream inputStream, final int n, final int n2) throws IOException {
        return this.gifBitmapDecoder.decode(new ImageVideoWrapper(inputStream, null), n, n2);
    }
    
    @Override
    public String getId() {
        return this.gifBitmapDecoder.getId();
    }
}
