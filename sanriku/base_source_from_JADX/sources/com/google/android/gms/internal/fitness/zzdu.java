package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzbo;

final class zzdu extends zzap {
    private final /* synthetic */ DataSource zznt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdu(zzdr zzdr, GoogleApiClient googleApiClient, DataSource dataSource) {
        super(googleApiClient);
        this.zznt = dataSource;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbz) ((zzai) anyClient).getService()).zza(new zzbo((DataType) null, this.zznt, (zzcm) new zzel(this)));
    }
}
