package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbwv implements Runnable {
    private final zzbek zzelg;

    private zzbwv(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    static Runnable zzh(zzbek zzbek) {
        return new zzbwv(zzbek);
    }

    public final void run() {
        this.zzelg.destroy();
    }
}
