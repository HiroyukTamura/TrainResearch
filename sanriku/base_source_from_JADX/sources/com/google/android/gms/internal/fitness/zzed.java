package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.zzba;

final class zzed extends zzbb {
    private final /* synthetic */ Session zzoa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzea zzea, GoogleApiClient googleApiClient, Session session) {
        super(googleApiClient);
        this.zzoa = session;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzba(this.zzoa, (zzcm) new zzel(this)));
    }
}
