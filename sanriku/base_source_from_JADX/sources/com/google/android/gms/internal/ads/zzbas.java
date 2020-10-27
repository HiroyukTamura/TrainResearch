package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzbas implements zzdqx<T> {
    private final /* synthetic */ zzban zzeag;
    private final /* synthetic */ zzbal zzeah;

    zzbas(zzbaq zzbaq, zzban zzban, zzbal zzbal) {
        this.zzeag = zzban;
        this.zzeah = zzbal;
    }

    public final void onSuccess(@Nullable T t) {
        this.zzeag.zzh(t);
    }

    public final void zzb(Throwable th) {
        this.zzeah.run();
    }
}
