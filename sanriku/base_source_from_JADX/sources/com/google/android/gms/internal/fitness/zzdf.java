package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;
import java.util.Collections;

final class zzdf extends zzaa<GoalsResult> {
    private final /* synthetic */ GoalsReadRequest zznf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzdc zzdc, GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
        super(googleApiClient);
        this.zznf = goalsReadRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoalsResult(status, Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbv) ((zzz) anyClient).getService()).zza(new GoalsReadRequest(this.zznf, (zzbm) new zzde(this)));
    }
}
