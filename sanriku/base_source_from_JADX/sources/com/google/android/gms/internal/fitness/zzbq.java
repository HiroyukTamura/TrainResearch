package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzag;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.fitness.request.zzbm;
import com.google.android.gms.fitness.request.zzf;

public final class zzbq extends zzb implements zzbr {
    zzbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitBleApi");
    }

    public final void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) startBleScanRequest);
        zza(1, zza);
    }

    public final void zza(zzag zzag) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzag);
        zza(5, zza);
    }

    public final void zza(zzbi zzbi) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbi);
        zza(2, zza);
    }

    public final void zza(zzbm zzbm) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbm);
        zza(4, zza);
    }

    public final void zza(zzf zzf) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzf);
        zza(3, zza);
    }
}
