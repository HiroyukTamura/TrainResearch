package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzczr implements zzdak<zzczs> {
    private final zzauu zzboj;
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzczr(zzauu zzauu, zzdrh zzdrh, Context context) {
        this.zzboj = zzauu;
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzczs> zzaqa() {
        return this.zzfur.zzd(new zzczu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczs zzaqn() throws Exception {
        if (!this.zzboj.zzab(this.zzvf)) {
            return new zzczs((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzae = this.zzboj.zzae(this.zzvf);
        String str = zzae == null ? "" : zzae;
        String zzaf = this.zzboj.zzaf(this.zzvf);
        String str2 = zzaf == null ? "" : zzaf;
        String zzag = this.zzboj.zzag(this.zzvf);
        String str3 = zzag == null ? "" : zzag;
        String zzah = this.zzboj.zzah(this.zzvf);
        return new zzczs(str, str2, str3, zzah == null ? "" : zzah, "TIME_OUT".equals(str2) ? (Long) zzvj.zzpv().zzd(zzzz.zzckr) : null);
    }
}
