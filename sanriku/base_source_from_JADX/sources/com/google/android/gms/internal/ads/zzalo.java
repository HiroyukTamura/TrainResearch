package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzalo extends zzgk implements zzalp {
    public zzalo() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzalp zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzalp ? (zzalp) queryLocalInterface : new zzalr(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface iInterface;
        if (i == 1) {
            iInterface = zzdg(parcel.readString());
        } else if (i == 2) {
            boolean zzdh = zzdh(parcel.readString());
            parcel2.writeNoException();
            zzgj.writeBoolean(parcel2, zzdh);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            iInterface = zzdk(parcel.readString());
        }
        parcel2.writeNoException();
        zzgj.zza(parcel2, iInterface);
        return true;
    }
}
