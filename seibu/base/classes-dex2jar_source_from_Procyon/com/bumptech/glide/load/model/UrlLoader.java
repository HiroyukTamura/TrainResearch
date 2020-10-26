// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import java.net.URL;

public class UrlLoader<T> implements ModelLoader<URL, T>
{
    private final ModelLoader<GlideUrl, T> glideUrlLoader;
    
    public UrlLoader(final ModelLoader<GlideUrl, T> glideUrlLoader) {
        this.glideUrlLoader = glideUrlLoader;
    }
    
    @Override
    public DataFetcher<T> getResourceFetcher(final URL url, final int n, final int n2) {
        return this.glideUrlLoader.getResourceFetcher(new GlideUrl(url), n, n2);
    }
}
