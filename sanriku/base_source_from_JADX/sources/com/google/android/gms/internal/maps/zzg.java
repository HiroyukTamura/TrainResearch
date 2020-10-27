package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    public final IObjectWrapper zza(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        return C0681a.m306a(zza(5, zza));
    }

    public final IObjectWrapper zza(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        return C0681a.m306a(zza(1, zza));
    }

    public final IObjectWrapper zza(Bitmap bitmap) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) bitmap);
        return C0681a.m306a(zza(6, zza));
    }

    public final IObjectWrapper zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return C0681a.m306a(zza(2, zza));
    }

    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return C0681a.m306a(zza(3, zza));
    }

    public final IObjectWrapper zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return C0681a.m306a(zza(7, zza));
    }

    public final IObjectWrapper zzi() throws RemoteException {
        return C0681a.m306a(zza(4, zza()));
    }
}
