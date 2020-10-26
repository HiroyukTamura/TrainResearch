// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zze<TResult> implements zzk<TResult>
{
    private final Object mLock;
    private final Executor zzbEo;
    private OnCompleteListener<TResult> zzbLW;
    
    public zze(@NonNull final Executor zzbEo, @NonNull final OnCompleteListener<TResult> zzbLW) {
        this.mLock = new Object();
        this.zzbEo = zzbEo;
        this.zzbLW = zzbLW;
    }
    
    @Override
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzbLW = null;
        }
    }
    
    @Override
    public final void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzbLW == null) {
                return;
            }
            // monitorexit(this.mLock)
            this.zzbEo.execute(new zzf(this, task));
        }
    }
}
