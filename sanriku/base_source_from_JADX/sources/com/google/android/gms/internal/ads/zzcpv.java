package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcpv implements zzegz<zzcps> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzbyp> zzges;

    public zzcpv(zzehm<Context> zzehm, zzehm<zzbyp> zzehm2, zzehm<Executor> zzehm3) {
        this.zzenp = zzehm;
        this.zzges = zzehm2;
        this.zzfjj = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzcps(this.zzenp.get(), this.zzges.get(), this.zzfjj.get());
    }
}
