// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.IntentSender$SendIntentException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import android.app.Activity;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R>
{
    private final Activity mActivity;
    private final int zzaBk;
    
    protected ResolvingResultCallbacks(@NonNull final Activity activity, final int zzaBk) {
        this.mActivity = zzbo.zzb(activity, "Activity must not be null");
        this.zzaBk = zzaBk;
    }
    
    @KeepForSdk
    @Override
    public final void onFailure(@NonNull final Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.mActivity, this.zzaBk);
                return;
            }
            catch (IntentSender$SendIntentException ex) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", (Throwable)ex);
                this.onUnresolvableFailure(new Status(8));
                return;
            }
        }
        this.onUnresolvableFailure(status);
    }
    
    @Override
    public abstract void onSuccess(@NonNull final R p0);
    
    public abstract void onUnresolvableFailure(@NonNull final Status p0);
}
