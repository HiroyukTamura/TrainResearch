package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdaw implements zzegz<zzdau> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;

    private zzdaw(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        this.zzenm = zzehm;
        this.zzenp = zzehm2;
    }

    public static zzdaw zzbc(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2) {
        return new zzdaw(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzdau(this.zzenm.get(), this.zzenp.get());
    }
}
