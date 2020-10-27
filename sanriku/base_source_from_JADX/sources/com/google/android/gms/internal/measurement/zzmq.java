package com.google.android.gms.internal.measurement;

public final class zzmq implements zzmn {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Boolean> zzc;
    private static final zzcw<Boolean> zzd;
    private static final zzcw<Boolean> zze;
    private static final zzcw<Boolean> zzf;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.gold.enhanced_ecommerce.format_logs", true);
        zzb = zzdf.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        zzc = zzdf.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", true);
        zzd = zzdf.zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        zze = zzdf.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", true);
        zzf = zzdf.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", true);
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

    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zze.zzc().booleanValue();
    }

    public final boolean zzg() {
        return zzf.zzc().booleanValue();
    }
}
