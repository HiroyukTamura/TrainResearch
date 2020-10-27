package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzbww implements zzbsm {
    private final Context zzcit;
    private final zzazz zzfjl;
    private final zzdgo zzfjm;
    private final zzdhe zzfjn;

    zzbww(Context context, zzazz zzazz, zzdgo zzdgo, zzdhe zzdhe) {
        this.zzcit = context;
        this.zzfjl = zzazz;
        this.zzfjm = zzdgo;
        this.zzfjn = zzdhe;
    }

    public final void onAdLoaded() {
        zzq.zzlg().zzb(this.zzcit, this.zzfjl.zzbnd, this.zzfjm.zzgtw.toString(), this.zzfjn.zzgux);
    }
}
