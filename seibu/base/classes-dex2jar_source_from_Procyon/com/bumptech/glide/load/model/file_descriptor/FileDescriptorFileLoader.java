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
import java.io.File;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.FileLoader;

public class FileDescriptorFileLoader extends FileLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<File>
{
    public FileDescriptorFileLoader(final Context context) {
        this(Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorFileLoader(final ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(modelLoader);
    }
    
    public static class Factory implements ModelLoaderFactory<File, ParcelFileDescriptor>
    {
        @Override
        public ModelLoader<File, ParcelFileDescriptor> build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorFileLoader(genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }
        
        @Override
        public void teardown() {
        }
    }
}
