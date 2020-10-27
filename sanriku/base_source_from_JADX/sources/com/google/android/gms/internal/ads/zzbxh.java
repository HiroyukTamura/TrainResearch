package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbxh implements zzegz<zzaur> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdhe> zzfjq;
    private final zzbwx zzfpa;

    private zzbxh(zzbwx zzbwx, zzehm<Context> zzehm, zzehm<zzdhe> zzehm2) {
        this.zzfpa = zzbwx;
        this.zzenp = zzehm;
        this.zzfjq = zzehm2;
    }

    public static zzbxh zza(zzbwx zzbwx, zzehm<Context> zzehm, zzehm<zzdhe> zzehm2) {
        return new zzbxh(zzbwx, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzaur) zzehf.zza(new zzaur(this.zzenp.get(), this.zzfjq.get().zzgux), "Cannot return null from a non-@Nullable @Provides method");
    }
}
