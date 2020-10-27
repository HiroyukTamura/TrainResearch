package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzbmb implements zzegz<zzblz> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzbvx> zzexe;
    private final zzehm<zzbnv> zzeyc;
    private final zzehm<zzcte> zzfcy;
    private final zzehm<View> zzfgw;
    private final zzehm<zzdgn> zzfjf;
    private final zzehm<zzbek> zzfjg;
    private final zzehm<zzbnt> zzfjh;
    private final zzehm<zzcae> zzfji;
    private final zzehm<Executor> zzfjj;

    public zzbmb(zzehm<zzbnv> zzehm, zzehm<Context> zzehm2, zzehm<zzdgn> zzehm3, zzehm<View> zzehm4, zzehm<zzbek> zzehm5, zzehm<zzbnt> zzehm6, zzehm<zzcae> zzehm7, zzehm<zzbvx> zzehm8, zzehm<zzcte> zzehm9, zzehm<Executor> zzehm10) {
        this.zzeyc = zzehm;
        this.zzenp = zzehm2;
        this.zzfjf = zzehm3;
        this.zzfgw = zzehm4;
        this.zzfjg = zzehm5;
        this.zzfjh = zzehm6;
        this.zzfji = zzehm7;
        this.zzexe = zzehm8;
        this.zzfcy = zzehm9;
        this.zzfjj = zzehm10;
    }

    public static zzblz zza(zzbnv zzbnv, Context context, zzdgn zzdgn, View view, zzbek zzbek, zzbnt zzbnt, zzcae zzcae, zzbvx zzbvx, zzegt<zzcte> zzegt, Executor executor) {
        return new zzblz(zzbnv, context, zzdgn, view, zzbek, zzbnt, zzcae, zzbvx, zzegt, executor);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeyc.get(), this.zzenp.get(), this.zzfjf.get(), this.zzfgw.get(), this.zzfjg.get(), this.zzfjh.get(), this.zzfji.get(), this.zzexe.get(), zzeha.zzas(this.zzfcy), this.zzfjj.get());
    }
}
