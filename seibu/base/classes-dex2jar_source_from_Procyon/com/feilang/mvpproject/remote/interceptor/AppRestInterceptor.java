// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import com.feilang.mvpproject.remote.TaskHelper;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import java.io.InputStream;
import java.io.IOException;
import org.springframework.util.FileCopyUtils;
import com.feilang.mvpproject.util.LogUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestInterceptor;

public class AppRestInterceptor implements ClientHttpRequestInterceptor
{
    public ClientHttpResponse intercept(final HttpRequest httpRequest, final byte[] bytes, final ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        LogUtils.outputLog("REQUEST: URI: " + httpRequest.getURI() + "\n\tHEADERS: " + httpRequest.getHeaders() + "\n\tBODY: " + new String(bytes, "UTF-8"));
        final ClientHttpResponse execute = clientHttpRequestExecution.execute(httpRequest, bytes);
        final InfoClientHttpResponse infoClientHttpResponse = new InfoClientHttpResponse(execute, httpRequest);
        infoClientHttpResponse.getCallback().setHttpStatus(execute.getStatusCode());
        LogUtils.outputLog("RESPONSE: URI: " + httpRequest.getURI() + "\n\tSTATUS: " + execute.getRawStatusCode() + "\n\tHEADERS: " + execute.getHeaders() + "\n\tBODY: " + new String(FileCopyUtils.copyToByteArray(execute.getBody())));
        return (ClientHttpResponse)infoClientHttpResponse;
    }
    
    public static class InfoClientHttpResponse implements ClientHttpResponse
    {
        private HttpRequest mRequest;
        private ClientHttpResponse mResponse;
        
        public InfoClientHttpResponse(final ClientHttpResponse mResponse, final HttpRequest mRequest) {
            this.mResponse = mResponse;
            this.mRequest = mRequest;
        }
        
        public void close() {
            this.mResponse.close();
        }
        
        public InputStream getBody() throws IOException {
            return this.mResponse.getBody();
        }
        
        public DataCallWrapper getCallback() {
            return TaskHelper.excludeCallback();
        }
        
        public HttpHeaders getHeaders() {
            return this.mResponse.getHeaders();
        }
        
        public int getRawStatusCode() throws IOException {
            return this.mResponse.getRawStatusCode();
        }
        
        public HttpStatus getStatusCode() throws IOException {
            return this.mResponse.getStatusCode();
        }
        
        public String getStatusText() throws IOException {
            return this.mResponse.getStatusText();
        }
    }
}
