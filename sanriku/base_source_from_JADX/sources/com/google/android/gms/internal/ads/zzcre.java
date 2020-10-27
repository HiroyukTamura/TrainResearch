package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzcre implements zzdnx {
    private final zzdgo zzfjm;
    private final zzbek zzfvt;
    private final zzcra zzghb;
    private final zzcen zzghc;

    zzcre(zzcra zzcra, zzbek zzbek, zzdgo zzdgo, zzcen zzcen) {
        this.zzghb = zzcra;
        this.zzfvt = zzbek;
        this.zzfjm = zzdgo;
        this.zzghc = zzcen;
    }

    public final Object apply(Object obj) {
        zzbek zzbek = this.zzfvt;
        zzdgo zzdgo = this.zzfjm;
        zzcen zzcen = this.zzghc;
        if (zzdgo.zzdpp) {
            zzbek.zzabw();
        }
        zzbek.zzabd();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcld)).booleanValue()) {
            zzq.zzky();
            zzaxf.zza(zzbek);
        }
        return zzcen.zzafw();
    }
}
