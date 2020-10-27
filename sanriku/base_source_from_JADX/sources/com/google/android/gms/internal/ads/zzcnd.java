package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcnd implements zzegz<zzcmy> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzcmv> zzeqw;
    private final zzehm<zzcmp> zzetl;
    private final zzehm<zzbqc> zzgee;

    private zzcnd(zzehm<Context> zzehm, zzehm<zzbqc> zzehm2, zzehm<zzcmv> zzehm3, zzehm<zzcmp> zzehm4) {
        this.zzenp = zzehm;
        this.zzgee = zzehm2;
        this.zzeqw = zzehm3;
        this.zzetl = zzehm4;
    }

    public static zzcnd zzc(zzehm<Context> zzehm, zzehm<zzbqc> zzehm2, zzehm<zzcmv> zzehm3, zzehm<zzcmp> zzehm4) {
        return new zzcnd(zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        return new zzcmy(this.zzenp.get(), this.zzgee.get(), this.zzeqw.get(), this.zzetl.get());
    }
}
