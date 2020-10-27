package com.google.android.gms.internal.ads;

public final class zzcyj implements zzegz<zzcyh> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<zzdgm> zzgfg;

    private zzcyj(zzehm<zzdrh> zzehm, zzehm<zzdgm> zzehm2) {
        this.zzenm = zzehm;
        this.zzgfg = zzehm2;
    }

    public static zzcyj zzaw(zzehm<zzdrh> zzehm, zzehm<zzdgm> zzehm2) {
        return new zzcyj(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcyh(this.zzenm.get(), this.zzgfg.get());
    }
}
