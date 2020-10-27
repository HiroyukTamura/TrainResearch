package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzcoz implements zzdnx {
    private final zzdgo zzfjm;
    private final zzbek zzfvt;
    private final zzcov zzgfn;
    private final zzbwu zzgfs;

    zzcoz(zzcov zzcov, zzbek zzbek, zzdgo zzdgo, zzbwu zzbwu) {
        this.zzgfn = zzcov;
        this.zzfvt = zzbek;
        this.zzfjm = zzdgo;
        this.zzgfs = zzbwu;
    }

    public final Object apply(Object obj) {
        zzbek zzbek = this.zzfvt;
        zzdgo zzdgo = this.zzfjm;
        zzbwu zzbwu = this.zzgfs;
        if (zzdgo.zzdpp) {
            zzbek.zzabw();
        }
        zzbek.zzabd();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcld)).booleanValue()) {
            zzq.zzky();
            zzaxf.zza(zzbek);
        }
        return zzbwu.zzafo();
    }
}
