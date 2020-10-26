// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.util.Log;
import java.util.concurrent.FutureTask;

final class zzn extends FutureTask<Object>
{
    private /* synthetic */ zzl.zza zzael;
    
    zzn(final zzl.zza zzael, final Runnable runnable, final Object result) {
        this.zzael = zzael;
        super(runnable, result);
    }
    
    @Override
    protected final void setException(final Throwable t) {
        final Thread.UncaughtExceptionHandler zzb = this.zzael.zzaek.zzaei;
        if (zzb != null) {
            zzb.uncaughtException(Thread.currentThread(), t);
        }
        else if (Log.isLoggable("GAv4", 6)) {
            final String value = String.valueOf(t);
            Log.e("GAv4", new StringBuilder(String.valueOf(value).length() + 37).append("MeasurementExecutor: job failed with ").append(value).toString());
        }
        super.setException(t);
    }
}
