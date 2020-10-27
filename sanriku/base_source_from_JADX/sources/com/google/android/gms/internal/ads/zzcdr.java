package com.google.android.gms.internal.ads;

public final class zzcdr implements zzegz<zzcdo> {
    private final zzehm<String> zzfmz;
    private final zzehm<zzbzx> zzfqt;
    private final zzehm<zzbzm> zzfwa;

    private zzcdr(zzehm<String> zzehm, zzehm<zzbzm> zzehm2, zzehm<zzbzx> zzehm3) {
        this.zzfmz = zzehm;
        this.zzfwa = zzehm2;
        this.zzfqt = zzehm3;
    }

    public static zzcdr zzm(zzehm<String> zzehm, zzehm<zzbzm> zzehm2, zzehm<zzbzx> zzehm3) {
        return new zzcdr(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcdo(this.zzfmz.get(), this.zzfwa.get(), this.zzfqt.get());
    }
}
