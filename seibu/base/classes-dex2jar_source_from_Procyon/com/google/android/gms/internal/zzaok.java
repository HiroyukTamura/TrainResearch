// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzbo;
import android.os.Handler;
import android.content.Context;

public final class zzaok
{
    private static Boolean zzadu;
    private final Context mContext;
    private final Handler mHandler;
    private final zzaon zzaiD;
    
    public zzaok(final zzaon zzaiD) {
        zzbo.zzu(this.mContext = zzaiD.getContext());
        this.zzaiD = zzaiD;
        this.mHandler = new Handler();
    }
    
    public static boolean zzad(final Context context) {
        zzbo.zzu(context);
        if (zzaok.zzadu != null) {
            return zzaok.zzadu;
        }
        final boolean zzw = zzaos.zzw(context, "com.google.android.gms.analytics.AnalyticsService");
        zzaok.zzadu = zzw;
        return zzw;
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final void onCreate() {
        zzamj.zzaf(this.mContext).zzkr().zzbo("Local AnalyticsService is starting up");
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final void onDestroy() {
        zzamj.zzaf(this.mContext).zzkr().zzbo("Local AnalyticsService is shutting down");
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final int onStartCommand(Intent action, final int n, final int i) {
        Object o;
        final zzaoc zzaoc;
        while (true) {
            while (true) {
                try {
                    o = zzaoj.zzuF;
                    synchronized (o) {
                        final zzctz zzads = zzaoj.zzads;
                        if (zzads != null && zzads.isHeld()) {
                            zzads.release();
                        }
                        // monitorexit(o)
                        o = zzamj.zzaf(this.mContext);
                        final zzaoc zzkr = ((zzamj)o).zzkr();
                        if (action == null) {
                            zzkr.zzbr("AnalyticsService started with null intent");
                            return 2;
                        }
                    }
                }
                catch (SecurityException o) {
                    continue;
                }
                break;
            }
            action = (Intent)action.getAction();
            zzaoc.zza("Local AnalyticsService called. startId, action", i, action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                break;
            }
            return 2;
        }
        ((zzamj)o).zzkv().zza(new zzaol(this, i, (zzamj)o, zzaoc));
        return 2;
    }
}
