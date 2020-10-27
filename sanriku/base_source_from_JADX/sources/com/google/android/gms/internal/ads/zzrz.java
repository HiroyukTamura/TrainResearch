package com.google.android.gms.internal.ads;

final class zzrz implements zzqq {
    private final /* synthetic */ zzrx zzbsk;

    zzrz(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void zzp(boolean z) {
        if (z) {
            this.zzbsk.connect();
        } else {
            this.zzbsk.disconnect();
        }
    }
}
