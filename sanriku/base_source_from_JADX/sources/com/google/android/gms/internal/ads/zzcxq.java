package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcxq implements zzegz<zzcxm> {
    private final zzehm<zzalc> zzeoq;
    private final zzehm<zzawt> zzeqm;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<ApplicationInfo> zzgbc;

    private zzcxq(zzehm<zzalc> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<zzawt> zzehm3, zzehm<ApplicationInfo> zzehm4, zzehm<zzdhe> zzehm5) {
        this.zzeoq = zzehm;
        this.zzfvp = zzehm2;
        this.zzeqm = zzehm3;
        this.zzgbc = zzehm4;
        this.zzfjq = zzehm5;
    }

    public static zzcxq zzh(zzehm<zzalc> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<zzawt> zzehm3, zzehm<ApplicationInfo> zzehm4, zzehm<zzdhe> zzehm5) {
        return new zzcxq(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzcxm(this.zzeoq.get(), this.zzfvp.get(), this.zzeqm.get(), this.zzgbc.get(), this.zzfjq.get());
    }
}
