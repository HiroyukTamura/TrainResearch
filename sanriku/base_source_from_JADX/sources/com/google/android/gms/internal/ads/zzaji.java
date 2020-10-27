package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaji implements Runnable {
    private final zzajf zzdcm;
    private final zzajw zzdcu;
    private final zzais zzdcv;

    zzaji(zzajf zzajf, zzajw zzajw, zzais zzais) {
        this.zzdcm = zzajf;
        this.zzdcu = zzajw;
        this.zzdcv = zzais;
    }

    public final void run() {
        this.zzdcm.zza(this.zzdcu, this.zzdcv);
    }
}
