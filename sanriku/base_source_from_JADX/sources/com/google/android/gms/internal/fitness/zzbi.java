package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzbi extends zzb implements zzbg {
    zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }

    public final void zza(DataSourcesResult dataSourcesResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataSourcesResult);
        zzb(1, zza);
    }
}
