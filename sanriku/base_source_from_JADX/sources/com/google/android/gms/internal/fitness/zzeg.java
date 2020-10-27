package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzbe;

final class zzeg extends zzbb {
    private final /* synthetic */ PendingIntent zznv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeg(zzea zzea, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zznv = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzau) anyClient).getService()).zza(new zzbe(this.zznv, (zzcm) new zzel(this)));
    }
}
