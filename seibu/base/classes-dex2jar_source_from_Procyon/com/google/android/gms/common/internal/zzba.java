// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.Parcelable;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.common.zzm;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzba extends zzed implements zzay
{
    zzba(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }
    
    @Override
    public final boolean zza(final zzm zzm, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzm);
        zzef.zza(zzZ, (IInterface)objectWrapper);
        final Parcel zza = this.zza(5, zzZ);
        final boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
    
    @Override
    public final boolean zze(final String s, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzef.zza(zzZ, (IInterface)objectWrapper);
        final Parcel zza = this.zza(3, zzZ);
        final boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
    
    @Override
    public final boolean zzf(final String s, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzef.zza(zzZ, (IInterface)objectWrapper);
        final Parcel zza = this.zza(4, zzZ);
        final boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
    
    @Override
    public final IObjectWrapper zzrF() throws RemoteException {
        final Parcel zza = this.zza(1, this.zzZ());
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
    
    @Override
    public final IObjectWrapper zzrG() throws RemoteException {
        final Parcel zza = this.zza(2, this.zzZ());
        final IObjectWrapper zzM = IObjectWrapper.zza.zzM(zza.readStrongBinder());
        zza.recycle();
        return zzM;
    }
}
