package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzaf;

final class zzcq extends zzq {
    private final /* synthetic */ StartBleScanRequest zzmy;
    private final /* synthetic */ zzaf zzmz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcq(zzcr zzcr, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest, zzaf zzaf) {
        super(googleApiClient);
        this.zzmy = startBleScanRequest;
        this.zzmz = zzaf;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbr) ((zzn) anyClient).getService()).zza(new StartBleScanRequest(this.zzmy.getDataTypes(), this.zzmz, this.zzmy.getTimeoutSecs(), (zzcm) new zzel(this)));
    }
}
