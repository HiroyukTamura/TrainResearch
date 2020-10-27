package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzxe extends zzgk implements zzxf {
    public zzxe() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzxf zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return queryLocalInterface instanceof zzxf ? (zzxf) queryLocalInterface : new zzxh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((zzuo) zzgj.zza(parcel, zzuo.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
