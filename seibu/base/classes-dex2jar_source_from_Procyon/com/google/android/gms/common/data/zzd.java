// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T>
{
    private static final String[] zzaFz;
    private final Parcelable$Creator<T> zzaFA;
    
    static {
        zzaFz = new String[] { "data" };
    }
    
    public zzd(final DataHolder dataHolder, final Parcelable$Creator<T> zzaFA) {
        super(dataHolder);
        this.zzaFA = zzaFA;
    }
    
    public static <T extends SafeParcelable> void zza(final DataHolder.zza zza, final T t) {
        final Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        final ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        zza.zza(contentValues);
        obtain.recycle();
    }
    
    public static DataHolder.zza zzqQ() {
        return DataHolder.zza(zzd.zzaFz);
    }
    
    public T zzas(final int n) {
        final byte[] zzg = this.zzaCX.zzg("data", n, this.zzaCX.zzat(n));
        final Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        final SafeParcelable safeParcelable = (SafeParcelable)this.zzaFA.createFromParcel(obtain);
        obtain.recycle();
        return (T)safeParcelable;
    }
}
