package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcpc implements zzcnm<zzbws, zzdhq, zzcot> {
    private final zzazz zzbml;
    private final Executor zzfhi;
    private final zzbxr zzgfa;
    private final Context zzvf;

    public zzcpc(Context context, zzazz zzazz, zzbxr zzbxr, Executor executor) {
        this.zzvf = context;
        this.zzbml = zzazz;
        this.zzgfa = zzbxr;
        this.zzfhi = executor;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcot> zzcnl) throws zzdhk {
        if (this.zzbml.zzdzo < 4100000) {
            ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString(), (zzalv) zzcnl.zzgel);
        } else {
            ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString(), zzayu.zza((zzayv) zzdgo.zzgtr), (zzalv) zzcnl.zzgel);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzbwu zza = this.zzgfa.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzbwx(new zzcpf(zzcnl)));
        zza.zzaeh().zza(new zzbkc((zzdhq) zzcnl.zzdgp), this.zzfhi);
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaem());
        return zza.zzafo();
    }
}
