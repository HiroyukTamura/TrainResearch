// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import org.androidannotations.annotations.UiThread;
import com.feilang.mvpproject.util.AppEventBus;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import com.feilang.mvpproject.util.LogUtils;
import java.net.ConnectException;
import android.text.TextUtils;
import org.springframework.core.NestedRuntimeException;
import com.feilang.mvpproject.remote.TaskHelper;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.api.RestErrorHandler;

@EBean
public class AppRestErrorHandler implements RestErrorHandler
{
    protected DataCallWrapper getCallWarpper() {
        return TaskHelper.excludeCallback();
    }
    
    public void onRestClientExceptionThrown(final NestedRuntimeException ex) {
        DataCallWrapper callWarpper = null;
        if (ex instanceof TaskHelper.CallbackRestTemplate.URLRestClientException) {
            callWarpper = this.getCallWarpper();
        }
        Object cause;
        if ((cause = ex.getCause()) == null) {
            cause = ex;
        }
        if (!TextUtils.isEmpty((CharSequence)((Throwable)cause).getMessage()) && ((Throwable)cause).getMessage().equals("business error")) {
            return;
        }
        if (cause instanceof ConnectException) {
            LogUtils.outputLog(6, "network not reachable.");
            this.sendErrorHandlerEvent(((Throwable)cause).getMessage(), callWarpper);
            return;
        }
        if (cause instanceof SSLHandshakeException) {
            LogUtils.outputLog(6, "SSL connect error.", (Exception)ex);
            this.sendErrorHandlerEvent(((Throwable)cause).getMessage(), callWarpper);
            return;
        }
        if (cause instanceof UnknownHostException) {
            LogUtils.outputLog(6, "Unknown host error.", (Exception)ex);
            this.sendErrorHandlerEvent(((Throwable)cause).getMessage(), callWarpper);
            return;
        }
        LogUtils.outputLog(6, "Unknown connect error.", (Exception)ex);
        String s;
        if ((s = ((Throwable)cause).getMessage()) == null) {
            s = ex.getMessage();
        }
        this.sendErrorHandlerEvent(s, callWarpper);
    }
    
    @UiThread
    void sendErrorHandlerEvent(final String s, final DataCallWrapper dataCallWrapper) {
        AppEventBus.getInstance().post(new AppNetWorkErrorEvent(s, dataCallWrapper));
    }
}
