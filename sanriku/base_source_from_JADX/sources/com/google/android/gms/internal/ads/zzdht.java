package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzdht implements zzegz<Clock> {
    private final zzdhu zzgvn;

    public zzdht(zzdhu zzdhu) {
        this.zzgvn = zzdhu;
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzehf.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
