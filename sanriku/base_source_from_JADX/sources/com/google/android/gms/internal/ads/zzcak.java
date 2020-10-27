package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcak implements zzegz<zzbvt<zzbtb>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzctk> zzfhv;

    private zzcak(zzehm<zzctk> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcak zzr(zzehm<zzctk> zzehm, zzehm<Executor> zzehm2) {
        return new zzcak(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
