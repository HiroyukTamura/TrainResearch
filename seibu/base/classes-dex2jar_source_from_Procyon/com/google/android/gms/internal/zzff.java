// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;

public final class zzff extends zzed implements zzfd
{
    zzff(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }
    
    @Override
    public final String getId() throws RemoteException {
        final Parcel zza = this.zza(1, this.zzZ());
        final String string = zza.readString();
        zza.recycle();
        return string;
    }
    
    @Override
    public final boolean zzb(final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, b);
        final Parcel zza = this.zza(2, zzZ);
        final boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
    
    @Override
    public final void zzc(final String s, final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzef.zza(zzZ, b);
        this.zzb(4, zzZ);
    }
    
    @Override
    public final String zzq(final String s) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        final Parcel zza = this.zza(3, zzZ);
        final String string = zza.readString();
        zza.recycle();
        return string;
    }
}
