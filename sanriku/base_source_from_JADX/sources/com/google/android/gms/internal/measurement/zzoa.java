package com.google.android.gms.internal.measurement;

public final class zzoa implements zznx {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Long> zzc;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzdf.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzdf.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }
}
