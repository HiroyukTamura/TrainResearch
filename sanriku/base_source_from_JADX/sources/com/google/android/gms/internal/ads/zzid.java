package com.google.android.gms.internal.ads;

final class zzid implements Runnable {
    private final /* synthetic */ zzhw zzail;
    private final /* synthetic */ zziy zzais;

    zzid(zzhw zzhw, zziy zziy) {
        this.zzail = zzhw;
        this.zzais = zziy;
    }

    public final void run() {
        this.zzais.zzgm();
        this.zzail.zzaih.zzd(this.zzais);
    }
}
