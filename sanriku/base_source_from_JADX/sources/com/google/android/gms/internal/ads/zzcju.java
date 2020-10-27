package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.TimeUnit;

public final class zzcju implements zzegz<zzdri<String>> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdku> zzfju;

    private zzcju(zzehm<zzdku> zzehm, zzehm<Context> zzehm2) {
        this.zzfju = zzehm;
        this.zzenp = zzehm2;
    }

    public static zzcju zzai(zzehm<zzdku> zzehm, zzehm<Context> zzehm2) {
        return new zzcju(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzdri) zzehf.zza(this.zzfju.get().zzu(zzdkr.WEBVIEW_COOKIE).zzc(new zzcjq(this.zzenp.get())).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcjt.zzgaz).zzaud(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
