package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzbc;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.Collections;

final class zzec extends zzaz<SessionStopResult> {
    private final /* synthetic */ String zzny = null;
    private final /* synthetic */ String zznz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzea zzea, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.zznz = str2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzbc(this.zzny, this.zznz, (zzcl) new zzei(this, (zzed) null)));
    }
}
