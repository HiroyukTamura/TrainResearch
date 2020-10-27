package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public abstract class zzeo extends zza implements zzep {
    public zzeo() {
        super("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
    }

    public static zzep zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        return queryLocalInterface instanceof zzep ? (zzep) queryLocalInterface : new zzer(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((BleDevicesResult) zzd.zza(parcel, BleDevicesResult.CREATOR));
        return true;
    }
}
