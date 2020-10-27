package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmi implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzffv;
    private final zzehm<zzdgo> zzfia;
    private final zzbma zzfjo;
    private final zzehm<zzdhe> zzfjq;

    public zzbmi(zzbma zzbma, zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzdhe> zzehm4) {
        this.zzfjo = zzbma;
        this.zzenp = zzehm;
        this.zzffv = zzehm2;
        this.zzfia = zzehm3;
        this.zzfjq = zzehm4;
    }

    public static zzbvt<zzbsm> zza(zzbma zzbma, Context context, zzazz zzazz, zzdgo zzdgo, zzdhe zzdhe) {
        return (zzbvt) zzehf.zza(new zzbvt(new zzbmd(context, zzazz, zzdgo, zzdhe), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo, this.zzenp.get(), this.zzffv.get(), this.zzfia.get(), this.zzfjq.get());
    }
}
