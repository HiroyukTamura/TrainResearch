package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbjd implements Runnable {
    private final zzbja zzfft;
    private final Runnable zzffu;

    zzbjd(zzbja zzbja, Runnable runnable) {
        this.zzfft = zzbja;
        this.zzffu = runnable;
    }

    public final void run() {
        zzbab.zzdzv.execute(new zzbjc(this.zzfft, this.zzffu));
    }
}
