package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcdd implements zzegz<zzccw> {
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzbky> zzfug;
    private final zzehm<zzbvs> zzfvx;

    public zzcdd(zzehm<Executor> zzehm, zzehm<zzbky> zzehm2, zzehm<zzbvs> zzehm3) {
        this.zzfjj = zzehm;
        this.zzfug = zzehm2;
        this.zzfvx = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzccw(this.zzfjj.get(), this.zzfug.get(), this.zzfvx.get());
    }
}
