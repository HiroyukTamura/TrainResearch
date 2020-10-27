package com.google.android.gms.internal.ads;

public final class zzdid implements zzegz<zzawt> {
    private final zzdie zzgvr;
    private final zzehm<zzdic> zzgvs;

    private zzdid(zzdie zzdie, zzehm<zzdic> zzehm) {
        this.zzgvr = zzdie;
        this.zzgvs = zzehm;
    }

    public static zzawt zza(zzdie zzdie, zzdic zzdic) {
        return (zzawt) zzehf.zza(zzdic.zzduw, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdid zza(zzdie zzdie, zzehm<zzdic> zzehm) {
        return new zzdid(zzdie, zzehm);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgvr, this.zzgvs.get());
    }
}
