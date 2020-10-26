// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgc extends zza
{
    public static final Parcelable$Creator<zzbgc> CREATOR;
    private final zzbge zzaIB;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgd();
    }
    
    zzbgc(final int zzaku, final zzbge zzaIB) {
        this.zzaku = zzaku;
        this.zzaIB = zzaIB;
    }
    
    private zzbgc(final zzbge zzaIB) {
        this.zzaku = 1;
        this.zzaIB = zzaIB;
    }
    
    public static zzbgc zza(final zzbgk<?, ?> zzbgk) {
        if (zzbgk instanceof zzbge) {
            return new zzbgc((zzbge)zzbgk);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, (Parcelable)this.zzaIB, n, false);
        zzd.zzI(parcel, zze);
    }
    
    public final zzbgk<?, ?> zzrK() {
        if (this.zzaIB != null) {
            return this.zzaIB;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
