package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzbnc implements Runnable {
    private final AtomicReference zzfjx;

    zzbnc(AtomicReference atomicReference) {
        this.zzfjx = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzfjx.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
