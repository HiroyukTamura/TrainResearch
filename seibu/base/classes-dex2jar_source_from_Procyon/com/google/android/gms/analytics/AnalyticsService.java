// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.support.annotation.RequiresPermission;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.internal.zzaok;
import com.google.android.gms.internal.zzaon;
import android.app.Service;

public final class AnalyticsService extends Service implements zzaon
{
    private zzaok zzadm;
    
    private final zzaok zzjk() {
        if (this.zzadm == null) {
            this.zzadm = new zzaok(this);
        }
        return this.zzadm;
    }
    
    public final boolean callServiceStopSelfResult(final int n) {
        return this.stopSelfResult(n);
    }
    
    public final Context getContext() {
        return (Context)this;
    }
    
    public final IBinder onBind(final Intent intent) {
        this.zzjk();
        return null;
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final void onCreate() {
        super.onCreate();
        this.zzjk().onCreate();
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final void onDestroy() {
        this.zzjk().onDestroy();
        super.onDestroy();
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final int onStartCommand(final Intent intent, final int n, final int n2) {
        return this.zzjk().onStartCommand(intent, n, n2);
    }
}
