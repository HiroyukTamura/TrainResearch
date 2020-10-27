package com.google.android.gms.internal.ads;

public final class zzbol implements zzegz<zzdgo> {
    private final zzboi zzflg;

    private zzbol(zzboi zzboi) {
        this.zzflg = zzboi;
    }

    public static zzbol zzc(zzboi zzboi) {
        return new zzbol(zzboi);
    }

    public static zzdgo zzd(zzboi zzboi) {
        return (zzdgo) zzehf.zza(zzboi.zzaif(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzflg);
    }
}
