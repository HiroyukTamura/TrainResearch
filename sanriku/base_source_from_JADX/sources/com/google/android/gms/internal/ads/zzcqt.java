package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzcqt implements zzbxz {
    private final zzcnl zzgex;

    zzcqt(zzcnl zzcnl) {
        this.zzgex = zzcnl;
    }

    public final void zza(boolean z, Context context) {
        zzcnl zzcnl = this.zzgex;
        try {
            ((zzdhq) zzcnl.zzdgp).setImmersiveMode(z);
            ((zzdhq) zzcnl.zzdgp).zzcf(context);
        } catch (zzdhk e) {
            throw new zzbxy(e.getCause());
        }
    }
}
