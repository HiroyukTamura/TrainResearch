// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.util.Iterator;
import java.net.URISyntaxException;
import java.util.Map;
import java.net.URL;
import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.util.ContentLengthInputStream;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import com.bumptech.glide.load.model.GlideUrl;
import java.io.InputStream;

public class HttpUrlFetcher implements DataFetcher<InputStream>
{
    private static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY;
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;
    
    static {
        DEFAULT_CONNECTION_FACTORY = (HttpUrlConnectionFactory)new DefaultHttpUrlConnectionFactory();
    }
    
    public HttpUrlFetcher(final GlideUrl glideUrl) {
        this(glideUrl, HttpUrlFetcher.DEFAULT_CONNECTION_FACTORY);
    }
    
    HttpUrlFetcher(final GlideUrl glideUrl, final HttpUrlConnectionFactory connectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = connectionFactory;
    }
    
    private InputStream getStreamForSuccessfulRequest(final HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty((CharSequence)httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        }
        else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }
    
    private InputStream loadDataWithRedirects(final URL context, final int n, final URL url, final Map<String, String> map) throws IOException {
        if (n >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url != null) {
            try {
                if (context.toURI().equals(url.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            }
            catch (URISyntaxException ex) {}
        }
        this.urlConnection = this.connectionFactory.build(context);
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.urlConnection.setConnectTimeout(2500);
        this.urlConnection.setReadTimeout(2500);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.connect();
        if (this.isCancelled) {
            return null;
        }
        final int responseCode = this.urlConnection.getResponseCode();
        if (responseCode / 100 == 2) {
            return this.getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (responseCode / 100 == 3) {
            final String headerField = this.urlConnection.getHeaderField("Location");
            if (TextUtils.isEmpty((CharSequence)headerField)) {
                throw new IOException("Received empty or null redirect url");
            }
            return this.loadDataWithRedirects(new URL(context, headerField), n + 1, context, map);
        }
        else {
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.urlConnection.getResponseMessage());
        }
    }
    
    @Override
    public void cancel() {
        this.isCancelled = true;
    }
    
    @Override
    public void cleanup() {
        while (true) {
            if (this.stream == null) {
                break Label_0014;
            }
            try {
                this.stream.close();
                if (this.urlConnection != null) {
                    this.urlConnection.disconnect();
                }
            }
            catch (IOException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public String getId() {
        return this.glideUrl.getCacheKey();
    }
    
    @Override
    public InputStream loadData(final Priority priority) throws Exception {
        return this.loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }
    
    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory
    {
        @Override
        public HttpURLConnection build(final URL url) throws IOException {
            return (HttpURLConnection)url.openConnection();
        }
    }
    
    interface HttpUrlConnectionFactory
    {
        HttpURLConnection build(final URL p0) throws IOException;
    }
}
