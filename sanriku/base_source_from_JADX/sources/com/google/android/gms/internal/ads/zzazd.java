package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(17)
public final class zzazd {
    private static zzazd zzdyl;
    String zzdym;

    private zzazd() {
    }

    public static zzazd zzxy() {
        if (zzdyl == null) {
            zzdyl = new zzazd();
        }
        return zzdyl;
    }
}
