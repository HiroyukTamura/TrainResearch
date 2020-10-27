package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbzo implements Runnable {
    private final zzcaf zzfrm;

    private zzbzo(zzcaf zzcaf) {
        this.zzfrm = zzcaf;
    }

    static Runnable zza(zzcaf zzcaf) {
        return new zzbzo(zzcaf);
    }

    public final void run() {
        this.zzfrm.zzakn();
    }
}
