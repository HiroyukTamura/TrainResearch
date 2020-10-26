// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.util.List;
import javax.annotation.Nullable;

public final class Request
{
    @Nullable
    final RequestBody body;
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final Object tag;
    final HttpUrl url;
    
    Request(final Request.Request$Builder request$Builder) {
        this.url = request$Builder.url;
        this.method = request$Builder.method;
        this.headers = request$Builder.headers.build();
        this.body = request$Builder.body;
        Object tag;
        if (request$Builder.tag != null) {
            tag = request$Builder.tag;
        }
        else {
            tag = this;
        }
        this.tag = tag;
    }
    
    @Nullable
    public RequestBody body() {
        return this.body;
    }
    
    public CacheControl cacheControl() {
        final CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        return this.cacheControl = CacheControl.parse(this.headers);
    }
    
    public String header(final String s) {
        return this.headers.get(s);
    }
    
    public List<String> headers(final String s) {
        return this.headers.values(s);
    }
    
    public Headers headers() {
        return this.headers;
    }
    
    public boolean isHttps() {
        return this.url.isHttps();
    }
    
    public String method() {
        return this.method;
    }
    
    public Request.Request$Builder newBuilder() {
        return new Request.Request$Builder(this);
    }
    
    public Object tag() {
        return this.tag;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("Request{method=").append(this.method).append(", url=").append(this.url).append(", tag=");
        Object tag;
        if (this.tag != this) {
            tag = this.tag;
        }
        else {
            tag = null;
        }
        return append.append(tag).append('}').toString();
    }
    
    public HttpUrl url() {
        return this.url;
    }
}
