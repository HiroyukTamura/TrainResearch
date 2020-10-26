// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;

public final class zzbga extends zzed implements zzbfz
{
    zzbga(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.service.ICommonService");
    }
    
    @Override
    public final void zza(final zzbfx zzbfx) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)zzbfx);
        this.zzc(1, zzZ);
    }
}
