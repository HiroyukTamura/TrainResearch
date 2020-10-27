package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzccl implements zzegz<zzcca> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzcbv> zzeug;
    private final zzehm<zzccr> zzeui;
    private final zzehm<zzazz> zzffv;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<zzdt> zzfqu;
    private final zzehm<zza> zzfvn;
    private final zzehm<zzst> zzfvo;
    private final zzehm<ScheduledExecutorService> zzfvp;

    public zzccl(zzehm<Context> zzehm, zzehm<zzcbv> zzehm2, zzehm<zzdt> zzehm3, zzehm<zzazz> zzehm4, zzehm<zza> zzehm5, zzehm<zzst> zzehm6, zzehm<Executor> zzehm7, zzehm<zzdhe> zzehm8, zzehm<zzccr> zzehm9, zzehm<ScheduledExecutorService> zzehm10) {
        this.zzenp = zzehm;
        this.zzeug = zzehm2;
        this.zzfqu = zzehm3;
        this.zzffv = zzehm4;
        this.zzfvn = zzehm5;
        this.zzfvo = zzehm6;
        this.zzenm = zzehm7;
        this.zzfjq = zzehm8;
        this.zzeui = zzehm9;
        this.zzfvp = zzehm10;
    }

    public final /* synthetic */ Object get() {
        return new zzcca(this.zzenp.get(), this.zzeug.get(), this.zzfqu.get(), this.zzffv.get(), this.zzfvn.get(), this.zzfvo.get(), this.zzenm.get(), this.zzfjq.get(), this.zzeui.get(), this.zzfvp.get());
    }
}
