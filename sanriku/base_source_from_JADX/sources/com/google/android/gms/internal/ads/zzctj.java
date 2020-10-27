package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

public final class zzctj extends zzvq {
    private final zzctt zzgjm;

    public zzctj(Context context, zzbgy zzbgy, zzdhg zzdhg, zzcae zzcae, zzvm zzvm) {
        zzctv zzctv = new zzctv(zzcae);
        zzctv.zzc(zzvm);
        this.zzgjm = new zzctt(new zzcub(zzbgy, context, zzctv, zzdhg), zzdhg.zzasa());
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzgjm.getMediationAdapterClassName();
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgjm.isLoading();
    }

    public final synchronized void zza(zzuj zzuj, int i) throws RemoteException {
        this.zzgjm.zza(zzuj, i);
    }

    public final void zzb(zzuj zzuj) throws RemoteException {
        this.zzgjm.zza(zzuj, 1);
    }

    public final synchronized String zzkh() {
        return this.zzgjm.zzkh();
    }
}
