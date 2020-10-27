package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcih implements Runnable {
    private final String zzdbv;
    private final zzcie zzfzl;

    zzcih(zzcie zzcie, String str) {
        this.zzfzl = zzcie;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzfzl.zzgg(this.zzdbv);
    }
}
