package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

final /* synthetic */ class zzbgb implements Runnable {
    private final zzbgc zzelk;

    zzbgb(zzbgc zzbgc) {
        this.zzelk = zzbgc;
    }

    public final void run() {
        zzbgc zzbgc = this.zzelk;
        zzbgc.zzehs.zzabs();
        zzc zzabf = zzbgc.zzehs.zzabf();
        if (zzabf != null) {
            zzabf.zzui();
        }
    }
}
