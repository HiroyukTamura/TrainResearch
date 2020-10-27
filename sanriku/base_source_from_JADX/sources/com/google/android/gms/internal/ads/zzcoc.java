package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcoc implements zzegz<zzcoa> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzfib;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzbmt> zzges;

    public zzcoc(zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzbmt> zzehm3, zzehm<Executor> zzehm4) {
        this.zzenp = zzehm;
        this.zzfib = zzehm2;
        this.zzges = zzehm3;
        this.zzfjj = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzcoa(this.zzenp.get(), this.zzfib.get(), this.zzges.get(), this.zzfjj.get());
    }
}
