// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.MediaStoreThumbFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;
import java.io.InputStream;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;

public class MediaStoreStreamLoader implements ModelLoader<Uri, InputStream>
{
    private final Context context;
    private final ModelLoader<Uri, InputStream> uriLoader;
    
    public MediaStoreStreamLoader(final Context context, final ModelLoader<Uri, InputStream> uriLoader) {
        this.context = context;
        this.uriLoader = uriLoader;
    }
    
    @Override
    public DataFetcher<InputStream> getResourceFetcher(final Uri uri, final int n, final int n2) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, n, n2), n, n2);
    }
}
