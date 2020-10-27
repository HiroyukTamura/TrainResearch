package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcph implements zzcnm<zzbws, zzanv, zzcot> {
    private final zzbxr zzgfa;
    private final Context zzvf;

    public zzcph(Context context, zzbxr zzbxr) {
        this.zzvf = context;
        this.zzgfa = zzbxr;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzanv, zzcot> zzcnl) throws zzdhk {
        try {
            ((zzanv) zzcnl.zzdgp).zzdp(zzdgo.zzdhp);
            ((zzanv) zzcnl.zzdgp).zza(zzdgo.zzelw, zzdgo.zzgtu.toString(), zzdha.zzgur.zzfll.zzguw, ObjectWrapper.wrap(this.zzvf), (zzank) new zzcpj(this, zzcnl), (zzalv) zzcnl.zzgel);
        } catch (RemoteException e) {
            throw new zzdhk(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        zzcpd zzcpd = new zzcpd(zzdgo, (zzanv) zzcnl.zzdgp, false);
        zzbwu zza = this.zzgfa.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzbwx(zzcpd));
        zzcpd.zza(zza.zzaek());
        ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaen());
        return zza.zzafo();
    }
}
