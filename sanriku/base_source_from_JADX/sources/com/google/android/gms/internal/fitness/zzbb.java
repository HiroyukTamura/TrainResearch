package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

abstract class zzbb extends zzaz<Status> {
    zzbb(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Result createFailedResult(Status status) {
        Preconditions.checkArgument(!status.isSuccess());
        return status;
    }
}
