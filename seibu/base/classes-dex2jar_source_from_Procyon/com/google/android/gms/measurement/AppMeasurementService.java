// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.annotation.MainThread;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.internal.zzciw;
import com.google.android.gms.internal.zzciz;
import android.app.Service;

public final class AppMeasurementService extends Service implements zzciz
{
    private zzciw zzbop;
    
    private final zzciw zzwm() {
        if (this.zzbop == null) {
            this.zzbop = new zzciw(this);
        }
        return this.zzbop;
    }
    
    public final boolean callServiceStopSelfResult(final int n) {
        return this.stopSelfResult(n);
    }
    
    public final Context getContext() {
        return (Context)this;
    }
    
    @MainThread
    public final IBinder onBind(final Intent intent) {
        return this.zzwm().onBind(intent);
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
    
    @MainThread
    public final int onStartCommand(final Intent intent, final int n, final int n2) {
        this.zzwm().onStartCommand(intent, n, n2);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        return 2;
    }
    
    @MainThread
    public final boolean onUnbind(final Intent intent) {
        return this.zzwm().onUnbind(intent);
    }
    
    public final void zza(final JobParameters jobParameters, final boolean b) {
        throw new UnsupportedOperationException();
    }
}
