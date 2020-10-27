package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzbo;

final class zzdv extends zzap {
    private final /* synthetic */ DataType zznm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdv(zzdr zzdr, GoogleApiClient googleApiClient, DataType dataType) {
        super(googleApiClient);
        this.zznm = dataType;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) ((zzai) anyClient).getService()).zza(new zzbo(this.zznm, (DataSource) null, (zzcm) new zzel(this)));
    }
}
