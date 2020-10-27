package com.google.android.gms.internal.measurement;

public final class zzml implements zzmm {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Boolean> zzc;
    private static final zzcw<Long> zzd;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.dynamite.allow_remote_dynamite2", false);
        zzb = zzdf.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzdf.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzdf.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
