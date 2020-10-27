package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzwz extends zzgk implements zzww {
    public zzwz() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzww zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return queryLocalInterface instanceof zzww ? (zzww) queryLocalInterface : new zzwy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str;
        if (i == 1) {
            str = getDescription();
        } else if (i != 2) {
            return false;
        } else {
            str = zzqe();
        }
        parcel2.writeNoException();
        parcel2.writeString(str);
        return true;
    }
}
