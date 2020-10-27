package com.google.android.gms.internal.ads;

final class zzps implements Runnable {
    private final /* synthetic */ zzpl zzbki;
    private final /* synthetic */ int zzbkm;
    private final /* synthetic */ int zzbkn;
    private final /* synthetic */ int zzbko;
    private final /* synthetic */ float zzbkp;

    zzps(zzpl zzpl, int i, int i2, int i3, float f) {
        this.zzbki = zzpl;
        this.zzbkm = i;
        this.zzbkn = i2;
        this.zzbko = i3;
        this.zzbkp = f;
    }

    public final void run() {
        this.zzbki.zzbkh.zzb(this.zzbkm, this.zzbkn, this.zzbko, this.zzbkp);
    }
}
