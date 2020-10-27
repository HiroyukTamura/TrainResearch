package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcjl implements zzegz<zzciz> {
    private final zzehm<zzcfz> zzenj;
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcij> zzeoj;
    private final zzehm<zzazz> zzfib;
    private final zzehm<Executor> zzfjj;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<Context> zzgar;
    private final zzehm<WeakReference<Context>> zzgas;

    public zzcjl(zzehm<Executor> zzehm, zzehm<Context> zzehm2, zzehm<WeakReference<Context>> zzehm3, zzehm<Executor> zzehm4, zzehm<zzcfz> zzehm5, zzehm<ScheduledExecutorService> zzehm6, zzehm<zzcij> zzehm7, zzehm<zzazz> zzehm8) {
        this.zzfjj = zzehm;
        this.zzgar = zzehm2;
        this.zzgas = zzehm3;
        this.zzenm = zzehm4;
        this.zzenj = zzehm5;
        this.zzfvp = zzehm6;
        this.zzeoj = zzehm7;
        this.zzfib = zzehm8;
    }

    public final /* synthetic */ Object get() {
        return new zzciz(this.zzfjj.get(), this.zzgar.get(), this.zzgas.get(), this.zzenm.get(), this.zzenj.get(), this.zzfvp.get(), this.zzeoj.get(), this.zzfib.get());
    }
}
