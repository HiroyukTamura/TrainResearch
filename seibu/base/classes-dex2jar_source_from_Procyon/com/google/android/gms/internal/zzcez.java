// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzcez extends zza
{
    public static final Parcelable$Creator<zzcez> CREATOR;
    public final String name;
    public final zzcew zzbpM;
    public final long zzbpN;
    public final String zzbpc;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcfa();
    }
    
    zzcez(final zzcez zzcez, final long zzbpN) {
        zzbo.zzu(zzcez);
        this.name = zzcez.name;
        this.zzbpM = zzcez.zzbpM;
        this.zzbpc = zzcez.zzbpc;
        this.zzbpN = zzbpN;
    }
    
    public zzcez(final String name, final zzcew zzbpM, final String zzbpc, final long zzbpN) {
        this.name = name;
        this.zzbpM = zzbpM;
        this.zzbpc = zzbpc;
        this.zzbpN = zzbpN;
    }
    
    @Override
    public final String toString() {
        final String zzbpc = this.zzbpc;
        final String name = this.name;
        final String value = String.valueOf(this.zzbpM);
        return new StringBuilder(String.valueOf(zzbpc).length() + 21 + String.valueOf(name).length() + String.valueOf(value).length()).append("origin=").append(zzbpc).append(",name=").append(name).append(",params=").append(value).toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.name, false);
        zzd.zza(parcel, 3, (Parcelable)this.zzbpM, n, false);
        zzd.zza(parcel, 4, this.zzbpc, false);
        zzd.zza(parcel, 5, this.zzbpN);
        zzd.zzI(parcel, zze);
    }
}
