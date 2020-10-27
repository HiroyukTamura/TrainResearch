package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcjj implements Runnable {
    private final String zzdbv;
    private final zzcjg zzgaq;

    zzcjj(zzcjg zzcjg, String str) {
        this.zzgaq = zzcjg;
        this.zzdbv = str;
    }

    public final void run() {
        zzcjg zzcjg = this.zzgaq;
        zzcjg.zzgal.zzgj(this.zzdbv);
    }
}
