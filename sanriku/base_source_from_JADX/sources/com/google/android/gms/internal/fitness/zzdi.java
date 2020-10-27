package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataUpdateRequest;

final class zzdi extends zzaj {
    private final /* synthetic */ DataUpdateRequest zzni;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdi(zzdh zzdh, GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest) {
        super(googleApiClient);
        this.zzni = dataUpdateRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new DataUpdateRequest(this.zzni, (IBinder) new zzel(this)));
    }
}
