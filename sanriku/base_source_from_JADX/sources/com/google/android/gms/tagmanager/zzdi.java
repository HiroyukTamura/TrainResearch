package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
public final class zzdi {
    @VisibleForTesting
    private static zzdj zzaib = new zzba();
    static int zzyr;

    public static void setLogLevel(int i) {
        zzyr = i;
        zzaib.setLogLevel(i);
    }

    public static void zza(String str, Throwable th) {
        zzaib.zza(str, th);
    }

    public static void zzab(String str) {
        zzaib.zzab(str);
    }

    public static void zzac(String str) {
        zzaib.zzac(str);
    }

    public static void zzav(String str) {
        zzaib.zzav(str);
    }

    public static void zzaw(String str) {
        zzaib.zzaw(str);
    }

    public static void zzax(String str) {
        zzaib.zzax(str);
    }

    public static void zzb(String str, Throwable th) {
        zzaib.zzb(str, th);
    }
}
