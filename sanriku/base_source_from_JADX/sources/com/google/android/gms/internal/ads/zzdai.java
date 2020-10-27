package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdai implements zzegz<zzdab> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzfmf;

    private zzdai(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        this.zzenm = zzehm;
        this.zzfmf = zzehm2;
    }

    public static zzdab zza(zzdrh zzdrh, Context context) {
        return new zzdab(zzdrh, context);
    }

    public static zzdai zzba(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        return new zzdai(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzenm.get(), this.zzfmf.get());
    }
}
