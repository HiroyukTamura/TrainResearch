package com.google.android.gms.internal.ads;

final class zzbbo implements Runnable {
    private final /* synthetic */ zzbbk zzeca;

    zzbbo(zzbbk zzbbk) {
        this.zzeca = zzbbk;
    }

    public final void run() {
        this.zzeca.zzd("surfaceDestroyed", new String[0]);
    }
}
