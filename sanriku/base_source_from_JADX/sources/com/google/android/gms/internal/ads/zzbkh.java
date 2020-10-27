package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzbkh implements zzegz<zzbke> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdld> zzets;
    private final zzehm<zzdha> zzfgu;
    private final zzehm<zzdgo> zzfgv;
    private final zzehm<View> zzfgw;
    private final zzehm<zzdt> zzfgx;

    private zzbkh(zzehm<Context> zzehm, zzehm<zzdha> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzdld> zzehm4, zzehm<View> zzehm5, zzehm<zzdt> zzehm6) {
        this.zzenp = zzehm;
        this.zzfgu = zzehm2;
        this.zzfgv = zzehm3;
        this.zzets = zzehm4;
        this.zzfgw = zzehm5;
        this.zzfgx = zzehm6;
    }

    public static zzbkh zza(zzehm<Context> zzehm, zzehm<zzdha> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzdld> zzehm4, zzehm<View> zzehm5, zzehm<zzdt> zzehm6) {
        return new zzbkh(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6);
    }

    public final /* synthetic */ Object get() {
        return new zzbke(this.zzenp.get(), this.zzfgu.get(), this.zzfgv.get(), this.zzets.get(), this.zzfgw.get(), this.zzfgx.get());
    }
}
