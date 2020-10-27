package com.google.android.gms.internal.ads;

final /* synthetic */ class zzajl implements Runnable {
    private final zzais zzdcz;

    private zzajl(zzais zzais) {
        this.zzdcz = zzais;
    }

    static Runnable zzb(zzais zzais) {
        return new zzajl(zzais);
    }

    public final void run() {
        this.zzdcz.destroy();
    }
}
