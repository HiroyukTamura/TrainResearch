// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ResourceLoader;

public class FileDescriptorResourceLoader extends ResourceLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Integer>
{
    public FileDescriptorResourceLoader(final Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorResourceLoader(final Context context, final ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<Integer, ParcelFileDescriptor>
    {
        @Override
        public ModelLoader<Integer, ParcelFileDescriptor> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
