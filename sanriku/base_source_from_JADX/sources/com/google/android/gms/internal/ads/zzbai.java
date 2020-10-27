package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;

final class zzbai implements zzdqx<Object> {
    private final /* synthetic */ String zzeaa;

    zzbai(String str) {
        this.zzeaa = str;
    }

    public final void onSuccess(@Nullable Object obj) {
    }

    public final void zzb(Throwable th) {
        zzq.zzla().zza(th, this.zzeaa);
    }
}
