// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzk<TResult>
{
    private final Executor zzbEo;
    private final Continuation<TResult, Task<TContinuationResult>> zzbLR;
    private final zzn<TContinuationResult> zzbLS;
    
    public zzc(@NonNull final Executor zzbEo, @NonNull final Continuation<TResult, Task<TContinuationResult>> zzbLR, @NonNull final zzn<TContinuationResult> zzbLS) {
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
        this.zzbEo.execute(new zzd(this, task));
    }
    
    @Override
    public final void onFailure(@NonNull final Exception exception) {
        this.zzbLS.setException(exception);
    }
    
    @Override
    public final void onSuccess(final TContinuationResult result) {
        this.zzbLS.setResult(result);
    }
}
