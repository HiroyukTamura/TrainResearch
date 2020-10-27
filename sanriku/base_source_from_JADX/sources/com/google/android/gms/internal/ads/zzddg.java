package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzddg implements zzegz<zzdcz> {
    private final zzehm<zzbgy> zzenk;
    private final zzehm<Executor> zzfjj;
    private final zzehm<Context> zzgqo;
    private final zzehm<zzdeu<zzbll, zzblr>> zzgqp;
    private final zzehm<zzddn> zzgqq;
    private final zzehm<zzdhg> zzgqr;

    public zzddg(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzbgy> zzehm3, zzehm<zzdeu<zzbll, zzblr>> zzehm4, zzehm<zzddn> zzehm5, zzehm<zzdhg> zzehm6) {
        this.zzgqo = zzehm;
        this.zzfjj = zzehm2;
        this.zzenk = zzehm3;
        this.zzgqp = zzehm4;
        this.zzgqq = zzehm5;
        this.zzgqr = zzehm6;
    }

    public final /* synthetic */ Object get() {
        return new zzdcz(this.zzgqo.get(), this.zzfjj.get(), this.zzenk.get(), this.zzgqp.get(), this.zzgqq.get(), this.zzgqr.get());
    }
}
