package com.google.android.gms.internal.measurement;

public final class zzpr implements zzps {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Long> zzb;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.service.ssaid_removal", true);
        zzb = zzdf.zza("measurement.id.ssaid_removal", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
