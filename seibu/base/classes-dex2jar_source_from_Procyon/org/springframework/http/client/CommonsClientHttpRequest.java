// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.http.client;

import org.apache.commons.httpclient.URIException;
import java.net.URI;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpClient;

@Deprecated
final class CommonsClientHttpRequest extends AbstractBufferingClientHttpRequest
{
    private final HttpClient httpClient;
    private final HttpMethodBase httpMethod;
    
    CommonsClientHttpRequest(final HttpClient httpClient, final HttpMethodBase httpMethod) {
        this.httpClient = httpClient;
        this.httpMethod = httpMethod;
    }
    
    public ClientHttpResponse executeInternal(final HttpHeaders httpHeaders, final byte[] array) throws IOException {
        for (final Map.Entry<String, V> entry : httpHeaders.entrySet()) {
            final String s = entry.getKey();
            final Iterator iterator2 = ((List)entry.getValue()).iterator();
            while (iterator2.hasNext()) {
                this.httpMethod.addRequestHeader(s, (String)iterator2.next());
            }
        }
        if (this.httpMethod instanceof EntityEnclosingMethod) {
            ((EntityEnclosingMethod)this.httpMethod).setRequestEntity((RequestEntity)new ByteArrayRequestEntity(array));
        }
        this.httpClient.executeMethod((HttpMethod)this.httpMethod);
        return (ClientHttpResponse)new CommonsClientHttpResponse((HttpMethod)this.httpMethod);
    }
    
    public org.springframework.http.HttpMethod getMethod() {
        return org.springframework.http.HttpMethod.valueOf(this.httpMethod.getName());
    }
    
    public URI getURI() {
        try {
            return URI.create(this.httpMethod.getURI().getEscapedURI());
        }
        catch (URIException cause) {
            throw new IllegalStateException("Could not get HttpMethod URI: " + cause.getMessage(), (Throwable)cause);
        }
    }
}
