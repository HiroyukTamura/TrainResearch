package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzbpz implements zzdnx {
    private final Context zzcit;
    private final zzazz zzfjl;
    private final zzdhe zzfmh;

    zzbpz(Context context, zzazz zzazz, zzdhe zzdhe) {
        this.zzcit = context;
        this.zzfjl = zzazz;
        this.zzfmh = zzdhe;
    }

    public final Object apply(Object obj) {
        Context context = this.zzcit;
        zzazz zzazz = this.zzfjl;
        zzdhe zzdhe = this.zzfmh;
        zzdgo zzdgo = (zzdgo) obj;
        zzaxr zzaxr = new zzaxr(context);
        zzaxr.zzer(zzdgo.zzdny);
        zzaxr.zzes(zzdgo.zzgtw.toString());
        zzaxr.zzac(zzazz.zzbnd);
        zzaxr.setAdUnitId(zzdhe.zzgux);
        return zzaxr;
    }
}
