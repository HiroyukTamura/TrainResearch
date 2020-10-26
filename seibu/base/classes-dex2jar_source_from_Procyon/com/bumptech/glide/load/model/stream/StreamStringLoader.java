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
import com.bumptech.glide.load.model.StringLoader;

public class StreamStringLoader extends StringLoader<InputStream> implements StreamModelLoader<String>
{
    public StreamStringLoader(final Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamStringLoader(final ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<String, InputStream>
    {
        @Override
        public ModelLoader<String, InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamStringLoader(genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
