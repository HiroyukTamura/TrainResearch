// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.data.ByteArrayFetcher;
import java.io.InputStream;
import com.bumptech.glide.load.data.DataFetcher;

public class StreamByteArrayLoader implements StreamModelLoader<byte[]>
{
    private final String id;
    
    public StreamByteArrayLoader() {
        this("");
    }
    
    @Deprecated
    public StreamByteArrayLoader(final String id) {
        this.id = id;
    }
    
    @Override
    public DataFetcher<InputStream> getResourceFetcher(final byte[] array, final int n, final int n2) {
        return new ByteArrayFetcher(array, this.id);
    }
    
    public static class Factory implements ModelLoaderFactory<byte[], InputStream>
    {
        @Override
        public ModelLoader<byte[], InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }
        
        @Override
        public void teardown() {
        }
    }
}
