package com.google.android.gms.internal.ads;

final class zzbbn implements Runnable {
    private final /* synthetic */ zzbbk zzeca;
    private final /* synthetic */ boolean zzecd;

    zzbbn(zzbbk zzbbk, boolean z) {
        this.zzeca = zzbbk;
        this.zzecd = z;
    }

    public final void run() {
        this.zzeca.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzecd));
    }
}
