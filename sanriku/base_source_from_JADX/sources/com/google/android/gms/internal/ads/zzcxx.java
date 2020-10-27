package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcxx implements zzegz<zzcxv> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;

    private zzcxx(zzehm<Context> zzehm, zzehm<zzdrh> zzehm2) {
        this.zzenp = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcxx zzav(zzehm<Context> zzehm, zzehm<zzdrh> zzehm2) {
        return new zzcxx(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcxv(this.zzenp.get(), this.zzenm.get());
    }
}
