package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzahs extends zzgk implements zzaht {
    public zzahs() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzsp();
        } else if (i != 2) {
            return false;
        } else {
            zzcw(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
