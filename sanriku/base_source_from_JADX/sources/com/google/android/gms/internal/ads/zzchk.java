package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzchk implements zzegz<zzchj> {
    private final zzehm<zzst> zzfyg;
    private final zzehm<Map<zzdkr, zzchl>> zzfyo;

    private zzchk(zzehm<zzst> zzehm, zzehm<Map<zzdkr, zzchl>> zzehm2) {
        this.zzfyg = zzehm;
        this.zzfyo = zzehm2;
    }

    public static zzchk zzab(zzehm<zzst> zzehm, zzehm<Map<zzdkr, zzchl>> zzehm2) {
        return new zzchk(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzchj(this.zzfyg.get(), this.zzfyo.get());
    }
}
