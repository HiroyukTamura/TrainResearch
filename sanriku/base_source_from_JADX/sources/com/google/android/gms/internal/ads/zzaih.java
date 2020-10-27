package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaih implements Runnable {
    private final zzaie zzdbu;
    private final String zzdbv;

    zzaih(zzaie zzaie, String str) {
        this.zzdbu = zzaie;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzdbu.zzdd(this.zzdbv);
    }
}
