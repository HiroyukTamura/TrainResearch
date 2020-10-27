package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzblu implements zzegz<zzbte> {
    private final zzehm<Clock> zzfhq;
    private final zzehm<ScheduledExecutorService> zzfix;

    public zzblu(zzehm<ScheduledExecutorService> zzehm, zzehm<Clock> zzehm2) {
        this.zzfix = zzehm;
        this.zzfhq = zzehm2;
    }

    public static zzbte zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbte) zzehf.zza(new zzbte(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfix.get(), this.zzfhq.get());
    }
}
