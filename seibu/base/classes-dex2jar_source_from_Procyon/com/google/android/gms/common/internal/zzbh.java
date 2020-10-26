// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.PendingResult;

public final class zzbh
{
    private static final zzbn zzaIi;
    
    static {
        zzaIi = new zzbi();
    }
    
    public static <R extends Result, T extends Response<R>> Task<T> zza(final PendingResult<R> pendingResult, final T t) {
        return zza(pendingResult, (zzbm<R, T>)new zzbk(t));
    }
    
    private static <R extends Result, T> Task<T> zza(final PendingResult<R> pendingResult, final zzbm<R, T> zzbm) {
        final zzbn zzaIi = zzbh.zzaIi;
        final TaskCompletionSource<T> taskCompletionSource = new TaskCompletionSource<T>();
        pendingResult.zza((PendingResult.zza)new zzbj(pendingResult, taskCompletionSource, zzbm, zzaIi));
        return taskCompletionSource.getTask();
    }
    
    public static <R extends Result> Task<Void> zzb(final PendingResult<R> pendingResult) {
        return zza(pendingResult, (zzbm<R, Void>)new zzbl());
    }
}
