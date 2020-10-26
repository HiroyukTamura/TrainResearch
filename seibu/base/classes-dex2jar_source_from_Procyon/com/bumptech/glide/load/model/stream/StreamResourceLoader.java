// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import java.io.InputStream;
import com.bumptech.glide.load.model.ResourceLoader;

public class StreamResourceLoader extends ResourceLoader<InputStream> implements StreamModelLoader<Integer>
{
    public StreamResourceLoader(final Context context) {
        this(context, Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamResourceLoader(final Context context, final ModelLoader<Uri, InputStream> modelLoader) {
        super(context, modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<Integer, InputStream>
    {
        @Override
        public ModelLoader<Integer, InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
