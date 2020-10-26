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
import java.io.File;
import java.io.InputStream;
import com.bumptech.glide.load.model.FileLoader;

public class StreamFileLoader extends FileLoader<InputStream> implements StreamModelLoader<File>
{
    public StreamFileLoader(final Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamFileLoader(final ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<File, InputStream>
    {
        @Override
        public ModelLoader<File, InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamFileLoader(genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
