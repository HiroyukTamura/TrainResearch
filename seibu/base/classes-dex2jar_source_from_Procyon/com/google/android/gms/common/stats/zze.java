// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import android.os.Parcelable;
import android.content.Intent;
import com.google.android.gms.common.util.zzk;
import android.os.SystemClock;
import android.util.Log;
import android.text.TextUtils;
import java.util.List;
import android.content.Context;

public final class zze
{
    private static zze zzaJA;
    private static Boolean zzaJB;
    
    static {
        zze.zzaJA = new zze();
    }
    
    public static void zza(final Context context, final String s, final int n, final String s2, final String s3, final String s4, final int n2, final List<String> list) {
        zza(context, s, 8, s2, s3, s4, n2, list, 0L);
    }
    
    public static void zza(final Context context, final String obj, final int n, final String s, final String s2, final String s3, final int n2, List<String> list, final long n3) {
        if (zze.zzaJB == null) {
            zze.zzaJB = false;
        }
        if (zze.zzaJB) {
            if (TextUtils.isEmpty((CharSequence)obj)) {
                final String value = String.valueOf(obj);
                String concat;
                if (value.length() != 0) {
                    concat = "missing wakeLock key. ".concat(value);
                }
                else {
                    concat = new String("missing wakeLock key. ");
                }
                Log.e("WakeLockTracker", concat);
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (7 == n || 8 == n || 10 == n || 11 == n) {
                if (list != null && list.size() == 1) {
                    List<String> list2 = list;
                    if ("com.google.android.gms".equals(list.get(0))) {
                        list2 = null;
                    }
                    list = list2;
                }
                while (true) {
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    final int zzaK = zzk.zzaK(context);
                    String packageName;
                    if ("com.google.android.gms".equals(packageName = context.getPackageName())) {
                        packageName = null;
                    }
                    final WakeLockEvent wakeLockEvent = new WakeLockEvent(currentTimeMillis, n, s, n2, list, obj, elapsedRealtime, zzaK, s2, packageName, zzk.zzaL(context), n3, s3);
                    try {
                        context.startService(new Intent().setComponent(zzb.zzaJf).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)wakeLockEvent));
                        return;
                    }
                    catch (Exception ex) {
                        Log.wtf("WakeLockTracker", (Throwable)ex);
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    public static zze zzrX() {
        return zze.zzaJA;
    }
}
