package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpr implements zzegz<zzbvt<zzbtt>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzchn> zzfhv;

    private zzbpr(zzehm<zzchn> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbpr zzl(zzehm<zzchn> zzehm, zzehm<Executor> zzehm2) {
        return new zzbpr(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
