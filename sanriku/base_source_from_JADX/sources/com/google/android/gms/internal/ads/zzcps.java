package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcps implements zzcnm<zzbzm, zzdhq, zzcot> {
    private final Executor zzfhi;
    private final zzbyp zzgfy;
    private final Context zzvf;

    public zzcps(Context context, zzbyp zzbyp, Executor executor) {
        this.zzvf = context;
        this.zzgfy = zzbyp;
        this.zzfhi = executor;
    }

    private static boolean zza(zzdha zzdha, int i) {
        return zzdha.zzgur.zzfll.zzguy.contains(Integer.toString(i));
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcot> zzcnl) throws zzdhk {
        zzdhe zzdhe = zzdha.zzgur.zzfll;
        ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString(), zzayu.zza((zzayv) zzdgo.zzgtr), (zzalv) zzcnl.zzgel, zzdhe.zzdhc, zzdhe.zzguy);
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzbzx zzbzx;
        zzaly zztg = ((zzdhq) zzcnl.zzdgp).zztg();
        zzamd zzth = ((zzdhq) zzcnl.zzdgp).zzth();
        zzame zztm = ((zzdhq) zzcnl.zzdgp).zztm();
        if (zztm != null && zza(zzdha, 6)) {
            zzbzx = zzbzx.zzb(zztm);
        } else if (zztg != null && zza(zzdha, 6)) {
            zzbzx = zzbzx.zzb(zztg);
        } else if (zztg != null && zza(zzdha, 2)) {
            zzbzx = zzbzx.zza(zztg);
        } else if (zzth != null && zza(zzdha, 6)) {
            zzbzx = zzbzx.zzb(zzth);
        } else if (zzth == null || !zza(zzdha, 1)) {
            throw new zzcqm("No native ad mappers", 0);
        } else {
            zzbzx = zzbzx.zza(zzth);
        }
        if (zzdha.zzgur.zzfll.zzguy.contains(Integer.toString(zzbzx.zzakw()))) {
            zzbzy zza = this.zzgfy.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzcaj(zzbzx), new zzcbm(zzth, zztg, zztm));
            ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaem());
            zza.zzaeh().zza(new zzbkc((zzdhq) zzcnl.zzdgp), this.zzfhi);
            return zza.zzaeo();
        }
        throw new zzcqm("No corresponding native ad listener", 0);
    }
}
