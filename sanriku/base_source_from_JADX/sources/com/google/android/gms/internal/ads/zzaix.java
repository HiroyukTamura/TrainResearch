package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaix implements Runnable {
    private final String zzdbv;
    private final zzaiu zzdcg;

    zzaix(zzaiu zzaiu, String str) {
        this.zzdcg = zzaiu;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzdcg.zzdf(this.zzdbv);
    }
}
