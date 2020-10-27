package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzbm;

final class zzcu extends zzq {
    private final /* synthetic */ String zzna;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcu(zzcr zzcr, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzna = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbr) ((zzn) anyClient).getService()).zza(new zzbm(this.zzna, (zzcm) new zzel(this)));
    }
}
