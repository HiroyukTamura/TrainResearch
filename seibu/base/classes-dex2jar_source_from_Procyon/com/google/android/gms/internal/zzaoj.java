// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.RequiresPermission;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;

public final class zzaoj
{
    static zzctz zzads;
    private static Boolean zzadt;
    static Object zzuF;
    
    static {
        zzaoj.zzuF = new Object();
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public static void onReceive(final Context context, final Intent intent) {
        final zzaoc zzkr = zzamj.zzaf(context).zzkr();
        if (intent == null) {
            zzkr.zzbr("AnalyticsReceiver called with null intent");
        }
        else {
            final String action = intent.getAction();
            zzkr.zza("Local AnalyticsReceiver got", action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                final boolean zzad = zzaok.zzad(context);
                final Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
                intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                synchronized (zzaoj.zzuF) {
                    context.startService(intent2);
                    if (!zzad) {
                        return;
                    }
                }
                while (true) {
                    try {
                        if (zzaoj.zzads == null) {
                            final Context context2;
                            (zzaoj.zzads = new zzctz(context2, 1, "Analytics WakeLock")).setReferenceCounted(false);
                        }
                        zzaoj.zzads.acquire(1000L);
                    }
                    // monitorexit(intent)
                    catch (SecurityException ex) {
                        zzkr.zzbr("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public static boolean zzac(final Context context) {
        zzbo.zzu(context);
        if (zzaoj.zzadt != null) {
            return zzaoj.zzadt;
        }
        final boolean zza = zzaos.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzaoj.zzadt = zza;
        return zza;
    }
}
