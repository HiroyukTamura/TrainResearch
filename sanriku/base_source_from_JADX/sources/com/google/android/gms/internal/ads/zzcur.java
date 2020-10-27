package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcur implements Runnable {
    private final zzcuh zzgkn;
    private final zzcdt[] zzgkw;

    zzcur(zzcuh zzcuh, zzcdt[] zzcdtArr) {
        this.zzgkn = zzcuh;
        this.zzgkw = zzcdtArr;
    }

    public final void run() {
        this.zzgkn.zza(this.zzgkw);
    }
}
