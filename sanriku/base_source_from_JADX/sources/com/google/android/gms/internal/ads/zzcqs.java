package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcqs implements zzegz<zzcqq> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzceo> zzges;

    public zzcqs(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzceo> zzehm3) {
        this.zzenp = zzehm;
        this.zzfjj = zzehm2;
        this.zzges = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzcqq(this.zzenp.get(), this.zzfjj.get(), this.zzges.get());
    }
}
