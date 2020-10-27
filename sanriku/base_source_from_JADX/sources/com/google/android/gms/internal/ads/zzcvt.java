package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcvt implements zzegz<zzcvr> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzcxg<zzdan>> zzeoz;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<zzawd> zzglv;

    private zzcvt(zzehm<zzcxg<zzdan>> zzehm, zzehm<zzdhe> zzehm2, zzehm<Context> zzehm3, zzehm<zzawd> zzehm4) {
        this.zzeoz = zzehm;
        this.zzfjq = zzehm2;
        this.zzenp = zzehm3;
        this.zzglv = zzehm4;
    }

    public static zzcvt zze(zzehm<zzcxg<zzdan>> zzehm, zzehm<zzdhe> zzehm2, zzehm<Context> zzehm3, zzehm<zzawd> zzehm4) {
        return new zzcvt(zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        return new zzcvr(this.zzeoz.get(), this.zzfjq.get(), this.zzenp.get(), this.zzglv.get());
    }
}
