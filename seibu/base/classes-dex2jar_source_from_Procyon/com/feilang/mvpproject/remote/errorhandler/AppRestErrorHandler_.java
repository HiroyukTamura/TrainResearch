// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import org.androidannotations.api.UiThreadExecutor;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import android.content.Context;

public final class AppRestErrorHandler_ extends AppRestErrorHandler
{
    private Context context_;
    
    private AppRestErrorHandler_(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    public static AppRestErrorHandler_ getInstance_(final Context context) {
        return new AppRestErrorHandler_(context);
    }
    
    private void init_() {
    }
    
    public void rebind(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    @Override
    void sendErrorHandlerEvent(final String s, final DataCallWrapper dataCallWrapper) {
        UiThreadExecutor.runTask("", (Runnable)new Runnable() {
            @Override
            public void run() {
                AppRestErrorHandler.this.sendErrorHandlerEvent(s, dataCallWrapper);
            }
        }, 0L);
    }
}
