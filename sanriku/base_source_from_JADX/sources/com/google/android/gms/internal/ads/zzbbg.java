package com.google.android.gms.internal.ads;

final class zzbbg implements Runnable {
    private final /* synthetic */ zzbav zzeba;

    zzbbg(zzbav zzbav) {
        this.zzeba = zzbav;
    }

    public final void run() {
        if (this.zzeba.zzeay != null) {
            this.zzeba.zzeay.onPaused();
        }
    }
}
