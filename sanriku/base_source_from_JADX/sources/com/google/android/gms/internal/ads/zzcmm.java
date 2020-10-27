package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcmm implements zzegz<zzcmn> {
    private final zzehm<Context> zzenp;

    private zzcmm(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public static zzcmm zzae(zzehm<Context> zzehm) {
        return new zzcmm(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzcmn(this.zzenp.get());
    }
}
