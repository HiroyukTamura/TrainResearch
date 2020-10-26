// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgf extends zza
{
    public static final Parcelable$Creator<zzbgf> CREATOR;
    private int versionCode;
    final String zzaIF;
    final int zzaIG;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgh();
    }
    
    zzbgf(final int versionCode, final String zzaIF, final int zzaIG) {
        this.versionCode = versionCode;
        this.zzaIF = zzaIF;
        this.zzaIG = zzaIG;
    }
    
    zzbgf(final String zzaIF, final int zzaIG) {
        this.versionCode = 1;
        this.zzaIF = zzaIF;
        this.zzaIG = zzaIG;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.zzaIF, false);
        zzd.zzc(parcel, 3, this.zzaIG);
        zzd.zzI(parcel, zze);
    }
}
