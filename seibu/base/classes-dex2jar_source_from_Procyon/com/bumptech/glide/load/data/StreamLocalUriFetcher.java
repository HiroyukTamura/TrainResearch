// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import java.io.FileNotFoundException;
import android.content.ContentResolver;
import java.io.IOException;
import android.net.Uri;
import android.content.Context;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream>
{
    public StreamLocalUriFetcher(final Context context, final Uri uri) {
        super(context, uri);
    }
    
    @Override
    protected void close(final InputStream inputStream) throws IOException {
        inputStream.close();
    }
    
    @Override
    protected InputStream loadResource(final Uri uri, final ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }
}
