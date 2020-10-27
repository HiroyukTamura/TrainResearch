package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzvf extends zzvg<zzacw> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzuu zzcfq;
    private final /* synthetic */ FrameLayout zzcfv;
    private final /* synthetic */ FrameLayout zzcfw;

    zzvf(zzuu zzuu, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcfq = zzuu;
        this.zzcfv = frameLayout;
        this.zzcfw = frameLayout2;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.zzcfv), ObjectWrapper.wrap(this.zzcfw));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, "native_ad_view_delegate");
        return new zzyq();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcfi.zzb(this.val$context, this.zzcfv, this.zzcfw);
    }
}
