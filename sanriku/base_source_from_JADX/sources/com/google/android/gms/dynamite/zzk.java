package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzk extends zzb implements zzl {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        zzd.zza(zza, (IInterface) iObjectWrapper2);
        return C0681a.m306a(zza(2, zza));
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        zzd.zza(zza, (IInterface) iObjectWrapper2);
        return C0681a.m306a(zza(3, zza));
    }
}
