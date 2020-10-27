package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcqq implements zzcnm<zzcel, zzdhq, zzcot> {
    private final Executor zzfhi;
    private final zzceo zzggx;
    private final Context zzvf;

    public zzcqq(Context context, Executor executor, zzceo zzceo) {
        this.zzvf = context;
        this.zzfhi = executor;
        this.zzggx = zzceo;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcot> zzcnl) throws zzdhk {
        try {
            zzdhe zzdhe = zzdha.zzgur.zzfll;
            if (zzdhe.zzgvd.zzguh == zzdgw.zzgul) {
                ((zzdhq) zzcnl.zzdgp).zzc(this.zzvf, zzdhe.zzguw, zzdgo.zzgtu.toString(), (zzalv) zzcnl.zzgel);
            } else {
                ((zzdhq) zzcnl.zzdgp).zzb(this.zzvf, zzdhe.zzguw, zzdgo.zzgtu.toString(), (zzalv) zzcnl.zzgel);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcnl.zzflf);
            zzazw.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzcen zza = this.zzggx.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzcem(new zzcqt(zzcnl)));
        zza.zzaeh().zza(new zzbkc((zzdhq) zzcnl.zzdgp), this.zzfhi);
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzafy());
        return zza.zzafw();
    }
}
