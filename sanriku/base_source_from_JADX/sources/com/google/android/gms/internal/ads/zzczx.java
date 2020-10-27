package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzczx implements zzegz<zzczv> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzffv;

    private zzczx(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2, zzehm<zzazz> zzehm3) {
        this.zzenm = zzehm;
        this.zzenp = zzehm2;
        this.zzffv = zzehm3;
    }

    public static zzczx zzu(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2, zzehm<zzazz> zzehm3) {
        return new zzczx(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzczv(this.zzenm.get(), this.zzenp.get(), this.zzffv.get());
    }
}
