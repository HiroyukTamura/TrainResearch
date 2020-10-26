// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import java.net.URL;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import com.bumptech.glide.load.model.UrlLoader;

public class StreamUrlLoader extends UrlLoader<InputStream>
{
    public StreamUrlLoader(final ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<URL, InputStream>
    {
        @Override
        public ModelLoader<URL, InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamUrlLoader(genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
