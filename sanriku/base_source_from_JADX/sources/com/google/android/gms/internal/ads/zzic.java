package com.google.android.gms.internal.ads;

final class zzic implements Runnable {
    private final /* synthetic */ zzhw zzail;
    private final /* synthetic */ int zzair;

    zzic(zzhw zzhw, int i) {
        this.zzail = zzhw;
        this.zzair = i;
    }

    public final void run() {
        this.zzail.zzaih.zzu(this.zzair);
    }
}
