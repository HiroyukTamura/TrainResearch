package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzcif implements zzegz<zzcid> {
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzchx> zzfzj;
    private final zzehm<Set<zzcic>> zzfzk;

    private zzcif(zzehm<zzchx> zzehm, zzehm<Set<zzcic>> zzehm2, zzehm<Clock> zzehm3) {
        this.zzfzj = zzehm;
        this.zzfzk = zzehm2;
        this.zzfhq = zzehm3;
    }

    public static zzcif zzn(zzehm<zzchx> zzehm, zzehm<Set<zzcic>> zzehm2, zzehm<Clock> zzehm3) {
        return new zzcif(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcid(this.zzfzj.get(), this.zzfzk.get(), this.zzfhq.get());
    }
}
