package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzt;
import com.google.android.gms.fitness.result.DataTypeResult;

final class zzdb extends zzu<DataTypeResult> {
    private final /* synthetic */ String zznd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdb(zzcz zzcz, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zznd = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return DataTypeResult.zzc(status);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbt) ((zzt) anyClient).getService()).zza(new zzt(this.zznd, (zzbl) new zzdd(this, (zzcy) null)));
    }
}
