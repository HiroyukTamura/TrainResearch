package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqm implements zzegz<Context> {
    private final zzehm<Context> zzfmf;
    private final zzbqj zzfmy;

    private zzbqm(zzbqj zzbqj, zzehm<Context> zzehm) {
        this.zzfmy = zzbqj;
        this.zzfmf = zzehm;
    }

    public static zzbqm zza(zzbqj zzbqj, zzehm<Context> zzehm) {
        return new zzbqm(zzbqj, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzehf.zza(this.zzfmy.zzca(this.zzfmf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
