package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzvc extends zzvg<zzwp> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzuu zzcfq;

    zzvc(zzuu zzuu, Context context) {
        this.zzcfq = zzuu;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.val$context), 201004000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, "mobile_ads_settings");
        return new zzyo();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcfh.zzh(this.val$context);
    }
}
