package com.google.android.gms.internal.measurement;

public final class zzgb extends zzga {
    public static int zza(int i, int i2, int i3) {
        if (i2 <= 1073741823) {
            return Math.min(Math.max(i, i2), 1073741823);
        }
        throw new IllegalArgumentException(zzds.zza("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i2), 1073741823));
    }
}
