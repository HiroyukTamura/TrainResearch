// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.support.annotation.MainThread;
import android.os.IBinder;
import android.content.Intent;
import android.os.Build$VERSION;
import android.app.job.JobParameters;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;

public final class zzciw
{
    private final Context mContext;
    private final zzciz zzbum;
    
    public zzciw(final zzciz zzbum) {
        zzbo.zzu(this.mContext = zzbum.getContext());
        this.zzbum = zzbum;
    }
    
    private final void zza(final Integer n, final JobParameters jobParameters) {
        final zzcgl zzbj = zzcgl.zzbj(this.mContext);
        zzbj.zzwE().zzj(new zzcix(this, zzbj, n, zzbj.zzwF(), jobParameters));
    }
    
    public static boolean zzk(final Context context, final boolean b) {
        zzbo.zzu(context);
        if (Build$VERSION.SDK_INT >= 24) {
            return zzcjl.zzw(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzcjl.zzw(context, "com.google.android.gms.measurement.AppMeasurementService");
    }
    
    private final zzcfl zzwF() {
        return zzcgl.zzbj(this.mContext).zzwF();
    }
    
    @MainThread
    public final IBinder onBind(final Intent intent) {
        if (intent == null) {
            this.zzwF().zzyx().log("onBind called with null intent");
            return null;
        }
        final String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return (IBinder)new zzcgq(zzcgl.zzbj(this.mContext));
        }
        this.zzwF().zzyz().zzj("onBind received unknown action", action);
        return null;
    }
    
    @MainThread
    public final void onCreate() {
        final zzcfl zzwF = zzcgl.zzbj(this.mContext).zzwF();
        zzcem.zzxE();
        zzwF.zzyD().log("Local AppMeasurementService is starting up");
    }
    
    @MainThread
    public final void onDestroy() {
        final zzcfl zzwF = zzcgl.zzbj(this.mContext).zzwF();
        zzcem.zzxE();
        zzwF.zzyD().log("Local AppMeasurementService is shutting down");
    }
    
    @MainThread
    public final void onRebind(final Intent intent) {
        if (intent == null) {
            this.zzwF().zzyx().log("onRebind called with null intent");
            return;
        }
        this.zzwF().zzyD().zzj("onRebind called. action", intent.getAction());
    }
    
    @MainThread
    public final int onStartCommand(final Intent intent, final int n, final int n2) {
        final zzcfl zzwF = zzcgl.zzbj(this.mContext).zzwF();
        if (intent == null) {
            zzwF.zzyz().log("AppMeasurementService started with null intent");
        }
        else {
            final String action = intent.getAction();
            zzcem.zzxE();
            zzwF.zzyD().zze("Local AppMeasurementService called. startId, action", n2, action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                this.zza(n2, null);
                return 2;
            }
        }
        return 2;
    }
    
    @TargetApi(24)
    @MainThread
    public final boolean onStartJob(final JobParameters jobParameters) {
        final zzcfl zzwF = zzcgl.zzbj(this.mContext).zzwF();
        final String string = jobParameters.getExtras().getString("action");
        zzcem.zzxE();
        zzwF.zzyD().zzj("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            this.zza(null, jobParameters);
        }
        return true;
    }
    
    @MainThread
    public final boolean onUnbind(final Intent intent) {
        if (intent == null) {
            this.zzwF().zzyx().log("onUnbind called with null intent");
            return true;
        }
        this.zzwF().zzyD().zzj("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
