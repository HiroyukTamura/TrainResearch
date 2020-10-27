package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p009e.p010a.p011a.p012a.C0681a;

final class zzavi implements ThreadFactory {
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzavi(zzauu zzauu) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, C0681a.m309a(42, "AdWorker(SCION_TASK_EXECUTOR) #", this.zzyi.getAndIncrement()));
    }
}
