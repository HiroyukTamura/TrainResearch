package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzcok implements zzbxz {
    private final zzbaj zzbsx;

    zzcok(zzbaj zzbaj) {
        this.zzbsx = zzbaj;
    }

    public final void zza(boolean z, Context context) {
        zzbaj zzbaj = this.zzbsx;
        try {
            zzq.zzkv();
            zzn.zza(context, (AdOverlayInfoParcel) zzbaj.get(), true);
        } catch (Exception unused) {
        }
    }
}
