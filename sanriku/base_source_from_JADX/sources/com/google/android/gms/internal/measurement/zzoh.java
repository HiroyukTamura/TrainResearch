package com.google.android.gms.internal.measurement;

public final class zzoh implements zzoi {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Boolean> zzc;
    private static final zzcw<Long> zzd;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.client.global_params.dev", false);
        zzb = zzdf.zza("measurement.service.global_params_in_payload", true);
        zzc = zzdf.zza("measurement.service.global_params", false);
        zzd = zzdf.zza("measurement.id.service.global_params", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }
}
