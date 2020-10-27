package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcax implements zzegz<zzcat> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzawt> zzeqm;
    private final zzehm<zzcab> zzeyi;
    private final zzehm<zzcbb> zzeyj;
    private final zzehm<zzbzs> zzeyl;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<zzbzx> zzfqt;

    private zzcax(zzehm<zzawt> zzehm, zzehm<zzdhe> zzehm2, zzehm<zzcab> zzehm3, zzehm<zzbzx> zzehm4, zzehm<zzcbb> zzehm5, zzehm<Executor> zzehm6, zzehm<Executor> zzehm7, zzehm<zzbzs> zzehm8) {
        this.zzeqm = zzehm;
        this.zzfjq = zzehm2;
        this.zzeyi = zzehm3;
        this.zzfqt = zzehm4;
        this.zzeyj = zzehm5;
        this.zzfjj = zzehm6;
        this.zzenm = zzehm7;
        this.zzeyl = zzehm8;
    }

    public static zzcax zza(zzehm<zzawt> zzehm, zzehm<zzdhe> zzehm2, zzehm<zzcab> zzehm3, zzehm<zzbzx> zzehm4, zzehm<zzcbb> zzehm5, zzehm<Executor> zzehm6, zzehm<Executor> zzehm7, zzehm<zzbzs> zzehm8) {
        return new zzcax(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6, zzehm7, zzehm8);
    }

    public final /* synthetic */ Object get() {
        return new zzcat(this.zzeqm.get(), this.zzfjq.get(), this.zzeyi.get(), this.zzfqt.get(), this.zzeyj.get(), this.zzfjj.get(), this.zzenm.get(), this.zzeyl.get());
    }
}
