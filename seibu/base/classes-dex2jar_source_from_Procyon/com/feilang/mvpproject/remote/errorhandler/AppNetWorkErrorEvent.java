// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import android.support.annotation.NonNull;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;

public class AppNetWorkErrorEvent
{
    public final DataCallWrapper callback;
    public final String errorMessage;
    
    public AppNetWorkErrorEvent(@NonNull final String errorMessage, final DataCallWrapper callback) {
        this.errorMessage = errorMessage;
        this.callback = callback;
    }
}
