package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcja implements Runnable {
    private final zzciz zzfzv;
    private final zzbaj zzgaf;

    zzcja(zzciz zzciz, zzbaj zzbaj) {
        this.zzfzv = zzciz;
        this.zzgaf = zzbaj;
    }

    public final void run() {
        this.zzfzv.zza(this.zzgaf);
    }
}
