package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzbzs {
    @Nullable
    private zzacr zzchr;

    public zzbzs(zzbzk zzbzk) {
        this.zzchr = zzbzk;
    }

    public final synchronized void zza(@Nullable zzacr zzacr) {
        this.zzchr = zzacr;
    }

    @Nullable
    public final synchronized zzacr zzsl() {
        return this.zzchr;
    }
}
