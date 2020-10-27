package com.google.android.gms.internal.ads;

final class zzt implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ long zzat;
    private final /* synthetic */ zzq zzau;

    zzt(zzq zzq, String str, long j) {
        this.zzau = zzq;
        this.zzas = str;
        this.zzat = j;
    }

    public final void run() {
        this.zzau.zzae.zza(this.zzas, this.zzat);
        this.zzau.zzae.zzc(this.zzau.toString());
    }
}
