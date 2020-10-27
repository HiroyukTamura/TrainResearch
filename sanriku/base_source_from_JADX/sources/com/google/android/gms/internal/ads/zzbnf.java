package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbnf implements Runnable {
    private final Runnable zzffu;
    private final zzbnd zzfka;

    zzbnf(zzbnd zzbnd, Runnable runnable) {
        this.zzfka = zzbnd;
        this.zzffu = runnable;
    }

    public final void run() {
        this.zzfka.zze(this.zzffu);
    }
}
