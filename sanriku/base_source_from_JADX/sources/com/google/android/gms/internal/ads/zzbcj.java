package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbcj implements Runnable {
    private final int zzdwt;
    private final int zzdwu;
    private final zzbce zzees;

    zzbcj(zzbce zzbce, int i, int i2) {
        this.zzees = zzbce;
        this.zzdwt = i;
        this.zzdwu = i2;
    }

    public final void run() {
        this.zzees.zzp(this.zzdwt, this.zzdwu);
    }
}
