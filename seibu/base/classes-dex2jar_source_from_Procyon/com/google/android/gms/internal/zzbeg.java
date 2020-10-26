// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public final class zzbeg
{
    private static final ExecutorService zzaEb;
    
    static {
        zzaEb = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new zzbgw("GAC_Transform"));
    }
    
    public static ExecutorService zzqj() {
        return zzbeg.zzaEb;
    }
}
