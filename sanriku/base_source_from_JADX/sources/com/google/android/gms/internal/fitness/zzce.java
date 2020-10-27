package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public abstract class zzce extends zza implements zzcf {
    public zzce() {
        super("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
    }

    public static zzcf zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        return queryLocalInterface instanceof zzcf ? (zzcf) queryLocalInterface : new zzch(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((ListSubscriptionsResult) zzd.zza(parcel, ListSubscriptionsResult.CREATOR));
        return true;
    }
}
