package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbxb implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzffv;
    private final zzehm<zzdgo> zzfia;
    private final zzehm<zzdhe> zzfjq;
    private final zzbwx zzfpa;

    private zzbxb(zzbwx zzbwx, zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzdhe> zzehm4) {
        this.zzfpa = zzbwx;
        this.zzenp = zzehm;
        this.zzffv = zzehm2;
        this.zzfia = zzehm3;
        this.zzfjq = zzehm4;
    }

    public static zzbxb zza(zzbwx zzbwx, zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzdhe> zzehm4) {
        return new zzbxb(zzbwx, zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(new zzbww(this.zzenp.get(), this.zzffv.get(), this.zzfia.get(), this.zzfjq.get()), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
