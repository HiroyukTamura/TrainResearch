package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

public final class zzyz extends zzxe {
    @Nullable
    private final OnPaidEventListener zzcic;

    public zzyz(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzcic = onPaidEventListener;
    }

    public final void zza(zzuo zzuo) {
        if (this.zzcic != null) {
            this.zzcic.onPaidEvent(AdValue.zza(zzuo.zzacj, zzuo.zzack, zzuo.zzacl));
        }
    }
}
