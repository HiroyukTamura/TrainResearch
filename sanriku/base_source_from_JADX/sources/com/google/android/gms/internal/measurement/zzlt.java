package com.google.android.gms.internal.measurement;

public final class zzlt implements zzlu {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.androidId.delete_feature", true);
        zzb = zzdf.zza("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
