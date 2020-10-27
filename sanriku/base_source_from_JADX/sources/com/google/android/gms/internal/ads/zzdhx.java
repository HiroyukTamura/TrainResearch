package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdhx implements zzegz<zzdhy> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzawo> zzeqb;

    private zzdhx(zzehm<Context> zzehm, zzehm<zzawo> zzehm2) {
        this.zzenp = zzehm;
        this.zzeqb = zzehm2;
    }

    public static zzdhx zzbd(zzehm<Context> zzehm, zzehm<zzawo> zzehm2) {
        return new zzdhx(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzdhy(this.zzenp.get(), this.zzeqb.get());
    }
}
