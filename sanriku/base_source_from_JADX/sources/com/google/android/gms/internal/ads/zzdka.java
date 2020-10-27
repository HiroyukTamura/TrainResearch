package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class zzdka implements zzegz<ScheduledExecutorService> {
    private final zzehm<ThreadFactory> zzgyx;

    public zzdka(zzehm<ThreadFactory> zzehm) {
        this.zzgyx = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzehf.zza(new ScheduledThreadPoolExecutor(1, this.zzgyx.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
