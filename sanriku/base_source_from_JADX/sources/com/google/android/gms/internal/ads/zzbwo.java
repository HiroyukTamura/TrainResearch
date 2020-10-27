package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

public final class zzbwo implements zzegz<zzbwi> {
    private final zzehm<Set<zzbvt<VideoController.VideoLifecycleCallbacks>>> zzfjp;

    private zzbwo(zzehm<Set<zzbvt<VideoController.VideoLifecycleCallbacks>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbwo zzv(zzehm<Set<zzbvt<VideoController.VideoLifecycleCallbacks>>> zzehm) {
        return new zzbwo(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbwi(this.zzfjp.get());
    }
}
