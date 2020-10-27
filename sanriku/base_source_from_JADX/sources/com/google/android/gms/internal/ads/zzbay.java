package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbay implements Runnable {
    private final int zzdwt;
    private final zzbav zzebb;

    zzbay(zzbav zzbav, int i) {
        this.zzebb = zzbav;
        this.zzdwt = i;
    }

    public final void run() {
        this.zzebb.zzdd(this.zzdwt);
    }
}
