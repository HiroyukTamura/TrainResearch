// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Status;

public final class zzber
{
    public static <TResult> void zza(final Status status, final TResult result, final TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(result);
            return;
        }
        taskCompletionSource.setException(new ApiException(status));
    }
}
