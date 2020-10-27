package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcgj implements zzegz<zzbvt<zzub>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcgs> zzfhv;

    private zzcgj(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcgj zzu(zzehm<zzcgs> zzehm, zzehm<Executor> zzehm2) {
        return new zzcgj(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
