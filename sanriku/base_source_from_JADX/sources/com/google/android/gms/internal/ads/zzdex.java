package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdex implements zzegz<zzdeu<zzceo, zzcel>> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdih> zzepo;
    private final zzehm<zzdiz> zzepp;

    public zzdex(zzehm<Context> zzehm, zzehm<zzdih> zzehm2, zzehm<zzdiz> zzehm3) {
        this.zzenp = zzehm;
        this.zzepo = zzehm2;
        this.zzepp = zzehm3;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.zzenp.get();
        zzdih zzdih = this.zzepo.get();
        zzdiz zzdiz = this.zzepp.get();
        if (((Integer) zzvj.zzpv().zzd(zzzz.zzctg)).intValue() > 0) {
            zzdjc zza = zzdiz.zza(zzdiu.Rewarded, context, zzdih, new zzdec(new zzddt()));
            obj = new zzddy(new zzdel(new zzdem()), new zzded(zza.zzgrx, zzbab.zzdzr), zza.zzgxy, zzbab.zzdzr);
        } else {
            obj = new zzdem();
        }
        return (zzdeu) zzehf.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
