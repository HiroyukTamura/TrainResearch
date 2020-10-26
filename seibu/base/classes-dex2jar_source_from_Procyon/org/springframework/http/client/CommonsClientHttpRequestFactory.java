// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import org.apache.commons.httpclient.methods.TraceMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpMethodBase;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.beans.factory.DisposableBean;

@Deprecated
public class CommonsClientHttpRequestFactory implements ClientHttpRequestFactory, DisposableBean
{
    private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = 60000;
    private HttpClient httpClient;
    
    public CommonsClientHttpRequestFactory() {
        this.httpClient = new HttpClient((HttpConnectionManager)new MultiThreadedHttpConnectionManager());
        this.setReadTimeout(60000);
    }
    
    public CommonsClientHttpRequestFactory(final HttpClient httpClient) {
        Assert.notNull((Object)httpClient, "httpClient must not be null");
        this.httpClient = httpClient;
    }
    
    protected HttpMethodBase createCommonsHttpMethod(final HttpMethod obj, final String s) {
        switch (CommonsClientHttpRequestFactory.CommonsClientHttpRequestFactory$1.$SwitchMap$org$springframework$http$HttpMethod[obj.ordinal()]) {
            default: {
                throw new IllegalArgumentException("Invalid HTTP method: " + obj);
            }
            case 1: {
                return (HttpMethodBase)new GetMethod(s);
            }
            case 2: {
                return (HttpMethodBase)new DeleteMethod(s);
            }
            case 3: {
                return (HttpMethodBase)new HeadMethod(s);
            }
            case 4: {
                return (HttpMethodBase)new OptionsMethod(s);
            }
            case 5: {
                return (HttpMethodBase)new PostMethod(s);
            }
            case 6: {
                return (HttpMethodBase)new PutMethod(s);
            }
            case 7: {
                return (HttpMethodBase)new TraceMethod(s);
            }
        }
    }
    
    public ClientHttpRequest createRequest(final URI uri, final HttpMethod httpMethod) throws IOException {
        final HttpMethodBase commonsHttpMethod = this.createCommonsHttpMethod(httpMethod, uri.toString());
        this.postProcessCommonsHttpMethod(commonsHttpMethod);
        return (ClientHttpRequest)new CommonsClientHttpRequest(this.getHttpClient(), commonsHttpMethod);
    }
    
    public void destroy() {
        final HttpConnectionManager httpConnectionManager = this.getHttpClient().getHttpConnectionManager();
        if (httpConnectionManager instanceof MultiThreadedHttpConnectionManager) {
            ((MultiThreadedHttpConnectionManager)httpConnectionManager).shutdown();
        }
    }
    
    public HttpClient getHttpClient() {
        return this.httpClient;
    }
    
    protected void postProcessCommonsHttpMethod(final HttpMethodBase httpMethodBase) {
    }
    
    public void setConnectTimeout(final int connectionTimeout) {
        Assert.isTrue(connectionTimeout >= 0, "Timeout must be a non-negative value");
        this.httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
    }
    
    public void setHttpClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    public void setReadTimeout(final int soTimeout) {
        Assert.isTrue(soTimeout >= 0, "Timeout must be a non-negative value");
        this.getHttpClient().getHttpConnectionManager().getParams().setSoTimeout(soTimeout);
    }
}
