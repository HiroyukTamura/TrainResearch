package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcra implements zzcnj<zzcel> {
    private final zzazz zzbml;
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzcey zzfud;
    private final zzceo zzggx;
    private final Context zzvf;

    public zzcra(Context context, zzazz zzazz, zzdhe zzdhe, Executor executor, zzceo zzceo, zzcey zzcey) {
        this.zzvf = context;
        this.zzfll = zzdhe;
        this.zzggx = zzceo;
        this.zzfhi = executor;
        this.zzbml = zzazz;
        this.zzfud = zzcey;
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        zzdgs zzdgs = zzdgo.zzgtr;
        return (zzdgs == null || zzdgs.zzdkw == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzb(zzdgo zzdgo, zzcfo zzcfo, zzdha zzdha, Object obj) throws Exception {
        zzdri<?> zzdri;
        zzdgo zzdgo2 = zzdgo;
        zzbek zza = this.zzfud.zza(this.zzfll.zzbmp, zzdgo2.zzejq);
        zza.zzax(zzdgo2.zzdov);
        zzcfo.zzc(this.zzvf, zza.getView());
        zzbaj zzbaj = new zzbaj();
        zzceo zzceo = this.zzggx;
        zzboi zzboi = new zzboi(zzdha, zzdgo2, (String) null);
        zzcrg zzcrg = r1;
        zzcrg zzcrg2 = new zzcrg(this.zzvf, this.zzfud, this.zzfll, this.zzbml, zzdgo, zzbaj, zza);
        zzcen zza2 = zzceo.zza(zzboi, new zzcem(zzcrg, zza));
        zzbaj.set(zza2);
        zzagl.zza(zza, (zzagk) zza2.zzafx());
        zza2.zzaek().zza(new zzcrf(zza), zzbab.zzdzw);
        zza2.zzaez().zzb(zza, true);
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcte)).booleanValue() || !zzdgo2.zzejq) {
            zza2.zzaez();
            zzdgs zzdgs = zzdgo2.zzgtr;
            zzdri = zzcfa.zza(zza, zzdgs.zzdku, zzdgs.zzdkw);
        } else {
            zzdri = zzdqw.zzag(null);
        }
        return zzdqw.zzb(zzdri, new zzcre(this, zza, zzdgo2, zza2), this.zzfhi);
    }

    public final zzdri<zzcel> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzcfo zzcfo = new zzcfo();
        zzdri<zzcel> zzb = zzdqw.zzb(zzdqw.zzag(null), new zzcrd(this, zzdgo, zzcfo, zzdha), this.zzfhi);
        zzcfo.getClass();
        zzb.addListener(zzcrc.zza(zzcfo), this.zzfhi);
        return zzb;
    }
}
