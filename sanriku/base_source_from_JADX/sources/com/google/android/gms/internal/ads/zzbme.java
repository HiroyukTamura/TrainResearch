package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbme implements zzegz<View> {
    private final zzbma zzfjo;

    public zzbme(zzbma zzbma) {
        this.zzfjo = zzbma;
    }

    public static View zza(zzbma zzbma) {
        return (View) zzehf.zza(zzbma.zzahe(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo);
    }
}
