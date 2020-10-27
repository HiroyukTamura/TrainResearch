package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcgm implements zzegz<zzbvt<zzbtm>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcgs> zzfhv;

    private zzcgm(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcgm zzx(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        return new zzcgm(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
