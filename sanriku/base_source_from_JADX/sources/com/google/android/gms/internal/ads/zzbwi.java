package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

public final class zzbwi extends zzbui<VideoController.VideoLifecycleCallbacks> {
    private boolean zzekx;

    protected zzbwi(Set<zzbvt<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        zza(zzbwk.zzfnf);
    }

    public final void onVideoPause() {
        zza(zzbwl.zzfnf);
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzekx) {
            zza(zzbwm.zzfnf);
            this.zzekx = true;
        }
        zza(zzbwp.zzfnf);
    }

    public final synchronized void onVideoStart() {
        zza(zzbwn.zzfnf);
        this.zzekx = true;
    }
}
