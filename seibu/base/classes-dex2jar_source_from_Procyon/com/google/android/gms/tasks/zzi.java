// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzi<TResult> implements zzk<TResult>
{
    private final Object mLock;
    private final Executor zzbEo;
    private OnSuccessListener<? super TResult> zzbMa;
    
    public zzi(@NonNull final Executor zzbEo, @NonNull final OnSuccessListener<? super TResult> zzbMa) {
        this.mLock = new Object();
        this.zzbEo = zzbEo;
        this.zzbMa = zzbMa;
    }
    
    @Override
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzbMa = null;
        }
    }
    
    @Override
    public final void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzbMa == null) {
                    return;
                }
                // monitorexit(this.mLock)
                this.zzbEo.execute(new zzj(this, task));
            }
        }
    }
}
