package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzux extends zzvg<zzvz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcfo;
    private final /* synthetic */ zzalp zzcfp;
    private final /* synthetic */ zzuu zzcfq;
    private final /* synthetic */ zzum zzcfr;

    zzux(zzuu zzuu, Context context, zzum zzum, String str, zzalp zzalp) {
        this.zzcfq = zzuu;
        this.val$context = context;
        this.zzcfr = zzum;
        this.zzcfo = str;
        this.zzcfp = zzalp;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.val$context), this.zzcfr, this.zzcfo, this.zzcfp, 201004000);
    }

    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, "banner");
        return new zzym();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcff.zza(this.val$context, this.zzcfr, this.zzcfo, this.zzcfp, 1);
    }
}
