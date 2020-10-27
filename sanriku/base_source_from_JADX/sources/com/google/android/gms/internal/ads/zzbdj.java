package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final class zzbdj implements Runnable {
    private final /* synthetic */ zzbdk zzegm;

    zzbdj(zzbdk zzbdk) {
        this.zzegm = zzbdk;
    }

    public final void run() {
        zzq.zzls().zzb(this.zzegm);
    }
}
