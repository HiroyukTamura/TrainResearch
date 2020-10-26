// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamite;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzm extends zzed implements zzl
{
    zzm(final IBinder binder) {
        super(binder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }
    
    @Override
    public final IObjectWrapper zza(final IObjectWrapper objectWrapper, final String s, final int n, final IObjectWrapper objectWrapper2) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)objectWrapper);
        zzZ.writeString(s);
        zzZ.writeInt(n);
        zzef.zza(zzZ, (IInterface)objectWrapper2);
        final Parcel zza = this.zza(2, zzZ);
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
}
