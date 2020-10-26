// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgq extends zza
{
    public static final Parcelable$Creator<zzbgq> CREATOR;
    final String key;
    private int versionCode;
    final zzbgj<?, ?> zzaIV;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgn();
    }
    
    zzbgq(final int versionCode, final String key, final zzbgj<?, ?> zzaIV) {
        this.versionCode = versionCode;
        this.key = key;
        this.zzaIV = zzaIV;
    }
    
    zzbgq(final String key, final zzbgj<?, ?> zzaIV) {
        this.versionCode = 1;
        this.key = key;
        this.zzaIV = zzaIV;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.key, false);
        zzd.zza(parcel, 3, (Parcelable)this.zzaIV, n, false);
        zzd.zzI(parcel, zze);
    }
}
