// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.ArrayList;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Parcel;

public class zzef
{
    private static final ClassLoader zzrF;
    
    static {
        zzrF = zzef.class.getClassLoader();
    }
    
    private zzef() {
    }
    
    public static <T extends Parcelable> T zza(final Parcel parcel, final Parcelable$Creator<T> parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (T)parcelable$Creator.createFromParcel(parcel);
    }
    
    public static void zza(final Parcel parcel, final IInterface interface1) {
        if (interface1 == null) {
            parcel.writeStrongBinder((IBinder)null);
            return;
        }
        parcel.writeStrongBinder(interface1.asBinder());
    }
    
    public static void zza(final Parcel parcel, final Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
    
    public static void zza(final Parcel parcel, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        parcel.writeInt(n);
    }
    
    public static boolean zza(final Parcel parcel) {
        return parcel.readInt() == 1;
    }
    
    public static ArrayList zzb(final Parcel parcel) {
        return parcel.readArrayList(zzef.zzrF);
    }
    
    public static void zzb(final Parcel parcel, final Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }
    
    public static HashMap zzc(final Parcel parcel) {
        return parcel.readHashMap(zzef.zzrF);
    }
}
