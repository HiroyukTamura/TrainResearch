package com.google.android.gms.internal.ads;

public final class zzbnm implements zzegz<zzbnn> {
    private final zzehm<zzdgo> zzfgv;
    private final zzehm<zzbro> zzfkg;
    private final zzehm<zzbsq> zzfkh;

    private zzbnm(zzehm<zzdgo> zzehm, zzehm<zzbro> zzehm2, zzehm<zzbsq> zzehm3) {
        this.zzfgv = zzehm;
        this.zzfkg = zzehm2;
        this.zzfkh = zzehm3;
    }

    public static zzbnm zzf(zzehm<zzdgo> zzehm, zzehm<zzbro> zzehm2, zzehm<zzbsq> zzehm3) {
        return new zzbnm(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzbnn(this.zzfgv.get(), this.zzfkg.get(), this.zzfkh.get());
    }
}
