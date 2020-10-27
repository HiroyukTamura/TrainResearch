package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbbm implements Runnable {
    private final zzbbk zzecb;
    private final boolean zzecc;

    zzbbm(zzbbk zzbbk, boolean z) {
        this.zzecb = zzbbk;
        this.zzecc = z;
    }

    public final void run() {
        this.zzecb.zzau(this.zzecc);
    }
}
