package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdbq implements zzegz<zzdbm> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzavz> zzeoq;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<zzawd> zzglv;
    private final zzehm<Integer> zzgpm;

    public zzdbq(zzehm<zzavz> zzehm, zzehm<Integer> zzehm2, zzehm<Context> zzehm3, zzehm<zzawd> zzehm4, zzehm<ScheduledExecutorService> zzehm5, zzehm<Executor> zzehm6) {
        this.zzeoq = zzehm;
        this.zzgpm = zzehm2;
        this.zzenp = zzehm3;
        this.zzglv = zzehm4;
        this.zzfvp = zzehm5;
        this.zzenm = zzehm6;
    }

    public final /* synthetic */ Object get() {
        return new zzdbm(this.zzeoq.get(), this.zzgpm.get().intValue(), this.zzenp.get(), this.zzglv.get(), this.zzfvp.get(), this.zzenm.get());
    }
}
