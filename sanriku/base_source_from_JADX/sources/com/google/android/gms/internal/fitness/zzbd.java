package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public abstract class zzbd extends zza implements zzba {
    public zzbd() {
        super("com.google.android.gms.fitness.internal.IDailyTotalCallback");
    }

    public static zzba zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
        return queryLocalInterface instanceof zzba ? (zzba) queryLocalInterface : new zzbc(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((DailyTotalResult) zzd.zza(parcel, DailyTotalResult.CREATOR));
        return true;
    }
}
