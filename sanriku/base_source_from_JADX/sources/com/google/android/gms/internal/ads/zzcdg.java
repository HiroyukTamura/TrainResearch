package com.google.android.gms.internal.ads;

public final class zzcdg implements zzegz<zzcdf> {
    private final zzehm<zzbzx> zzfqt;
    private final zzehm<zzbzm> zzfwa;

    private zzcdg(zzehm<zzbzm> zzehm, zzehm<zzbzx> zzehm2) {
        this.zzfwa = zzehm;
        this.zzfqt = zzehm2;
    }

    public static zzcdg zzs(zzehm<zzbzm> zzehm, zzehm<zzbzx> zzehm2) {
        return new zzcdg(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcdf(this.zzfwa.get(), this.zzfqt.get());
    }
}
