package com.google.android.gms.internal.measurement;

public final class zzon implements zzoo {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Boolean> zzc;
    private static final zzcw<Boolean> zzd;
    private static final zzcw<Long> zze;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzdf.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzdf.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzdf.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzdf.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }
}
