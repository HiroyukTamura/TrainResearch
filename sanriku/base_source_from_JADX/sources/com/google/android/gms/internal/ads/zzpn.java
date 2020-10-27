package com.google.android.gms.internal.ads;

final class zzpn implements Runnable {
    private final /* synthetic */ String zzaii;
    private final /* synthetic */ long zzaij;
    private final /* synthetic */ long zzaik;
    private final /* synthetic */ zzpl zzbki;

    zzpn(zzpl zzpl, String str, long j, long j2) {
        this.zzbki = zzpl;
        this.zzaii = str;
        this.zzaij = j;
        this.zzaik = j2;
    }

    public final void run() {
        this.zzbki.zzbkh.zzd(this.zzaii, this.zzaij, this.zzaik);
    }
}
