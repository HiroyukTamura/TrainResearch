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

public final class zzk extends zzed implements zzj
{
    zzk(final IBinder binder) {
        super(binder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }
    
    @Override
    public final int zza(final IObjectWrapper objectWrapper, final String s, final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)objectWrapper);
        zzZ.writeString(s);
        zzef.zza(zzZ, b);
        final Parcel zza = this.zza(3, zzZ);
        final int int1 = zza.readInt();
        zza.recycle();
        return int1;
    }
    
    @Override
    public final IObjectWrapper zza(final IObjectWrapper objectWrapper, final String s, final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)objectWrapper);
        zzZ.writeString(s);
        zzZ.writeInt(n);
        final Parcel zza = this.zza(2, zzZ);
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
}
