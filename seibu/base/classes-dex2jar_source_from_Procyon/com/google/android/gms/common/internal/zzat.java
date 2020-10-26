// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzat extends zzed implements zzar
{
    zzat(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.ICertData");
    }
    
    @Override
    public final IObjectWrapper zzoY() throws RemoteException {
        final Parcel zza = this.zza(1, this.zzZ());
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
    
    @Override
    public final int zzoZ() throws RemoteException {
        final Parcel zza = this.zza(2, this.zzZ());
        final int int1 = zza.readInt();
        zza.recycle();
        return int1;
    }
}
