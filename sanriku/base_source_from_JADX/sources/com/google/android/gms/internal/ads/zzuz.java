package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzuz extends zzvg<zzapg> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzuu zzcfq;

    zzuz(zzuu zzuu, Activity activity) {
        this.zzcfq = zzuu;
        this.val$activity = activity;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zzb(ObjectWrapper.wrap(this.val$activity));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$activity, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcfl.zzc(this.val$activity);
    }
}
