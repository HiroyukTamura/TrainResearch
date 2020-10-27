package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcmk implements zzegz<zzbvt<zzdla>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcmw> zzfhv;

    private zzcmk(zzehm<zzcmw> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcmk zzan(zzehm<zzcmw> zzehm, zzehm<Executor> zzehm2) {
        return new zzcmk(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
