package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

public final class zzbdk extends zzawn {
    final zzbbx zzebj;
    private final String zzebv;
    private final String[] zzebw;
    final zzbdl zzegn;

    zzbdk(zzbbx zzbbx, zzbdl zzbdl, String str, String[] strArr) {
        this.zzebj = zzbbx;
        this.zzegn = zzbdl;
        this.zzebv = str;
        this.zzebw = strArr;
        zzq.zzls().zza(this);
    }

    public final void zzup() {
        try {
            this.zzegn.zze(this.zzebv, this.zzebw);
        } finally {
            zzaxa.zzdwf.post(new zzbdj(this));
        }
    }
}
