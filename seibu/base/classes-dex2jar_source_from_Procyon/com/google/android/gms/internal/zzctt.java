// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzal;
import android.os.IBinder;

public final class zzctt extends zzed implements zzcts
{
    zzctt(final IBinder binder) {
        super(binder, "com.google.android.gms.signin.internal.ISignInService");
    }
    
    @Override
    public final void zza(final zzal zzal, final int n, final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)zzal);
        zzZ.writeInt(n);
        zzef.zza(zzZ, b);
        this.zzb(9, zzZ);
    }
    
    @Override
    public final void zza(final zzctv zzctv, final zzctq zzctq) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzctv);
        zzef.zza(zzZ, (IInterface)zzctq);
        this.zzb(12, zzZ);
    }
    
    @Override
    public final void zzbv(final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeInt(n);
        this.zzb(7, zzZ);
    }
}
