package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzen implements ThreadFactory {
    private final ThreadFactory zzyh = Executors.defaultThreadFactory();
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzen() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzyh.newThread(runnable);
        int andIncrement = this.zzyi.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
