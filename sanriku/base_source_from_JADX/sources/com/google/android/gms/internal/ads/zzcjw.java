package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzcjw implements zzegz<ApplicationInfo> {
    private final zzehm<Context> zzenp;

    private zzcjw(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public static zzcjw zzac(zzehm<Context> zzehm) {
        return new zzcjw(zzehm);
    }

    public static ApplicationInfo zzcc(Context context) {
        return (ApplicationInfo) zzehf.zza(context.getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzcc(this.zzenp.get());
    }
}
