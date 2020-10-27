package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdrk {
    public static zzdrh zza(ExecutorService executorService) {
        return executorService instanceof zzdrh ? (zzdrh) executorService : executorService instanceof ScheduledExecutorService ? new zzdro((ScheduledExecutorService) executorService) : new zzdrl(executorService);
    }

    static Executor zza(Executor executor, zzdpw<?> zzdpw) {
        zzdoj.checkNotNull(executor);
        zzdoj.checkNotNull(zzdpw);
        return executor == zzdqp.INSTANCE ? executor : new zzdrj(executor, zzdpw);
    }

    public static Executor zzawr() {
        return zzdqp.INSTANCE;
    }
}
