package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.request.zzas;

public final class zzca extends zzb implements zzcb {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
    }

    public final void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataSourcesRequest);
        zza(1, zza);
    }

    public final void zza(zzao zzao) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzao);
        zza(2, zza);
    }

    public final void zza(zzas zzas) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzas);
        zza(3, zza);
    }
}
