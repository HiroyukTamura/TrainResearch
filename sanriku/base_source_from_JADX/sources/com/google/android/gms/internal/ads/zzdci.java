package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdci implements zzegz<zzdcg> {
    private final zzehm<zzalc> zzeoq;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<ApplicationInfo> zzgbc;
    private final zzehm<Boolean> zzgpx;

    public zzdci(zzehm<zzalc> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<Boolean> zzehm3, zzehm<ApplicationInfo> zzehm4) {
        this.zzeoq = zzehm;
        this.zzfvp = zzehm2;
        this.zzgpx = zzehm3;
        this.zzgbc = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzdcg(this.zzeoq.get(), this.zzfvp.get(), this.zzgpx.get().booleanValue(), this.zzgbc.get());
    }
}
