package com.google.android.gms.internal.measurement;

public final class zzni implements zznf {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Long> zzb;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzdf.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
