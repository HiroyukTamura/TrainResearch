package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbkm implements zzegz<zzbkn> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzpu> zzfhb;

    private zzbkm(zzehm<Context> zzehm, zzehm<zzpu> zzehm2) {
        this.zzenp = zzehm;
        this.zzfhb = zzehm2;
    }

    public static zzbkm zza(zzehm<Context> zzehm, zzehm<zzpu> zzehm2) {
        return new zzbkm(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbkn(this.zzenp.get(), this.zzfhb.get());
    }
}
