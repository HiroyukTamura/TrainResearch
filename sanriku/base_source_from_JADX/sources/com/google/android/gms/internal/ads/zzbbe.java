package com.google.android.gms.internal.ads;

final class zzbbe implements Runnable {
    private final /* synthetic */ zzbav zzeba;

    zzbbe(zzbav zzbav) {
        this.zzeba = zzbav;
    }

    public final void run() {
        if (this.zzeba.zzeay != null) {
            this.zzeba.zzeay.onPaused();
            this.zzeba.zzeay.zzys();
        }
    }
}
