// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.content.Context;
import com.google.android.gms.internal.zzciw;
import android.annotation.TargetApi;
import com.google.android.gms.internal.zzciz;
import android.app.job.JobService;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzciz
{
    private zzciw zzbop;
    
    private final zzciw zzwm() {
        if (this.zzbop == null) {
            this.zzbop = new zzciw(this);
        }
        return this.zzbop;
    }
    
    public final boolean callServiceStopSelfResult(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public final Context getContext() {
        return (Context)this;
    }
    
    @MainThread
    public final void onCreate() {
        super.onCreate();
        this.zzwm().onCreate();
    }
    
    @MainThread
    public final void onDestroy() {
        this.zzwm().onDestroy();
        super.onDestroy();
    }
    
    @MainThread
    public final void onRebind(final Intent intent) {
        this.zzwm().onRebind(intent);
    }
    
    public final boolean onStartJob(final JobParameters jobParameters) {
        return this.zzwm().onStartJob(jobParameters);
    }
    
    public final boolean onStopJob(final JobParameters jobParameters) {
        return false;
    }
    
    @MainThread
    public final boolean onUnbind(final Intent intent) {
        return this.zzwm().onUnbind(intent);
    }
    
    @TargetApi(24)
    public final void zza(final JobParameters jobParameters, final boolean b) {
        this.jobFinished(jobParameters, false);
    }
}
