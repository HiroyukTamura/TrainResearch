package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcof implements zzcnm<zzblx, zzanv, zzcot> {
    /* access modifiers changed from: private */
    public View view;
    private final zzbmt zzgeq;
    private final Context zzvf;

    public zzcof(Context context, zzbmt zzbmt) {
        this.zzvf = context;
        this.zzgeq = zzbmt;
    }

    static final /* synthetic */ zzxl zza(zzcnl zzcnl) throws zzdhk {
        try {
            return ((zzanv) zzcnl.zzdgp).getVideoController();
        } catch (RemoteException e) {
            throw new zzdhk(e);
        }
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzanv, zzcot> zzcnl) throws zzdhk {
        try {
            ((zzanv) zzcnl.zzdgp).zzdp(zzdgo.zzdhp);
            ((zzanv) zzcnl.zzdgp).zza(zzdgo.zzelw, zzdgo.zzgtu.toString(), zzdha.zzgur.zzfll.zzguw, ObjectWrapper.wrap(this.zzvf), new zzcog(this, zzcnl), (zzalv) zzcnl.zzgel, zzdha.zzgur.zzfll.zzbmp);
        } catch (RemoteException e) {
            throw new zzdhk(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzblw zza = this.zzgeq.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzbma(this.view, (zzbek) null, new zzcoe(zzcnl), zzdgo.zzgtt.get(0)));
        zza.zzafk().zzu(this.view);
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaen());
        return zza.zzafj();
    }
}
