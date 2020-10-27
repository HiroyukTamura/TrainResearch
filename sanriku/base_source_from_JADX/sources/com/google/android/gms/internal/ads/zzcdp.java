package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcdp implements zzegz<zzcdn> {
    private final zzehm<zzcat> zzeym;
    private final zzehm<Context> zzfmf;
    private final zzehm<zzbzx> zzfqt;
    private final zzehm<zzbzm> zzfwa;

    private zzcdp(zzehm<Context> zzehm, zzehm<zzbzx> zzehm2, zzehm<zzcat> zzehm3, zzehm<zzbzm> zzehm4) {
        this.zzfmf = zzehm;
        this.zzfqt = zzehm2;
        this.zzeym = zzehm3;
        this.zzfwa = zzehm4;
    }

    public static zzcdp zzb(zzehm<Context> zzehm, zzehm<zzbzx> zzehm2, zzehm<zzcat> zzehm3, zzehm<zzbzm> zzehm4) {
        return new zzcdp(zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        return new zzcdn(this.zzfmf.get(), this.zzfqt.get(), this.zzeym.get(), this.zzfwa.get());
    }
}
