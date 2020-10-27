package com.google.android.gms.internal.ads;

final /* synthetic */ class zzajp implements Runnable {
    private final zzais zzdcz;

    private zzajp(zzais zzais) {
        this.zzdcz = zzais;
    }

    static Runnable zzb(zzais zzais) {
        return new zzajp(zzais);
    }

    public final void run() {
        this.zzdcz.destroy();
    }
}
