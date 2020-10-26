// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzg<TResult> implements zzk<TResult>
{
    private final Object mLock;
    private final Executor zzbEo;
    private OnFailureListener zzbLY;
    
    public zzg(@NonNull final Executor zzbEo, @NonNull final OnFailureListener zzbLY) {
        this.mLock = new Object();
        this.zzbEo = zzbEo;
        this.zzbLY = zzbLY;
    }
    
    @Override
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzbLY = null;
        }
    }
    
    @Override
    public final void onComplete(@NonNull final Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzbLY == null) {
                    return;
                }
                // monitorexit(this.mLock)
                this.zzbEo.execute(new zzh(this, task));
            }
        }
    }
}
