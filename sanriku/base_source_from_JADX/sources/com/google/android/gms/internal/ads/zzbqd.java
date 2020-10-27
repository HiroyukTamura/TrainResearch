package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqd implements zzegz<zzbqa> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdgo> zzfkc;
    private final zzehm<zzapn> zzfmm;

    private zzbqd(zzehm<Context> zzehm, zzehm<zzdgo> zzehm2, zzehm<zzapn> zzehm3) {
        this.zzenp = zzehm;
        this.zzfkc = zzehm2;
        this.zzfmm = zzehm3;
    }

    public static zzbqd zzh(zzehm<Context> zzehm, zzehm<zzdgo> zzehm2, zzehm<zzapn> zzehm3) {
        return new zzbqd(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzbqa(this.zzenp.get(), this.zzfkc.get(), this.zzfmm.get());
    }
}
