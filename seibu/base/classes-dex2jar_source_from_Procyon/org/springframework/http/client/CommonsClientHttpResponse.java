// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.http.client;

import org.apache.commons.httpclient.Header;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpMethod;
import org.springframework.http.HttpHeaders;

@Deprecated
final class CommonsClientHttpResponse extends AbstractClientHttpResponse
{
    private HttpHeaders headers;
    private final HttpMethod httpMethod;
    
    CommonsClientHttpResponse(final HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }
    
    protected void closeInternal() {
        this.httpMethod.releaseConnection();
    }
    
    protected InputStream getBodyInternal() throws IOException {
        return this.httpMethod.getResponseBodyAsStream();
    }
    
    public HttpHeaders getHeaders() {
        if (this.headers == null) {
            this.headers = new HttpHeaders();
            final Header[] responseHeaders = this.httpMethod.getResponseHeaders();
            for (int length = responseHeaders.length, i = 0; i < length; ++i) {
                final Header header = responseHeaders[i];
                this.headers.add(header.getName(), header.getValue());
            }
        }
        return this.headers;
    }
    
    public int getRawStatusCode() {
        return this.httpMethod.getStatusCode();
    }
    
    public String getStatusText() {
        return this.httpMethod.getStatusText();
    }
}
