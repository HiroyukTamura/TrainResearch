package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcpu implements zzcnm<zzbzm, zzanv, zzcot> {
    private final zzbyp zzgfy;
    /* access modifiers changed from: private */
    public zzame zzggf;
    private final Context zzvf;

    public zzcpu(Context context, zzbyp zzbyp) {
        this.zzvf = context;
        this.zzgfy = zzbyp;
    }

    public final void zza(zzdha zzdha, zzdgo zzdgo, zzcnl<zzanv, zzcot> zzcnl) throws zzdhk {
        try {
            ((zzanv) zzcnl.zzdgp).zzdp(zzdgo.zzdhp);
            ((zzanv) zzcnl.zzdgp).zza(zzdgo.zzelw, zzdgo.zzgtu.toString(), zzdha.zzgur.zzfll.zzguw, ObjectWrapper.wrap(this.zzvf), (zzanp) new zzcpw(this, zzcnl), (zzalv) zzcnl.zzgel);
        } catch (RemoteException e) {
            throw new zzdhk(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws zzdhk, zzcqm {
        if (zzdha.zzgur.zzfll.zzguy.contains(Integer.toString(6))) {
            zzbzx zzb = zzbzx.zzb(this.zzggf);
            if (zzdha.zzgur.zzfll.zzguy.contains(Integer.toString(zzb.zzakw()))) {
                zzbzy zza = this.zzgfy.zza(new zzboi(zzdha, zzdgo, zzcnl.zzflf), new zzcaj(zzb), new zzcbm((zzamd) null, (zzaly) null, this.zzggf));
                ((zzcot) zzcnl.zzgel).zzb((zzalv) zza.zzaen());
                return zza.zzaeo();
            }
            throw new zzcqm("No corresponding native ad listener", 0);
        }
        throw new zzcqm("Unified must be used for RTB.", 1);
    }
}
