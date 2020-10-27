package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public abstract class zzbj extends zza implements zzbg {
    public zzbj() {
        super("com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }

    public static zzbg zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
        return queryLocalInterface instanceof zzbg ? (zzbg) queryLocalInterface : new zzbi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((DataSourcesResult) zzd.zza(parcel, DataSourcesResult.CREATOR));
        return true;
    }
}
