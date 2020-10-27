package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

public final class zzcme implements zzegz<zzclo> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzasa> zzgcu;
    private final zzehm<zzbjv> zzgcv;
    private final zzehm<zzarx> zzgcw;
    private final zzehm<HashMap<String, zzcmd>> zzgcx;

    private zzcme(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzasa> zzehm3, zzehm<zzbjv> zzehm4, zzehm<zzarx> zzehm5, zzehm<HashMap<String, zzcmd>> zzehm6) {
        this.zzenp = zzehm;
        this.zzfjj = zzehm2;
        this.zzgcu = zzehm3;
        this.zzgcv = zzehm4;
        this.zzgcw = zzehm5;
        this.zzgcx = zzehm6;
    }

    public static zzcme zzc(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzasa> zzehm3, zzehm<zzbjv> zzehm4, zzehm<zzarx> zzehm5, zzehm<HashMap<String, zzcmd>> zzehm6) {
        return new zzcme(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6);
    }

    public final /* synthetic */ Object get() {
        return new zzclo(this.zzenp.get(), this.zzfjj.get(), this.zzgcu.get(), this.zzgcv.get(), this.zzgcw.get(), this.zzgcx.get());
    }
}
