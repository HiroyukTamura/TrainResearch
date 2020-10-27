package com.google.android.gms.internal.ads;

import java.util.List;

final /* synthetic */ class zzcje implements Runnable {
    private final String zzeir;
    private final zzciz zzfzv;
    private final zzdhq zzgai;
    private final zzahc zzgaj;
    private final List zzgak;

    zzcje(zzciz zzciz, zzdhq zzdhq, zzahc zzahc, List list, String str) {
        this.zzfzv = zzciz;
        this.zzgai = zzdhq;
        this.zzgaj = zzahc;
        this.zzgak = list;
        this.zzeir = str;
    }

    public final void run() {
        this.zzfzv.zza(this.zzgai, this.zzgaj, this.zzgak, this.zzeir);
    }
}
