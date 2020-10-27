package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcpw extends zzano {
    private zzcnl<zzanv, zzcot> zzgey;
    private final /* synthetic */ zzcpu zzggg;

    private zzcpw(zzcpu zzcpu, zzcnl<zzanv, zzcot> zzcnl) {
        this.zzggg = zzcpu;
        this.zzgey = zzcnl;
    }

    public final void zza(zzame zzame) throws RemoteException {
        zzame unused = this.zzggg.zzggf = zzame;
        ((zzcot) this.zzgey.zzgel).onAdLoaded();
    }

    public final void zzdo(String str) throws RemoteException {
        ((zzcot) this.zzgey.zzgel).zzc(0, str);
    }
}
