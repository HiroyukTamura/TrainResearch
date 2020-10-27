package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbpu implements zzegz<zzbpv> {
    private final zzehm<zzciz> zzeok;
    private final zzehm<zzawt> zzeqm;
    private final zzehm<zzazz> zzfib;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<Context> zzfmf;

    private zzbpu(zzehm<Context> zzehm, zzehm<zzdhe> zzehm2, zzehm<zzazz> zzehm3, zzehm<zzawt> zzehm4, zzehm<zzciz> zzehm5) {
        this.zzfmf = zzehm;
        this.zzfjq = zzehm2;
        this.zzfib = zzehm3;
        this.zzeqm = zzehm4;
        this.zzeok = zzehm5;
    }

    public static zzbpu zzb(zzehm<Context> zzehm, zzehm<zzdhe> zzehm2, zzehm<zzazz> zzehm3, zzehm<zzawt> zzehm4, zzehm<zzciz> zzehm5) {
        return new zzbpu(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzbpv(this.zzfmf.get(), this.zzfjq.get(), this.zzfib.get(), this.zzeqm.get(), this.zzeok.get());
    }
}
