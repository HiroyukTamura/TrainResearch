package com.google.android.gms.internal.ads;

final /* synthetic */ class zzauy implements Runnable {
    private final String zzdep;
    private final zzauu zzdtd;
    private final zzavk zzdte;

    zzauy(zzauu zzauu, zzavk zzavk, String str) {
        this.zzdtd = zzauu;
        this.zzdte = zzavk;
        this.zzdep = str;
    }

    public final void run() {
        this.zzdtd.zza(this.zzdte, this.zzdep);
    }
}
