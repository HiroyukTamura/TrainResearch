package com.google.android.gms.internal.ads;

public final class zzcqn implements zzegz<zzcqk> {
    private final zzehm<zzcfu> zzeny;
    private final zzehm<zzdhm> zzeph;
    private final zzehm<zzchz> zzepi;

    private zzcqn(zzehm<zzdhm> zzehm, zzehm<zzcfu> zzehm2, zzehm<zzchz> zzehm3) {
        this.zzeph = zzehm;
        this.zzeny = zzehm2;
        this.zzepi = zzehm3;
    }

    public static zzcqn zzp(zzehm<zzdhm> zzehm, zzehm<zzcfu> zzehm2, zzehm<zzchz> zzehm3) {
        return new zzcqn(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcqk(this.zzeph.get(), this.zzeny.get(), this.zzepi.get());
    }
}
