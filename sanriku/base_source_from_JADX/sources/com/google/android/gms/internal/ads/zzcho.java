package com.google.android.gms.internal.ads;

public final class zzcho implements zzegz<zzchp> {
    private final zzehm<zzcie> zzeoi;
    private final zzehm<zzchx> zzeqp;

    private zzcho(zzehm<zzchx> zzehm, zzehm<zzcie> zzehm2) {
        this.zzeqp = zzehm;
        this.zzeoi = zzehm2;
    }

    public static zzcho zzac(zzehm<zzchx> zzehm, zzehm<zzcie> zzehm2) {
        return new zzcho(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzchp(this.zzeqp.get(), this.zzeoi.get());
    }
}
