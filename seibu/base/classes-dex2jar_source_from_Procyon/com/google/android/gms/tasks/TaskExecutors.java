// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
    public static final Executor MAIN_THREAD;
    static final Executor zzbMf;
    
    static {
        MAIN_THREAD = new zza();
        zzbMf = new zzm();
    }
    
    private TaskExecutors() {
    }
    
    static final class zza implements Executor
    {
        private final Handler mHandler;
        
        public zza() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        
        @Override
        public final void execute(@NonNull final Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }
}
