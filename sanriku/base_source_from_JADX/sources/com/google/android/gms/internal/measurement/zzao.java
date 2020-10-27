package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

final class zzao extends zzag.zzb {
    private final /* synthetic */ zzag zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzag zzag) {
        super(zzag);
        this.zzc = zzag;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzm.resetAnalyticsData(this.zza);
    }
}
