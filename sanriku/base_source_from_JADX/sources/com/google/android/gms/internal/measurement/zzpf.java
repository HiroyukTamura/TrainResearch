package com.google.android.gms.internal.measurement;

public final class zzpf implements zzpg {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Double> zzb;
    private static final zzcw<Long> zzc;
    private static final zzcw<Long> zzd;
    private static final zzcw<String> zze;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.test.boolean_flag", false);
        zzb = zzdf.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdf.zza("measurement.test.int_flag", -2);
        zzd = zzdf.zza("measurement.test.long_flag", -1);
        zze = zzdf.zza("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    public final long zzc() {
        return zzc.zzc().longValue();
    }

    public final long zzd() {
        return zzd.zzc().longValue();
    }

    public final String zze() {
        return zze.zzc();
    }
}
