// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.os.SystemClock;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.PowerManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public final class zzk
{
    private static IntentFilter zzaJO;
    private static long zzaJP;
    private static float zzaJQ;
    
    static {
        zzk.zzaJO = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        zzk.zzaJQ = Float.NaN;
    }
    
    @TargetApi(20)
    public static int zzaK(final Context context) {
        final int n = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        final Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver)null, zzk.zzaJO);
        int intExtra;
        if (registerReceiver == null) {
            intExtra = 0;
        }
        else {
            intExtra = registerReceiver.getIntExtra("plugged", 0);
        }
        final boolean b = (intExtra & 0x7) != 0x0;
        final PowerManager powerManager = (PowerManager)context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        boolean b2;
        if (zzq.zzsd()) {
            b2 = powerManager.isInteractive();
        }
        else {
            b2 = powerManager.isScreenOn();
        }
        int n2;
        if (b2) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        int n3;
        if (b) {
            n3 = n;
        }
        else {
            n3 = 0;
        }
        return n2 << 1 | n3;
    }
    
    public static float zzaL(final Context context) {
        synchronized (zzk.class) {
            float n;
            if (SystemClock.elapsedRealtime() - zzk.zzaJP < 60000L && !Float.isNaN(zzk.zzaJQ)) {
                n = zzk.zzaJQ;
            }
            else {
                final Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver)null, zzk.zzaJO);
                if (registerReceiver != null) {
                    zzk.zzaJQ = registerReceiver.getIntExtra("level", -1) / (float)registerReceiver.getIntExtra("scale", -1);
                }
                zzk.zzaJP = SystemClock.elapsedRealtime();
                n = zzk.zzaJQ;
            }
            return n;
        }
    }
}
