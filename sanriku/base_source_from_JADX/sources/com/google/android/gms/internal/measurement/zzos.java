package com.google.android.gms.internal.measurement;

public final class zzos implements zzop {
    private static final zzcw<Long> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Boolean> zzc;
    private static final zzcw<Boolean> zzd;
    private static final zzcw<Long> zze;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzdf.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzdf.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzdf.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzdf.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }
}
