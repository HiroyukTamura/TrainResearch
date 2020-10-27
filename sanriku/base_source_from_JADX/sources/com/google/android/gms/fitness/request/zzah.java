package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzb;
import com.google.android.gms.internal.fitness.zzd;

public final class zzah extends zzb implements zzaf {
    zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.request.IBleScanCallback");
    }

    public final void onDeviceFound(BleDevice bleDevice) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) bleDevice);
        zzb(1, zza);
    }

    public final void onScanStopped() throws RemoteException {
        zzb(2, zza());
    }
}
