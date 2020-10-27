package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzt;

final /* synthetic */ class zzcea implements zzt {
    private final zzbrx zzfwm;

    private zzcea(zzbrx zzbrx) {
        this.zzfwm = zzbrx;
    }

    static zzt zza(zzbrx zzbrx) {
        return new zzcea(zzbrx);
    }

    public final void zzuq() {
        this.zzfwm.onAdLeftApplication();
    }
}
