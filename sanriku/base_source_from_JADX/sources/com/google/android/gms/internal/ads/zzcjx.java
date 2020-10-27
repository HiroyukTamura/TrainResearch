package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcjx implements zzegz<zzbvt<zzbtm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcla> zzfhv;

    private zzcjx(zzehm<zzcla> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcjx zzaj(zzehm<zzcla> zzehm, zzehm<Executor> zzehm2) {
        return new zzcjx(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
