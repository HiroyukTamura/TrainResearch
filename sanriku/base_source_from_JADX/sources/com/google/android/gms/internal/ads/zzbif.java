package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbif implements zzddl {
    private final /* synthetic */ zzbhw zzewb;
    private zzehm<Context> zzfbf;
    private zzehm<String> zzfbg;
    private zzehm<zzdeu<zzbll, zzblr>> zzfbh;
    private zzehm<zzddn> zzfbi;
    private zzehm<zzdcz> zzfbj;
    private zzehm<zzddf> zzfbk;

    private zzbif(zzbhw zzbhw, Context context, String str) {
        this.zzewb = zzbhw;
        this.zzfbf = zzehc.zzbb(context);
        this.zzfbg = zzehc.zzbb(str);
        this.zzfbh = new zzdey(this.zzfbf, this.zzewb.zzepo, this.zzewb.zzepp);
        this.zzfbi = zzeha.zzar(new zzddu(this.zzewb.zzepo));
        this.zzfbj = zzeha.zzar(new zzddg(this.zzfbf, this.zzewb.zzent, this.zzewb.zzenk, this.zzfbh, this.zzfbi, zzdhf.zzary()));
        this.zzfbk = zzeha.zzar(new zzddm(this.zzewb.zzenk, this.zzfbf, this.zzfbg, this.zzfbj, this.zzfbi, this.zzewb.zzeob));
    }

    public final zzddf zzafc() {
        return this.zzfbk.get();
    }
}
