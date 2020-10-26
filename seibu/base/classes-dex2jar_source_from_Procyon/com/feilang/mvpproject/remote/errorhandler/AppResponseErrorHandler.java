// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import org.androidannotations.annotations.UiThread;
import com.feilang.mvpproject.data.datasource.DataNotifyEventBus;
import com.feilang.mvpproject.util.ApiEventDispatchUtils;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import java.io.IOException;
import com.feilang.mvpproject.remote.interceptor.AppRestInterceptor;
import com.google.gson.Gson;
import com.feilang.mvpproject.data.models.ErrorData;
import com.feilang.mvpproject.util.LogUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import org.androidannotations.annotations.EBean;
import org.springframework.web.client.ResponseErrorHandler;

@EBean
public class AppResponseErrorHandler implements ResponseErrorHandler
{
    public DataCallWrapper callback;
    @RootContext
    Context context;
    
    public void handleError(final ClientHttpResponse clientHttpResponse) throws IOException {
        final String s = new String(FileCopyUtils.copyToByteArray(clientHttpResponse.getBody()));
        ErrorData errorData = null;
        ErrorData errorData2 = null;
        try {
            if (clientHttpResponse.getStatusCode().value() >= HttpStatus.BAD_REQUEST.value()) {
                LogUtils.outputLog("response error. http status code = " + clientHttpResponse.getStatusCode().value());
                errorData2 = new Gson().fromJson(s, ErrorData.class);
            }
            if ((errorData = errorData2) == null) {
                errorData = new ErrorData("E0001", s);
            }
            DataCallWrapper callback = null;
            if (clientHttpResponse instanceof AppRestInterceptor.InfoClientHttpResponse) {
                callback = ((AppRestInterceptor.InfoClientHttpResponse)clientHttpResponse).getCallback();
            }
            if (callback != null) {
                errorData.setTag(callback.tag);
            }
            this.sendErrorHandlerEvent(errorData, clientHttpResponse.getStatusCode().value(), callback);
            throw new IOException("business error");
        }
        finally {
            ErrorData errorData3 = errorData;
            if (!false) {
                errorData3 = new ErrorData("E0001", s);
            }
            DataCallWrapper callback2 = null;
            if (clientHttpResponse instanceof AppRestInterceptor.InfoClientHttpResponse) {
                callback2 = ((AppRestInterceptor.InfoClientHttpResponse)clientHttpResponse).getCallback();
            }
            if (callback2 != null) {
                errorData3.setTag(callback2.tag);
            }
            this.sendErrorHandlerEvent(errorData3, clientHttpResponse.getStatusCode().value(), callback2);
            throw new IOException("business error");
        }
    }
    
    public boolean hasError(final ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().value() >= HttpStatus.BAD_REQUEST.value();
    }
    
    @UiThread
    void sendErrorHandlerEvent(final ErrorData errorData, final int n, final DataCallWrapper dataCallWrapper) {
        if (dataCallWrapper == null) {
            return;
        }
        if (dataCallWrapper.ignoreError) {
            ApiEventDispatchUtils.dispatchFailedEvent(dataCallWrapper.getCaller(), new DataNotifyEvent(dataCallWrapper.identifier, new Object[] { errorData }));
            return;
        }
        DataNotifyEventBus.getInstance().post(new DataNotifyEvent(dataCallWrapper.getCaller(), dataCallWrapper.identifier, errorData));
    }
}
