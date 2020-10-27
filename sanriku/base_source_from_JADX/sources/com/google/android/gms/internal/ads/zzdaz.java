package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdaz implements zzegz<zzday> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzavz> zzeoq;
    private final zzehm<ScheduledExecutorService> zzfvp;

    public zzdaz(zzehm<zzavz> zzehm, zzehm<Context> zzehm2, zzehm<ScheduledExecutorService> zzehm3, zzehm<Executor> zzehm4) {
        this.zzeoq = zzehm;
        this.zzenp = zzehm2;
        this.zzfvp = zzehm3;
        this.zzenm = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzday(this.zzeoq.get(), this.zzenp.get(), this.zzfvp.get(), this.zzenm.get());
    }
}
