package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzvh extends zzvg<zzask> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzalp zzcfp;
    private final /* synthetic */ zzuu zzcfq;

    zzvh(zzuu zzuu, Context context, zzalp zzalp) {
        this.zzcfq = zzuu;
        this.val$context = context;
        this.zzcfp = zzalp;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.val$context), this.zzcfp, 201004000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, "rewarded_video");
        return new zzyu();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcfj.zza(this.val$context, this.zzcfp);
    }
}
