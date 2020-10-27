package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcqx extends zzant {
    private zzcnl<zzanv, zzcot> zzgey;

    private zzcqx(zzcqv zzcqv, zzcnl<zzanv, zzcot> zzcnl) {
        this.zzgey = zzcnl;
    }

    public final void zzdo(String str) throws RemoteException {
        ((zzcot) this.zzgey.zzgel).zzc(0, str);
    }

    public final void zzty() throws RemoteException {
        ((zzcot) this.zzgey.zzgel).onAdLoaded();
    }
}
