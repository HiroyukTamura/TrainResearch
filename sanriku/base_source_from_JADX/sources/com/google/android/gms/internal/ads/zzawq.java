package com.google.android.gms.internal.ads;

final class zzawq implements Runnable {
    private final /* synthetic */ zzawn zzdvg;

    zzawq(zzawn zzawn) {
        this.zzdvg = zzawn;
    }

    public final void run() {
        Thread unused = this.zzdvg.thread = Thread.currentThread();
        this.zzdvg.zzup();
    }
}
