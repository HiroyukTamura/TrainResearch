package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdjo implements ThreadFactory {
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzdjo() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, C0681a.m309a(25, "AdWorker(NG) #", this.zzyi.getAndIncrement()));
    }
}
