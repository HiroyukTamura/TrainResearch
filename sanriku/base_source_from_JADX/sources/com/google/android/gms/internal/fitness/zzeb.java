package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.fitness.request.zzas;

final class zzeb extends zzav {
    private final /* synthetic */ PendingIntent zznk;
    private final /* synthetic */ zzu zznx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzdw zzdw, GoogleApiClient googleApiClient, zzu zzu, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zznx = zzu;
        this.zznk = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcb) ((zzao) anyClient).getService()).zza(new zzas(this.zznx, this.zznk, (zzcm) new zzel(this)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final Status createFailedResult(Status status) {
        return status;
    }
}
