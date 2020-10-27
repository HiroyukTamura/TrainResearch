package com.google.android.gms.internal.measurement;

public final class zzot implements zzou {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzdf.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
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
}
