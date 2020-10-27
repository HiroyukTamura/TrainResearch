package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

public final class zzcbs implements zzegz<zzbvt<VideoController.VideoLifecycleCallbacks>> {
    private final zzehm<zzceh> zzfhv;
    private final zzehm<Executor> zzfjj;
    private final zzcbm zzfum;

    public zzcbs(zzcbm zzcbm, zzehm<zzceh> zzehm, zzehm<Executor> zzehm2) {
        this.zzfum = zzcbm;
        this.zzfhv = zzehm;
        this.zzfjj = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzfjj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
