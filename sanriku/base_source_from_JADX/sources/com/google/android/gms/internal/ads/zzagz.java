package com.google.android.gms.internal.ads;

final class zzagz implements Runnable {
    private final /* synthetic */ zzagu zzdbf;

    zzagz(zzagu zzagu) {
        this.zzdbf = zzagu;
    }

    public final void run() {
        this.zzdbf.disconnect();
    }
}
