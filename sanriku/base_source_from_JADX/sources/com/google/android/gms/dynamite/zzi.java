package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzi extends zzb implements zzj {
    zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(3, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        return C0681a.m306a(zza(2, zza));
    }

    public final int zzak() throws RemoteException {
        Parcel zza = zza(6, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(5, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        return C0681a.m306a(zza(4, zza));
    }
}
