package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcon implements zzegz<zzcoi> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzbxr> zzges;
    private final zzehm<zzdgm> zzgfg;

    public zzcon(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzbxr> zzehm3, zzehm<zzdgm> zzehm4) {
        this.zzenp = zzehm;
        this.zzfjj = zzehm2;
        this.zzges = zzehm3;
        this.zzgfg = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzcoi(this.zzenp.get(), this.zzfjj.get(), this.zzges.get(), this.zzgfg.get());
    }
}
