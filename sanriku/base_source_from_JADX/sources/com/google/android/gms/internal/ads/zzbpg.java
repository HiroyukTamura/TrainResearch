package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpg implements zzegz<zzbvt<zzbqx>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbke> zzfip;

    private zzbpg(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbpg zzf(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        return new zzbpg(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
