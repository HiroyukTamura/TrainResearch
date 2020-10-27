package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqj;

public final class zzbqp implements zzegz<zzbqj.zza> {
    private final zzbqj zzfmy;

    private zzbqp(zzbqj zzbqj) {
        this.zzfmy = zzbqj;
    }

    public static zzbqp zzl(zzbqj zzbqj) {
        return new zzbqp(zzbqj);
    }

    public final /* synthetic */ Object get() {
        return (zzbqj.zza) zzehf.zza(this.zzfmy.zzaim(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
