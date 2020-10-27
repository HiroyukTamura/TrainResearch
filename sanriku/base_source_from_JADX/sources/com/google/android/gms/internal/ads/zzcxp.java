package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

public final class zzcxp implements zzdak<zzcxu> {
    private final zzdrh zzfur;
    private final Context zzzo;

    zzcxp(Context context, zzdrh zzdrh) {
        this.zzzo = context;
        this.zzfur = zzdrh;
    }

    public final zzdri<zzcxu> zzaqa() {
        return this.zzfur.zzd(new zzcxs(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcxu zzaqg() throws Exception {
        zzq.zzkw();
        String zzaz = zzaxa.zzaz(this.zzzo);
        String str = "";
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsu)).booleanValue()) {
            str = this.zzzo.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str);
        }
        zzq.zzkw();
        return new zzcxu(zzaz, str, zzaxa.zzba(this.zzzo));
    }
}
