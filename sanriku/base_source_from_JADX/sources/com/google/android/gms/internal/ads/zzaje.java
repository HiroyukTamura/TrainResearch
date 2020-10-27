package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaje implements Runnable {
    private final zzajf zzdcm;
    private final zzdt zzdcn;
    private final zzajw zzdco;

    zzaje(zzajf zzajf, zzdt zzdt, zzajw zzajw) {
        this.zzdcm = zzajf;
        this.zzdcn = zzdt;
        this.zzdco = zzajw;
    }

    public final void run() {
        this.zzdcm.zza(this.zzdcn, this.zzdco);
    }
}
