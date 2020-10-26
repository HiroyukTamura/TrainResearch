// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import android.support.annotation.NonNull;
import com.feilang.mvpproject.data.models.ErrorData;
import android.content.DialogInterface$OnClickListener;

public class AppRestErrorEvent
{
    public final DialogInterface$OnClickListener callback;
    public final int errorCode;
    public final ErrorData errorMessage;
    
    public AppRestErrorEvent(@NonNull final ErrorData errorMessage, @NonNull final int errorCode, final DialogInterface$OnClickListener callback) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.callback = callback;
    }
}
