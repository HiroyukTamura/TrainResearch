package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdcm implements zzegz<zzdck> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzapo> zzeoq;
    private final zzehm<ScheduledExecutorService> zzfvp;

    public zzdcm(zzehm<zzapo> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<Context> zzehm3) {
        this.zzeoq = zzehm;
        this.zzfvp = zzehm2;
        this.zzenp = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzdck(this.zzeoq.get(), this.zzfvp.get(), this.zzenp.get());
    }
}
