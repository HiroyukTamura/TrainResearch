package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbhe implements zzegz<Context> {
    private final zzbhb zzeni;

    public zzbhe(zzbhb zzbhb) {
        this.zzeni = zzbhb;
    }

    public static Context zza(zzbhb zzbhb) {
        return (Context) zzehf.zza(zzbhb.zzadl(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeni);
    }
}
