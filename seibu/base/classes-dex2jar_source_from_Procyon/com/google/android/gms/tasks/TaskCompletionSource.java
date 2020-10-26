// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult>
{
    private final zzn<TResult> zzbMe;
    
    public TaskCompletionSource() {
        this.zzbMe = new zzn<TResult>();
    }
    
    @NonNull
    public Task<TResult> getTask() {
        return this.zzbMe;
    }
    
    public void setException(@NonNull final Exception exception) {
        this.zzbMe.setException(exception);
    }
    
    public void setResult(final TResult result) {
        this.zzbMe.setResult(result);
    }
    
    public boolean trySetException(@NonNull final Exception ex) {
        return this.zzbMe.trySetException(ex);
    }
    
    public boolean trySetResult(final TResult tResult) {
        return this.zzbMe.trySetResult(tResult);
    }
}
