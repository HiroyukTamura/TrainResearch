package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzvd extends zzvg<zzvs> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcfo;
    private final /* synthetic */ zzalp zzcfp;
    private final /* synthetic */ zzuu zzcfq;

    zzvd(zzuu zzuu, Context context, String str, zzalp zzalp) {
        this.zzcfq = zzuu;
        this.val$context = context;
        this.zzcfo = str;
        this.zzcfp = zzalp;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.val$context), this.zzcfo, this.zzcfp, 201004000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, "native_ad");
        return new zzyi();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcfg.zza(this.val$context, this.zzcfo, this.zzcfp);
    }
}
