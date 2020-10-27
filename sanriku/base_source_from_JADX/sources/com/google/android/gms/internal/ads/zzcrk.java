package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrk implements zzcnm<zzcel, zzdhq, zzcos> {
    /* access modifiers changed from: private */
    public final Executor zzfhi;
    private final zzceo zzggx;
    private final Context zzvf;

    public zzcrk(Context context, Executor executor, zzceo zzceo) {
        this.zzvf = context;
        this.zzfhi = executor;
        this.zzggx = zzceo;
    }

    /* access modifiers changed from: private */
    public static void zzc(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcos> zzcnl) {
        try {
            ((zzdhq) zzcnl.zzdgp).zza(zzdha.zzgur.zzfll.zzguw, zzdgo.zzgtu.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcnl.zzflf);
            zzazw.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzdhq, zzcos> zzcnl) throws zzdhk {
        if (!((zzdhq) zzcnl.zzdgp).isInitialized()) {
            ((zzcos) zzcnl.zzgel).zza((zzbwg) new zzcrm(this, zzdha, zzdgo, zzcnl));
            ((zzdhq) zzcnl.zzdgp).zza(this.zzvf, zzdha.zzgur.zzfll.zzguw, (String) null, (zzasy) zzcnl.zzgel, zzdgo.zzgtu.toString());
            return;
        }
        zzc(zzdha, zzdgo, zzcnl);
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzcen zza = this.zzggx.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzcem(new zzcrn(zzcnl)));
        zza.zzaeh().zza(new zzbkc((zzdhq) zzcnl.zzdgp), this.zzfhi);
        zzbrx zzaei = zza.zzaei();
        zzbqw zzaej = zza.zzaej();
        ((zzcos) zzcnl.zzgel).zza((zzasy) new zzcro(this, zza.zzafp(), zzaej, zzaei, zza.zzafx()));
        return zza.zzafw();
    }
}
