package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcov implements zzcnj<zzbws> {
    private final zzazz zzbml;
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzcey zzfud;
    private final zzbxr zzgfa;
    private final Context zzvf;

    public zzcov(Context context, zzazz zzazz, zzdhe zzdhe, Executor executor, zzbxr zzbxr, zzcey zzcey) {
        this.zzvf = context;
        this.zzfll = zzdhe;
        this.zzgfa = zzbxr;
        this.zzfhi = executor;
        this.zzbml = zzazz;
        this.zzfud = zzcey;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdgo zzdgo, zzcfo zzcfo, zzdha zzdha, Object obj) throws Exception {
        zzdri<?> zzdri;
        zzbek zza = this.zzfud.zza(this.zzfll.zzbmp, zzdgo.zzejq);
        zza.zzax(zzdgo.zzdov);
        zzcfo.zzc(this.zzvf, zza.getView());
        zzbaj zzbaj = new zzbaj();
        zzbwu zza2 = this.zzgfa.zza(new zzboi(zzdha, zzdgo, (String) null), new zzbwx(new zzcpb(this.zzvf, this.zzbml, zzbaj, zzdgo, zza), zza));
        zzbaj.set(zza2);
        zza2.zzaek().zza(new zzcow(zza), zzbab.zzdzw);
        zza2.zzaez().zzb(zza, true);
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcte)).booleanValue() || !zzdgo.zzejq) {
            zza2.zzaez();
            zzdgs zzdgs = zzdgo.zzgtr;
            zzdri = zzcfa.zza(zza, zzdgs.zzdku, zzdgs.zzdkw);
        } else {
            zzdri = zzdqw.zzag(null);
        }
        return zzdqw.zzb(zzdri, new zzcoz(this, zza, zzdgo, zza2), this.zzfhi);
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        zzdgs zzdgs = zzdgo.zzgtr;
        return (zzdgs == null || zzdgs.zzdkw == null) ? false : true;
    }

    public final zzdri<zzbws> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzcfo zzcfo = new zzcfo();
        zzdri<zzbws> zzb = zzdqw.zzb(zzdqw.zzag(null), new zzcou(this, zzdgo, zzcfo, zzdha), this.zzfhi);
        zzcfo.getClass();
        zzb.addListener(zzcox.zza(zzcfo), this.zzfhi);
        return zzb;
    }
}
