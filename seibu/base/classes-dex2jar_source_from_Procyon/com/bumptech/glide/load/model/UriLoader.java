// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;
import android.net.Uri;

public abstract class UriLoader<T> implements ModelLoader<Uri, T>
{
    private final Context context;
    private final ModelLoader<GlideUrl, T> urlLoader;
    
    public UriLoader(final Context context, final ModelLoader<GlideUrl, T> urlLoader) {
        this.context = context;
        this.urlLoader = urlLoader;
    }
    
    private static boolean isLocalUri(final String anObject) {
        return "file".equals(anObject) || "content".equals(anObject) || "android.resource".equals(anObject);
    }
    
    protected abstract DataFetcher<T> getAssetPathFetcher(final Context p0, final String p1);
    
    protected abstract DataFetcher<T> getLocalUriFetcher(final Context p0, final Uri p1);
    
    @Override
    public final DataFetcher<T> getResourceFetcher(final Uri uri, final int n, final int n2) {
        final String scheme = uri.getScheme();
        final DataFetcher<T> dataFetcher = null;
        DataFetcher<T> assetPathFetcher;
        if (isLocalUri(scheme)) {
            if (!AssetUriParser.isAssetUri(uri)) {
                return this.getLocalUriFetcher(this.context, uri);
            }
            assetPathFetcher = this.getAssetPathFetcher(this.context, AssetUriParser.toAssetPath(uri));
        }
        else {
            assetPathFetcher = dataFetcher;
            if (this.urlLoader != null) {
                if (!"http".equals(scheme)) {
                    assetPathFetcher = dataFetcher;
                    if (!"https".equals(scheme)) {
                        return assetPathFetcher;
                    }
                }
                return this.urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), n, n2);
            }
        }
        return assetPathFetcher;
    }
}
