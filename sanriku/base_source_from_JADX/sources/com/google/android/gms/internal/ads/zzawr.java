package com.google.android.gms.internal.ads;

import android.util.Log;

public final class zzawr extends zzazw {
    public static void zza(String str, Throwable th) {
        if (zzwo()) {
            Log.v("Ads", str, th);
        }
    }

    public static void zzeg(String str) {
        if (zzwo()) {
            Log.v("Ads", str);
        }
    }

    public static boolean zzwo() {
        return zzazw.isLoggable(2) && zzabn.zzcxb.get().booleanValue();
    }
}
