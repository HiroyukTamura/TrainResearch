package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzbk;

final class zzds extends zzap {
    private final /* synthetic */ Subscription zzns;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzds(zzdr zzdr, GoogleApiClient googleApiClient, Subscription subscription) {
        super(googleApiClient);
        this.zzns = subscription;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) ((zzai) anyClient).getService()).zza(new zzbk(this.zzns, false, (zzcm) new zzel(this)));
    }
}
