package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbni implements zzegz<zzbnd> {
    private final zzehm<zzbnv> zzeyc;
    private final zzehm<Runnable> zzfcj;
    private final zzehm<zzaem> zzfhv;
    private final zzehm<Executor> zzfjj;

    public zzbni(zzehm<zzbnv> zzehm, zzehm<zzaem> zzehm2, zzehm<Runnable> zzehm3, zzehm<Executor> zzehm4) {
        this.zzeyc = zzehm;
        this.zzfhv = zzehm2;
        this.zzfcj = zzehm3;
        this.zzfjj = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzbnd(this.zzeyc.get(), this.zzfhv.get(), this.zzfcj.get(), this.zzfjj.get());
    }
}
