package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzczt implements zzegz<zzczr> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzauu> zzffy;

    private zzczt(zzehm<zzauu> zzehm, zzehm<zzdrh> zzehm2, zzehm<Context> zzehm3) {
        this.zzffy = zzehm;
        this.zzenm = zzehm2;
        this.zzenp = zzehm3;
    }

    public static zzczt zzt(zzehm<zzauu> zzehm, zzehm<zzdrh> zzehm2, zzehm<Context> zzehm3) {
        return new zzczt(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzczr(this.zzffy.get(), this.zzenm.get(), this.zzenp.get());
    }
}
