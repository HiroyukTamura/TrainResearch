package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcgk implements zzegz<zzbvt<zzbuf>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcgs> zzfhv;

    private zzcgk(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcgk zzv(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        return new zzcgk(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
