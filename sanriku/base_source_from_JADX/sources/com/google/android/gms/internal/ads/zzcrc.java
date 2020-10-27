package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcrc implements Runnable {
    private final zzcfo zzgfr;

    private zzcrc(zzcfo zzcfo) {
        this.zzgfr = zzcfo;
    }

    static Runnable zza(zzcfo zzcfo) {
        return new zzcrc(zzcfo);
    }

    public final void run() {
        this.zzgfr.zzamy();
    }
}
