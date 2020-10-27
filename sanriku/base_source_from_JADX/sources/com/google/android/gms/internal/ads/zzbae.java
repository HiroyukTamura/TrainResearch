package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p009e.p010a.p011a.p012a.C0681a;

final class zzbae implements ThreadFactory {
    private final /* synthetic */ String zzdzy;
    private final AtomicInteger zzyi = new AtomicInteger(1);

    zzbae(String str) {
        this.zzdzy = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzdzy;
        int andIncrement = this.zzyi.getAndIncrement();
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 23));
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
