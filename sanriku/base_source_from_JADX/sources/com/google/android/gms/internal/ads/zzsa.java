package com.google.android.gms.internal.ads;

final class zzsa implements Runnable {
    private final /* synthetic */ zzrx zzbsk;

    zzsa(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void run() {
        this.zzbsk.disconnect();
    }
}
