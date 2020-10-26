// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import android.content.Intent;

public final class zze
{
    public static <T extends SafeParcelable> T zza(final Intent intent, final String s, final Parcelable$Creator<T> parcelable$Creator) {
        final byte[] byteArrayExtra = intent.getByteArrayExtra(s);
        if (byteArrayExtra == null) {
            return null;
        }
        return zza(byteArrayExtra, parcelable$Creator);
    }
    
    public static <T extends SafeParcelable> T zza(final byte[] array, final Parcelable$Creator<T> parcelable$Creator) {
        zzbo.zzu(parcelable$Creator);
        final Parcel obtain = Parcel.obtain();
        obtain.unmarshall(array, 0, array.length);
        obtain.setDataPosition(0);
        final SafeParcelable safeParcelable = (SafeParcelable)parcelable$Creator.createFromParcel(obtain);
        obtain.recycle();
        return (T)safeParcelable;
    }
    
    public static <T extends SafeParcelable> void zza(final T t, final Intent intent, final String s) {
        intent.putExtra(s, zza(t));
    }
    
    public static <T extends SafeParcelable> byte[] zza(final T t) {
        final Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
