// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import android.util.Log;
import android.support.annotation.NonNull;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R>
{
    public abstract void onFailure(@NonNull final Status p0);
    
    @KeepForSdk
    @Override
    public final void onResult(@NonNull final R obj) {
        final Status status = obj.getStatus();
        if (status.isSuccess()) {
            this.onSuccess(obj);
        }
        else {
            this.onFailure(status);
            if (obj instanceof Releasable) {
                try {
                    ((Releasable)obj).release();
                }
                catch (RuntimeException ex) {
                    final String value = String.valueOf(obj);
                    Log.w("ResultCallbacks", new StringBuilder(String.valueOf(value).length() + 18).append("Unable to release ").append(value).toString(), (Throwable)ex);
                }
            }
        }
    }
    
    public abstract void onSuccess(@NonNull final R p0);
}
