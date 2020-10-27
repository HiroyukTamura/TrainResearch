package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcgn implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcgs> zzfhv;

    private zzcgn(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcgn zzy(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        return new zzcgn(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
