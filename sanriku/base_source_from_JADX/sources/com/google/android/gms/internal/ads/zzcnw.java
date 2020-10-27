package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcnw implements Runnable {
    private final zzbek zzelg;

    private zzcnw(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    static Runnable zzh(zzbek zzbek) {
        return new zzcnw(zzbek);
    }

    public final void run() {
        this.zzelg.zzabw();
    }
}
