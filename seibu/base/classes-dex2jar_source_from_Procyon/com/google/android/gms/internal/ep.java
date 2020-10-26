// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import android.content.Context;

public final class ep
{
    private static Integer zzbLP;
    private static Integer zzbLQ;
    private final Context mContext;
    private final ExecutorService zzbrV;
    
    static {
        ep.zzbLP = 0;
        ep.zzbLQ = 1;
    }
    
    public ep(final Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }
    
    private ep(final Context mContext, final ExecutorService zzbrV) {
        this.mContext = mContext;
        this.zzbrV = zzbrV;
    }
}
