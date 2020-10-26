// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import java.util.Map;
import java.net.MalformedURLException;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;

public class GlideUrl
{
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;
    
    public GlideUrl(final String s) {
        this(s, Headers.DEFAULT);
    }
    
    public GlideUrl(final String s, final Headers headers) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + s);
        }
        if (headers == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.stringUrl = s;
        this.url = null;
        this.headers = headers;
    }
    
    public GlideUrl(final URL url) {
        this(url, Headers.DEFAULT);
    }
    
    public GlideUrl(final URL url, final Headers headers) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (headers == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.url = url;
        this.stringUrl = null;
        this.headers = headers;
    }
    
    private String getSafeStringUrl() {
        if (TextUtils.isEmpty((CharSequence)this.safeStringUrl)) {
            String s;
            if (TextUtils.isEmpty((CharSequence)(s = this.stringUrl))) {
                s = this.url.toString();
            }
            this.safeStringUrl = Uri.encode(s, "@#&=*+-_.,:!?()/~'%");
        }
        return this.safeStringUrl;
    }
    
    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(this.getSafeStringUrl());
        }
        return this.safeUrl;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof GlideUrl) {
            final GlideUrl glideUrl = (GlideUrl)o;
            b2 = b;
            if (this.getCacheKey().equals(glideUrl.getCacheKey())) {
                b2 = b;
                if (this.headers.equals(glideUrl.headers)) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public String getCacheKey() {
        if (this.stringUrl != null) {
            return this.stringUrl;
        }
        return this.url.toString();
    }
    
    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }
    
    @Override
    public int hashCode() {
        return this.getCacheKey().hashCode() * 31 + this.headers.hashCode();
    }
    
    @Override
    public String toString() {
        return this.getCacheKey() + '\n' + this.headers.toString();
    }
    
    public String toStringUrl() {
        return this.getSafeStringUrl();
    }
    
    public URL toURL() throws MalformedURLException {
        return this.getSafeUrl();
    }
}
