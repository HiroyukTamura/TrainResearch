// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzbgv implements Executor
{
    private final Handler mHandler;
    
    public zzbgv(final Looper looper) {
        this.mHandler = new Handler(looper);
    }
    
    @Override
    public final void execute(@NonNull final Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
