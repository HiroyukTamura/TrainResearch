// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import java.io.FileNotFoundException;
import android.content.ContentResolver;
import java.io.IOException;
import android.net.Uri;
import android.content.Context;
import android.os.ParcelFileDescriptor;

public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor>
{
    public FileDescriptorLocalUriFetcher(final Context context, final Uri uri) {
        super(context, uri);
    }
    
    @Override
    protected void close(final ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
    
    @Override
    protected ParcelFileDescriptor loadResource(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }
}
