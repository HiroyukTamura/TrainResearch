// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

public final class zzbgw implements ThreadFactory
{
    private final int mPriority;
    private final String zzaKe;
    private final AtomicInteger zzaKf;
    private final ThreadFactory zzaKg;
    
    public zzbgw(final String s) {
        this(s, 0);
    }
    
    private zzbgw(final String s, final int n) {
        this.zzaKf = new AtomicInteger();
        this.zzaKg = Executors.defaultThreadFactory();
        this.zzaKe = zzbo.zzb(s, "Name must not be null");
        this.mPriority = 0;
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        final Thread thread = this.zzaKg.newThread(new zzbgx(runnable, 0));
        final String zzaKe = this.zzaKe;
        thread.setName(new StringBuilder(String.valueOf(zzaKe).length() + 13).append(zzaKe).append("[").append(this.zzaKf.getAndIncrement()).append("]").toString());
        return thread;
    }
}
