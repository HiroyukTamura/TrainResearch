package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzxj extends zzgk implements zzxg {
    public zzxj() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzxg zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return queryLocalInterface instanceof zzxg ? (zzxg) queryLocalInterface : new zzxi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str;
        if (i == 1) {
            str = getMediationAdapterClassName();
        } else if (i != 2) {
            return false;
        } else {
            str = getResponseId();
        }
        parcel2.writeNoException();
        parcel2.writeString(str);
        return true;
    }
}
