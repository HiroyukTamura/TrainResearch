package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcjv implements zzegz<zzdri<String>> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdt> zzfgx;
    private final zzehm<zzdrh> zzgba;

    private zzcjv(zzehm<zzdt> zzehm, zzehm<Context> zzehm2, zzehm<zzdrh> zzehm3) {
        this.zzfgx = zzehm;
        this.zzenp = zzehm2;
        this.zzgba = zzehm3;
    }

    public static zzcjv zzo(zzehm<zzdt> zzehm, zzehm<Context> zzehm2, zzehm<zzdrh> zzehm3) {
        return new zzcjv(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return (zzdri) zzehf.zza(this.zzgba.get().zzd(new zzcjs(this.zzfgx.get(), this.zzenp.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
