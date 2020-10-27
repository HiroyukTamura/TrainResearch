package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcox implements Runnable {
    private final zzcfo zzgfr;

    private zzcox(zzcfo zzcfo) {
        this.zzgfr = zzcfo;
    }

    static Runnable zza(zzcfo zzcfo) {
        return new zzcox(zzcfo);
    }

    public final void run() {
        this.zzgfr.zzamy();
    }
}
