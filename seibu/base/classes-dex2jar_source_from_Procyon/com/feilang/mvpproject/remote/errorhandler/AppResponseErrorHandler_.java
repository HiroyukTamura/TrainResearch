// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import org.androidannotations.api.UiThreadExecutor;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import com.feilang.mvpproject.data.models.ErrorData;
import android.content.Context;

public final class AppResponseErrorHandler_ extends AppResponseErrorHandler
{
    private Context context_;
    
    private AppResponseErrorHandler_(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    public static AppResponseErrorHandler_ getInstance_(final Context context) {
        return new AppResponseErrorHandler_(context);
    }
    
    private void init_() {
        this.context = this.context_;
    }
    
    public void rebind(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    @Override
    void sendErrorHandlerEvent(final ErrorData errorData, final int n, final DataCallWrapper dataCallWrapper) {
        UiThreadExecutor.runTask("", (Runnable)new Runnable() {
            @Override
            public void run() {
                AppResponseErrorHandler.this.sendErrorHandlerEvent(errorData, n, dataCallWrapper);
            }
        }, 0L);
    }
}
