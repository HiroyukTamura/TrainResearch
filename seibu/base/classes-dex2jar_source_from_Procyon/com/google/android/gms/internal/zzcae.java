// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;

public final class zzcae extends zzed implements zzcac
{
    zzcae(final IBinder binder) {
        super(binder, "com.google.android.gms.flags.IFlagProvider");
    }
    
    @Override
    public final boolean getBooleanFlagValue(final String s, final boolean b, final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzef.zza(zzZ, b);
        zzZ.writeInt(n);
        final Parcel zza = this.zza(2, zzZ);
        final boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
    
    @Override
    public final int getIntFlagValue(final String s, int int1, final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeInt(int1);
        zzZ.writeInt(n);
        final Parcel zza = this.zza(3, zzZ);
        int1 = zza.readInt();
        zza.recycle();
        return int1;
    }
    
    @Override
    public final long getLongFlagValue(final String s, long long1, final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeLong(long1);
        zzZ.writeInt(n);
        final Parcel zza = this.zza(4, zzZ);
        long1 = zza.readLong();
        zza.recycle();
        return long1;
    }
    
    @Override
    public final String getStringFlagValue(final String s, String string, final int n) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeString(string);
        zzZ.writeInt(n);
        final Parcel zza = this.zza(5, zzZ);
        string = zza.readString();
        zza.recycle();
        return string;
    }
    
    @Override
    public final void init(final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (IInterface)objectWrapper);
        this.zzb(1, zzZ);
    }
}
