package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzbap implements zzdqx<T> {
    private final /* synthetic */ zzbaq zzead;

    zzbap(zzbaq zzbaq) {
        this.zzead = zzbaq;
    }

    public final void onSuccess(@Nullable T t) {
        this.zzead.zzeaf.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzead.zzeaf.set(-1);
    }
}
