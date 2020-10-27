package com.google.android.gms.internal.ads;

public final class zzbyc implements zzegz<zzbyd> {
    private final zzehm<zzbro> zzfpg;
    private final zzehm<zzdgo> zzfph;

    private zzbyc(zzehm<zzbro> zzehm, zzehm<zzdgo> zzehm2) {
        this.zzfpg = zzehm;
        this.zzfph = zzehm2;
    }

    public static zzbyc zzq(zzehm<zzbro> zzehm, zzehm<zzdgo> zzehm2) {
        return new zzbyc(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbyd(this.zzfpg.get(), this.zzfph.get());
    }
}
