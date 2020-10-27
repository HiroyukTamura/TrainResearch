package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbxl implements zzegz<zzbvt<zzbtq>> {
    private final zzehm<Executor> zzenm;
    private final zzbwx zzfpa;

    private zzbxl(zzbwx zzbwx, zzehm<Executor> zzehm) {
        this.zzfpa = zzbwx;
        this.zzenm = zzehm;
    }

    public static zzbxl zzd(zzbwx zzbwx, zzehm<Executor> zzehm) {
        return new zzbxl(zzbwx, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(this.zzfpa.zzb(this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
