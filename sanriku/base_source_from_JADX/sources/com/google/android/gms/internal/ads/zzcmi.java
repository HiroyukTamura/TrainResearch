package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcmi implements zzegz<zzbvt<zzbrc>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcmt> zzfhv;

    private zzcmi(zzehm<zzcmt> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcmi zzam(zzehm<zzcmt> zzehm, zzehm<Executor> zzehm2) {
        return new zzcmi(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
