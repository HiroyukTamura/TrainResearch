package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzdro extends zzdrl implements zzdrh, ScheduledExecutorService {
    private final ScheduledExecutorService zzhil;

    zzdro(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzhil = (ScheduledExecutorService) zzdoj.checkNotNull(scheduledExecutorService);
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzdrw zza = zzdrw.zza(runnable, null);
        return new zzdrn(zza, this.zzhil.schedule(zza, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzdrw zze = zzdrw.zze(callable);
        return new zzdrn(zze, this.zzhil.schedule(zze, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdrq zzdrq = new zzdrq(runnable);
        return new zzdrn(zzdrq, this.zzhil.scheduleAtFixedRate(zzdrq, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdrq zzdrq = new zzdrq(runnable);
        return new zzdrn(zzdrq, this.zzhil.scheduleWithFixedDelay(zzdrq, j, j2, timeUnit));
    }
}
