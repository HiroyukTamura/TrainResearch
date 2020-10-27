package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbco implements Runnable {
    private final boolean zzecc;
    private final zzbce zzees;
    private final long zzefe;

    zzbco(zzbce zzbce, boolean z, long j) {
        this.zzees = zzbce;
        this.zzecc = z;
        this.zzefe = j;
    }

    public final void run() {
        this.zzees.zzc(this.zzecc, this.zzefe);
    }
}
