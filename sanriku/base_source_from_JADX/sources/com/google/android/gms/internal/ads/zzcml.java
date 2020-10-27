package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcml implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcmt> zzfhv;

    private zzcml(zzehm<zzcmt> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcml zzao(zzehm<zzcmt> zzehm, zzehm<Executor> zzehm2) {
        return new zzcml(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
