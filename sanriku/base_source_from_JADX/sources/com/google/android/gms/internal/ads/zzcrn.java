package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzcrn implements zzbxz {
    private final zzcnl zzgex;

    zzcrn(zzcnl zzcnl) {
        this.zzgex = zzcnl;
    }

    public final void zza(boolean z, Context context) {
        zzcnl zzcnl = this.zzgex;
        try {
            ((zzdhq) zzcnl.zzdgp).setImmersiveMode(z);
            ((zzdhq) zzcnl.zzdgp).showVideo();
        } catch (zzdhk e) {
            zzazw.zzd("Cannot show rewarded video.", e);
            throw new zzbxy(e.getCause());
        }
    }
}
