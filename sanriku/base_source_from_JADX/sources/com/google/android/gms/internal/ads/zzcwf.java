package com.google.android.gms.internal.ads;

public final class zzcwf implements zzegz<zzcwd> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<zzdhe> zzfjq;

    private zzcwf(zzehm<zzdrh> zzehm, zzehm<zzdhe> zzehm2) {
        this.zzenm = zzehm;
        this.zzfjq = zzehm2;
    }

    public static zzcwf zzar(zzehm<zzdrh> zzehm, zzehm<zzdhe> zzehm2) {
        return new zzcwf(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcwd(this.zzenm.get(), this.zzfjq.get());
    }
}
