// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzceh extends zza
{
    public static final Parcelable$Creator<zzceh> CREATOR;
    public final String packageName;
    public final String zzbgW;
    public final String zzboQ;
    public final String zzboR;
    public final long zzboS;
    public final long zzboT;
    public final String zzboU;
    public final boolean zzboV;
    public final boolean zzboW;
    public final long zzboX;
    public final String zzboY;
    public final long zzboZ;
    public final long zzbpa;
    public final int zzbpb;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcei();
    }
    
    zzceh(String s, final String s2, final String zzbgW, final long zzboX, final String zzboR, final long zzboS, final long zzboT, final String zzboU, final boolean zzboV, final boolean zzboW, final String zzboY, final long zzboZ, final long zzbpa, final int zzbpb) {
        zzbo.zzcF(s);
        this.packageName = s;
        s = s2;
        if (TextUtils.isEmpty((CharSequence)s2)) {
            s = null;
        }
        this.zzboQ = s;
        this.zzbgW = zzbgW;
        this.zzboX = zzboX;
        this.zzboR = zzboR;
        this.zzboS = zzboS;
        this.zzboT = zzboT;
        this.zzboU = zzboU;
        this.zzboV = zzboV;
        this.zzboW = zzboW;
        this.zzboY = zzboY;
        this.zzboZ = zzboZ;
        this.zzbpa = zzbpa;
        this.zzbpb = zzbpb;
    }
    
    zzceh(final String packageName, final String zzboQ, final String zzbgW, final String zzboR, final long zzboS, final long zzboT, final String zzboU, final boolean zzboV, final boolean zzboW, final long zzboX, final String zzboY, final long zzboZ, final long zzbpa, final int zzbpb) {
        this.packageName = packageName;
        this.zzboQ = zzboQ;
        this.zzbgW = zzbgW;
        this.zzboX = zzboX;
        this.zzboR = zzboR;
        this.zzboS = zzboS;
        this.zzboT = zzboT;
        this.zzboU = zzboU;
        this.zzboV = zzboV;
        this.zzboW = zzboW;
        this.zzboY = zzboY;
        this.zzboZ = zzboZ;
        this.zzbpa = zzbpa;
        this.zzbpb = zzbpb;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.packageName, false);
        zzd.zza(parcel, 3, this.zzboQ, false);
        zzd.zza(parcel, 4, this.zzbgW, false);
        zzd.zza(parcel, 5, this.zzboR, false);
        zzd.zza(parcel, 6, this.zzboS);
        zzd.zza(parcel, 7, this.zzboT);
        zzd.zza(parcel, 8, this.zzboU, false);
        zzd.zza(parcel, 9, this.zzboV);
        zzd.zza(parcel, 10, this.zzboW);
        zzd.zza(parcel, 11, this.zzboX);
        zzd.zza(parcel, 12, this.zzboY, false);
        zzd.zza(parcel, 13, this.zzboZ);
        zzd.zza(parcel, 14, this.zzbpa);
        zzd.zzc(parcel, 15, this.zzbpb);
        zzd.zzI(parcel, zze);
    }
}
