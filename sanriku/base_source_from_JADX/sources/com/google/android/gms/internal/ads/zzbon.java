package com.google.android.gms.internal.ads;

public final class zzbon implements zzegz<zzdha> {
    private final zzboi zzflg;

    private zzbon(zzboi zzboi) {
        this.zzflg = zzboi;
    }

    public static zzbon zze(zzboi zzboi) {
        return new zzbon(zzboi);
    }

    public static zzdha zzf(zzboi zzboi) {
        return (zzdha) zzehf.zza(zzboi.zzaie(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzf(this.zzflg);
    }
}
