// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzbc extends zzed implements zzbb
{
    zzbc(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }
    
    @Override
    public final IObjectWrapper zza(final IObjectWrapper objectWrapper, final zzbt zzbt) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)objectWrapper);
        zzef.zza(zzZ, (Parcelable)zzbt);
        final Parcel zza = this.zza(2, zzZ);
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
}
