// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import com.bumptech.glide.load.model.UriLoader;

public class StreamUriLoader extends UriLoader<InputStream> implements StreamModelLoader<Uri>
{
    public StreamUriLoader(final Context context) {
        this(context, Glide.buildStreamModelLoader(GlideUrl.class, context));
    }
    
    public StreamUriLoader(final Context context, final ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(context, modelLoader);
    }
    
    @Override
    protected DataFetcher<InputStream> getAssetPathFetcher(final Context context, final String s) {
        return new StreamAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }
    
    @Override
    protected DataFetcher<InputStream> getLocalUriFetcher(final Context context, final Uri uri) {
        return new StreamLocalUriFetcher(context, uri);
    }
    
    public static class Factory implements ModelLoaderFactory<Uri, InputStream>
    {
        @Override
        public ModelLoader<Uri, InputStream> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new StreamUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
