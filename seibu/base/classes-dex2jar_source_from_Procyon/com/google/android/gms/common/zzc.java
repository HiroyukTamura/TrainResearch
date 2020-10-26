// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzc extends zza
{
    public static final Parcelable$Creator<zzc> CREATOR;
    private String name;
    private int version;
    
    static {
        CREATOR = (Parcelable$Creator)new zzd();
    }
    
    public zzc(final String name, final int version) {
        this.name = name;
        this.version = version;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 1, this.name, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.version);
        com.google.android.gms.common.internal.safeparcel.zzd.zzI(parcel, zze);
    }
}
