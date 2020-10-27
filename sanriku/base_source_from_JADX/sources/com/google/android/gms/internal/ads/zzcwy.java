package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcwy implements zzegz<zzcww> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;

    private zzcwy(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        this.zzenm = zzehm;
        this.zzenp = zzehm2;
    }

    public static zzcwy zzat(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        return new zzcwy(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcww(this.zzenm.get(), this.zzenp.get());
    }
}
