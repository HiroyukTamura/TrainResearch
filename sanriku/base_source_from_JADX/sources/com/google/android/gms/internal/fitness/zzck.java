package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public abstract class zzck extends zza implements zzcl {
    public zzck() {
        super("com.google.android.gms.fitness.internal.ISessionStopCallback");
    }

    public static zzcl zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
        return queryLocalInterface instanceof zzcl ? (zzcl) queryLocalInterface : new zzcn(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((SessionStopResult) zzd.zza(parcel, SessionStopResult.CREATOR));
        return true;
    }
}
