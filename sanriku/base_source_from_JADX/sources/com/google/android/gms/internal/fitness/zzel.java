package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzel extends zzcp {
    private final BaseImplementation.ResultHolder<Status> zzmv;

    public zzel(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzmv = resultHolder;
    }

    public static zzel zza(TaskCompletionSource<Void> taskCompletionSource) {
        return new zzel(new zzek(taskCompletionSource));
    }

    public static zzel zzb(TaskCompletionSource<Boolean> taskCompletionSource) {
        return new zzel(new zzen(taskCompletionSource));
    }

    public final void onResult(Status status) {
        this.zzmv.setResult(status);
    }
}
