package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaab implements OnCompleteListener<TResult> {
    private final /* synthetic */ TaskCompletionSource zafp;
    private final /* synthetic */ zaz zafq;

    zaab(zaz zaz, TaskCompletionSource taskCompletionSource) {
        this.zafq = zaz;
        this.zafp = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zafq.zafn.remove(this.zafp);
    }
}
