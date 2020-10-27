package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class zzbhd implements zzegz<WeakReference<Context>> {
    private final zzbhb zzeni;

    public zzbhd(zzbhb zzbhb) {
        this.zzeni = zzbhb;
    }

    public final /* synthetic */ Object get() {
        return (WeakReference) zzehf.zza(this.zzeni.zzadm(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
