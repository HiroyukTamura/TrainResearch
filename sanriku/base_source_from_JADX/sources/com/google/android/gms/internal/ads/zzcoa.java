package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;

public final class zzcoa implements zzcnm<zzblx, zzdhq, zzcot> {
    private final zzazz zzbml;
    private final Executor zzfhi;
    private final zzbmt zzgeq;
    private final Context zzvf;

    public zzcoa(Context context, zzazz zzazz, zzbmt zzbmt, Executor executor) {
        this.zzvf = context;
        this.zzbml = zzazz;
        this.zzgeq = zzbmt;
        this.zzfhi = executor;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcot> zzcnl) throws zzdhk {
        zzum zzum = zzdha.zzgur.zzfll.zzbmp;
        zzum zzum2 = zzum.zzcfd ? new zzum(this.zzvf, zzb.zza(zzum.width, zzum.height)) : zzdhh.zzb(this.zzvf, zzdgo.zzgtt);
        if (this.zzbml.zzdzo < 4100000) {
            ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzum2, zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString(), (zzalv) zzcnl.zzgel);
        } else {
            ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzum2, zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString(), zzayu.zza((zzayv) zzdgo.zzgtr), (zzalv) zzcnl.zzgel);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzbmt zzbmt = this.zzgeq;
        zzboi zzboi = new zzboi(zzdha, zzdgo, zzcnl.zzflf);
        View view = ((zzdhq) zzcnl.zzdgp).getView();
        zzdhq zzdhq = (zzdhq) zzcnl.zzdgp;
        zzdhq.getClass();
        zzblw zza = zzbmt.zza(zzboi, new zzbma(view, (zzbek) null, zzcod.zza(zzdhq), zzdgo.zzgtt.get(0)));
        zza.zzafk().zzu(((zzdhq) zzcnl.zzdgp).getView());
        zza.zzaeh().zza(new zzbkc((zzdhq) zzcnl.zzdgp), this.zzfhi);
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaem());
        return zza.zzafj();
    }
}
