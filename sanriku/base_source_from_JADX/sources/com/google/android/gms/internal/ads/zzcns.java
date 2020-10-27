package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcns implements zzcnj<zzblx> {
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzcey zzfud;
    private final zzbmt zzgeq;
    private final zzdnx<zzdgo, zzaxr> zzger;
    private final Context zzvf;

    public zzcns(zzbmt zzbmt, Context context, Executor executor, zzcey zzcey, zzdhe zzdhe, zzdnx<zzdgo, zzaxr> zzdnx) {
        this.zzvf = context;
        this.zzgeq = zzbmt;
        this.zzfhi = executor;
        this.zzfud = zzcey;
        this.zzfll = zzdhe;
        this.zzger = zzdnx;
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        zzdgs zzdgs = zzdgo.zzgtr;
        return (zzdgs == null || zzdgs.zzdkw == null) ? false : true;
    }

    public final zzdri<zzblx> zzb(zzdha zzdha, zzdgo zzdgo) {
        return zzdqw.zzb(zzdqw.zzag(null), new zzcnv(this, zzdha, zzdgo), this.zzfhi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzb(zzdha zzdha, zzdgo zzdgo, Object obj) throws Exception {
        zzum zzb = zzdhh.zzb(this.zzvf, zzdgo.zzgtt);
        zzbek zzc = this.zzfud.zzc(zzb);
        zzc.zzax(zzdgo.zzdov);
        zzbmt zzbmt = this.zzgeq;
        zzboi zzboi = new zzboi(zzdha, zzdgo, (String) null);
        zzcfp zzcfp = new zzcfp(this.zzvf, zzc.getView(), this.zzger.apply(zzdgo));
        zzc.getClass();
        zzblw zza = zzbmt.zza(zzboi, new zzbma(zzcfp, zzc, zzcnu.zzp(zzc), zzdhh.zze(zzb)));
        zza.zzaez().zzb(zzc, false);
        zza.zzaek().zza(new zzcnx(zzc), zzbab.zzdzw);
        zza.zzaez();
        zzdgs zzdgs = zzdgo.zzgtr;
        zzdri<?> zza2 = zzcfa.zza(zzc, zzdgs.zzdku, zzdgs.zzdkw);
        if (zzdgo.zzdpp) {
            zzc.getClass();
            zza2.addListener(zzcnw.zzh(zzc), this.zzfhi);
        }
        zza2.addListener(new zzcnz(this, zzc), this.zzfhi);
        return zzdqw.zzb(zza2, new zzcny(zza), (Executor) zzbab.zzdzw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzbek zzbek) {
        zzbek.zzabd();
        zzbfe zzzf = zzbek.zzzf();
        zzze zzze = this.zzfll.zzguv;
        if (zzze != null && zzzf != null) {
            zzzf.zzb(zzze);
        }
    }
}
