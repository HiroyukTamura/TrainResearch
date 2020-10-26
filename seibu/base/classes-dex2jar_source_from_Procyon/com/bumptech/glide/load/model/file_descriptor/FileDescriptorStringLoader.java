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
import com.bumptech.glide.load.model.StringLoader;

public class FileDescriptorStringLoader extends StringLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<String>
{
    public FileDescriptorStringLoader(final Context context) {
        this(Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorStringLoader(final ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<String, ParcelFileDescriptor>
    {
        @Override
        public ModelLoader<String, ParcelFileDescriptor> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorStringLoader(genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
