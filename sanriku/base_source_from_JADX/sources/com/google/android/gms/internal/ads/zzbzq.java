package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbzq implements Runnable {
    private final boolean zzecc;
    private final zzbzm zzfrn;

    zzbzq(zzbzm zzbzm, boolean z) {
        this.zzfrn = zzbzm;
        this.zzecc = z;
    }

    public final void run() {
        this.zzfrn.zzbj(this.zzecc);
    }
}
