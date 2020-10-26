// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.List;
import android.os.IBinder;

public final class zzcff extends zzed implements zzcfd
{
    zzcff(final IBinder binder) {
        super(binder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }
    
    @Override
    public final List<zzcji> zza(final zzceh zzceh, final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzceh);
        zzef.zza(zzZ, b);
        final Parcel zza = this.zza(7, zzZ);
        final ArrayList typedArrayList = zza.createTypedArrayList((Parcelable$Creator)zzcji.CREATOR);
        zza.recycle();
        return (List<zzcji>)typedArrayList;
    }
    
    @Override
    public final List<zzcek> zza(final String s, final String s2, final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeString(s2);
        zzef.zza(zzZ, (Parcelable)zzceh);
        final Parcel zza = this.zza(16, zzZ);
        final ArrayList typedArrayList = zza.createTypedArrayList((Parcelable$Creator)zzcek.CREATOR);
        zza.recycle();
        return (List<zzcek>)typedArrayList;
    }
    
    @Override
    public final List<zzcji> zza(final String s, final String s2, final String s3, final boolean b) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeString(s2);
        zzZ.writeString(s3);
        zzef.zza(zzZ, b);
        final Parcel zza = this.zza(15, zzZ);
        final ArrayList typedArrayList = zza.createTypedArrayList((Parcelable$Creator)zzcji.CREATOR);
        zza.recycle();
        return (List<zzcji>)typedArrayList;
    }
    
    @Override
    public final List<zzcji> zza(final String s, final String s2, final boolean b, final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeString(s2);
        zzef.zza(zzZ, b);
        zzef.zza(zzZ, (Parcelable)zzceh);
        final Parcel zza = this.zza(14, zzZ);
        final ArrayList typedArrayList = zza.createTypedArrayList((Parcelable$Creator)zzcji.CREATOR);
        zza.recycle();
        return (List<zzcji>)typedArrayList;
    }
    
    @Override
    public final void zza(final long n, final String s, final String s2, final String s3) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeLong(n);
        zzZ.writeString(s);
        zzZ.writeString(s2);
        zzZ.writeString(s3);
        this.zzb(10, zzZ);
    }
    
    @Override
    public final void zza(final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzceh);
        this.zzb(4, zzZ);
    }
    
    @Override
    public final void zza(final zzcek zzcek, final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcek);
        zzef.zza(zzZ, (Parcelable)zzceh);
        this.zzb(12, zzZ);
    }
    
    @Override
    public final void zza(final zzcez zzcez, final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcez);
        zzef.zza(zzZ, (Parcelable)zzceh);
        this.zzb(1, zzZ);
    }
    
    @Override
    public final void zza(final zzcez zzcez, final String s, final String s2) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcez);
        zzZ.writeString(s);
        zzZ.writeString(s2);
        this.zzb(5, zzZ);
    }
    
    @Override
    public final void zza(final zzcji zzcji, final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcji);
        zzef.zza(zzZ, (Parcelable)zzceh);
        this.zzb(2, zzZ);
    }
    
    @Override
    public final byte[] zza(final zzcez zzcez, final String s) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcez);
        zzZ.writeString(s);
        final Parcel zza = this.zza(9, zzZ);
        final byte[] byteArray = zza.createByteArray();
        zza.recycle();
        return byteArray;
    }
    
    @Override
    public final void zzb(final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzceh);
        this.zzb(6, zzZ);
    }
    
    @Override
    public final void zzb(final zzcek zzcek) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzcek);
        this.zzb(13, zzZ);
    }
    
    @Override
    public final String zzc(final zzceh zzceh) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)zzceh);
        final Parcel zza = this.zza(11, zzZ);
        final String string = zza.readString();
        zza.recycle();
        return string;
    }
    
    @Override
    public final List<zzcek> zzk(final String s, final String s2, final String s3) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeString(s);
        zzZ.writeString(s2);
        zzZ.writeString(s3);
        final Parcel zza = this.zza(17, zzZ);
        final ArrayList typedArrayList = zza.createTypedArrayList((Parcelable$Creator)zzcek.CREATOR);
        zza.recycle();
        return (List<zzcek>)typedArrayList;
    }
}
