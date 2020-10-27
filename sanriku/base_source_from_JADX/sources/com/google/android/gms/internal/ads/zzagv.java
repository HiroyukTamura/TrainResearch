package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzagv extends zzgi implements zzags {
    zzagv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zza(zzagm zzagm, zzagq zzagq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzagm);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzagq);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
