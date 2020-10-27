package com.google.android.gms.internal.ads;

public final class zzcdi implements zzegz<zzcdj> {
    private final zzehm<String> zzfmz;
    private final zzehm<zzbzx> zzfqt;
    private final zzehm<zzbzm> zzfwa;

    private zzcdi(zzehm<String> zzehm, zzehm<zzbzm> zzehm2, zzehm<zzbzx> zzehm3) {
        this.zzfmz = zzehm;
        this.zzfwa = zzehm2;
        this.zzfqt = zzehm3;
    }

    public static zzcdi zzk(zzehm<String> zzehm, zzehm<zzbzm> zzehm2, zzehm<zzbzx> zzehm3) {
        return new zzcdi(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcdj(this.zzfmz.get(), this.zzfwa.get(), this.zzfqt.get());
    }
}
