package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;

final class zzee extends zzaz<SessionReadResult> {
    private final /* synthetic */ SessionReadRequest zzob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzee(zzea zzea, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        super(googleApiClient);
        this.zzob = sessionReadRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return SessionReadResult.zze(status);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new SessionReadRequest(this.zzob, (zzcg) new zzej(this, (zzed) null)));
    }
}
