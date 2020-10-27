package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzann extends zzgk implements zzank {
    public zzann() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzty();
        } else if (i != 3) {
            return false;
        } else {
            zzdo(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
