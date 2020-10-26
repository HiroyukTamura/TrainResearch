// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.UriLoader;

public class FileDescriptorUriLoader extends UriLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Uri>
{
    public FileDescriptorUriLoader(final Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(GlideUrl.class, context));
    }
    
    public FileDescriptorUriLoader(final Context context, final ModelLoader<GlideUrl, ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }
    
    @Override
    protected DataFetcher<ParcelFileDescriptor> getAssetPathFetcher(final Context context, final String s) {
        return new FileDescriptorAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }
    
    @Override
    protected DataFetcher<ParcelFileDescriptor> getLocalUriFetcher(final Context context, final Uri uri) {
        return new FileDescriptorLocalUriFetcher(context, uri);
    }
    
    public static class Factory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>
    {
        @Override
        public ModelLoader<Uri, ParcelFileDescriptor> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, ParcelFileDescriptor.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
