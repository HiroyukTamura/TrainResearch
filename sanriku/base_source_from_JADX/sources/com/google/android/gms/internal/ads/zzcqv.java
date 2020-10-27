package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcqv implements zzcnm<zzcel, zzanv, zzcot> {
    private final zzceo zzggx;
    private final Context zzvf;

    public zzcqv(Context context, zzceo zzceo) {
        this.zzvf = context;
        this.zzggx = zzceo;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzanv, zzcot> zzcnl) throws zzdhk {
        try {
            ((zzanv) zzcnl.zzdgp).zzdp(zzdgo.zzdhp);
            if (zzdha.zzgur.zzfll.zzgvd.zzguh == zzdgw.zzgul) {
                ((zzanv) zzcnl.zzdgp).zzb(zzdgo.zzelw, zzdgo.zzgtu.toString(), zzdha.zzgur.zzfll.zzguw, ObjectWrapper.wrap(this.zzvf), new zzcqx(this, zzcnl), (zzalv) zzcnl.zzgel);
            } else {
                ((zzanv) zzcnl.zzdgp).zza(zzdgo.zzelw, zzdgo.zzgtu.toString(), zzdha.zzgur.zzfll.zzguw, ObjectWrapper.wrap(this.zzvf), (zzanq) new zzcqx(this, zzcnl), (zzalv) zzcnl.zzgel);
            }
        } catch (RemoteException e) {
            zzawr.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzcpd zzcpd = new zzcpd(zzdgo, (zzanv) zzcnl.zzdgp, true);
        zzcen zza = this.zzggx.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzcem(zzcpd));
        zzcpd.zza(zza.zzaek());
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzafz());
        return zza.zzafw();
    }
}
