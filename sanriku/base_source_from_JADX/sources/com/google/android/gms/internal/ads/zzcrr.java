package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrr implements zzegz<zzcrk> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzceo> zzges;

    public zzcrr(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzceo> zzehm3) {
        this.zzenp = zzehm;
        this.zzfjj = zzehm2;
        this.zzges = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzcrk(this.zzenp.get(), this.zzfjj.get(), this.zzges.get());
    }
}
