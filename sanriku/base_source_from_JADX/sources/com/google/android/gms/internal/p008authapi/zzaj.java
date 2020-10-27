package com.google.android.gms.internal.p008authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzaj */
final class zzaj extends zzaa {
    private final /* synthetic */ TaskCompletionSource zzbk;

    zzaj(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zzbk = taskCompletionSource;
    }

    public final void zzc(Status status, BeginSignInResult beginSignInResult) throws RemoteException {
        TaskUtil.setResultOrApiException(status, beginSignInResult, this.zzbk);
    }
}
