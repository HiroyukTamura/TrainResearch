package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzczk implements zzegz<zzczi> {
    private final zzehm<Context> zzenp;
    private final zzehm<String> zzepz;

    private zzczk(zzehm<Context> zzehm, zzehm<String> zzehm2) {
        this.zzenp = zzehm;
        this.zzepz = zzehm2;
    }

    public static zzczk zzaz(zzehm<Context> zzehm, zzehm<String> zzehm2) {
        return new zzczk(zzehm, zzehm2);
    }

    public static zzczi zzt(Context context, String str) {
        return new zzczi(context, str);
    }

    public final /* synthetic */ Object get() {
        return zzt(this.zzenp.get(), this.zzepz.get());
    }
}
