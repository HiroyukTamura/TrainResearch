package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcas implements Runnable {
    private final zzcat zzftn;
    private final zzcbj zzfto;

    zzcas(zzcat zzcat, zzcbj zzcbj) {
        this.zzftn = zzcat;
        this.zzfto = zzcbj;
    }

    public final void run() {
        this.zzftn.zzd(this.zzfto);
    }
}
