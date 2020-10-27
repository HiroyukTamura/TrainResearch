package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbig implements zzddo {
    private final /* synthetic */ zzbhw zzewb;
    private Context zzfbl;
    private String zzfbm;

    private zzbig(zzbhw zzbhw) {
        this.zzewb = zzbhw;
    }

    public final zzddl zzafd() {
        zzehf.zza(this.zzfbl, Context.class);
        zzehf.zza(this.zzfbm, String.class);
        return new zzbif(this.zzewb, this.zzfbl, this.zzfbm);
    }

    public final /* synthetic */ zzddo zzbv(Context context) {
        this.zzfbl = (Context) zzehf.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzddo zzft(String str) {
        this.zzfbm = (String) zzehf.checkNotNull(str);
        return this;
    }
}
