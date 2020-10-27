package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AdValue {
    private final int zzacj;
    private final String zzack;
    private final long zzacl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    private AdValue(int i, String str, long j) {
        this.zzacj = i;
        this.zzack = str;
        this.zzacl = j;
    }

    public static AdValue zza(int i, String str, long j) {
        return new AdValue(i, str, j);
    }

    public final String getCurrencyCode() {
        return this.zzack;
    }

    public final int getPrecisionType() {
        return this.zzacj;
    }

    public final long getValueMicros() {
        return this.zzacl;
    }
}
