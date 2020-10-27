package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbxj implements zzegz<zzbvt<zzbqx>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbyh> zzfip;
    private final zzbwx zzfpa;

    private zzbxj(zzbwx zzbwx, zzehm<zzbyh> zzehm, zzehm<Executor> zzehm2) {
        this.zzfpa = zzbwx;
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbxj zzb(zzbwx zzbwx, zzehm<zzbyh> zzehm, zzehm<Executor> zzehm2) {
        return new zzbxj(zzbwx, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
