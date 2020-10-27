package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdkq implements Runnable {
    private final zzdkm zzgzm;
    private final zzdkd zzgzn;

    zzdkq(zzdkm zzdkm, zzdkd zzdkd) {
        this.zzgzm = zzdkm;
        this.zzgzn = zzdkd;
    }

    public final void run() {
        zzdkm zzdkm = this.zzgzm;
        zzdkm.zzgzf.zzgzd.zzb(this.zzgzn);
    }
}
