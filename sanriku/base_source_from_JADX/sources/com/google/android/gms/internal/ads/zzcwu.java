package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcwu implements zzegz<zzcwq> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<ScheduledExecutorService> zzfvp;

    private zzcwu(zzehm<Context> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<Executor> zzehm3) {
        this.zzenp = zzehm;
        this.zzfvp = zzehm2;
        this.zzenm = zzehm3;
    }

    public static zzcwu zzr(zzehm<Context> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<Executor> zzehm3) {
        return new zzcwu(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcwq(this.zzenp.get(), this.zzfvp.get(), this.zzenm.get());
    }
}
