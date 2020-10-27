package com.google.android.gms.internal.gtm;

public enum zzbm {
    NONE,
    GZIP;

    public static zzbm zzaa(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
