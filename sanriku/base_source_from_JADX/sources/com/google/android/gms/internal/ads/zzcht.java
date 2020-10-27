package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcht implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzchp> zzfhv;

    private zzcht(zzehm<zzchp> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcht zzag(zzehm<zzchp> zzehm, zzehm<Executor> zzehm2) {
        return new zzcht(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
