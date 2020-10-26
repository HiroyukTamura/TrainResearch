// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zza<TResult, TContinuationResult> implements zzk<TResult>
{
    private final Executor zzbEo;
    private final Continuation<TResult, TContinuationResult> zzbLR;
    private final zzn<TContinuationResult> zzbLS;
    
    public zza(@NonNull final Executor zzbEo, @NonNull final Continuation<TResult, TContinuationResult> zzbLR, @NonNull final zzn<TContinuationResult> zzbLS) {
        this.zzbEo = zzbEo;
        this.zzbLR = zzbLR;
        this.zzbLS = zzbLS;
    }
    
    @Override
    public final void cancel() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final void onComplete(@NonNull final Task<TResult> task) {
        this.zzbEo.execute(new zzb(this, task));
    }
}
