// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public final class zzbda
{
    private static final ExecutorService zzaEb;
    
    static {
        zzaEb = Executors.newFixedThreadPool(2, new zzbgw("GAC_Executor"));
    }
    
    public static ExecutorService zzqj() {
        return zzbda.zzaEb;
    }
}
