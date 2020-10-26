// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzcji extends zza
{
    public static final Parcelable$Creator<zzcji> CREATOR;
    public final String name;
    private int versionCode;
    private String zzaIF;
    public final String zzbpc;
    private Float zzbuA;
    private Double zzbuB;
    public final long zzbuy;
    private Long zzbuz;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcjj();
    }
    
    zzcji(final int versionCode, final String name, final long zzbuy, final Long zzbuz, final Float n, final String zzaIF, final String zzbpc, final Double zzbuB) {
        final Double n2 = null;
        this.versionCode = versionCode;
        this.name = name;
        this.zzbuy = zzbuy;
        this.zzbuz = zzbuz;
        this.zzbuA = null;
        if (versionCode == 1) {
            Double value = n2;
            if (n != null) {
                value = (double)n;
            }
            this.zzbuB = value;
        }
        else {
            this.zzbuB = zzbuB;
        }
        this.zzaIF = zzaIF;
        this.zzbpc = zzbpc;
    }
    
    zzcji(final zzcjk zzcjk) {
        this(zzcjk.mName, zzcjk.zzbuC, zzcjk.mValue, zzcjk.mOrigin);
    }
    
    zzcji(final String name, final long zzbuy, final Object o, final String zzbpc) {
        zzbo.zzcF(name);
        this.versionCode = 2;
        this.name = name;
        this.zzbuy = zzbuy;
        this.zzbpc = zzbpc;
        if (o == null) {
            this.zzbuz = null;
            this.zzbuA = null;
            this.zzbuB = null;
            this.zzaIF = null;
            return;
        }
        if (o instanceof Long) {
            this.zzbuz = (Long)o;
            this.zzbuA = null;
            this.zzbuB = null;
            this.zzaIF = null;
            return;
        }
        if (o instanceof String) {
            this.zzbuz = null;
            this.zzbuA = null;
            this.zzbuB = null;
            this.zzaIF = (String)o;
            return;
        }
        if (o instanceof Double) {
            this.zzbuz = null;
            this.zzbuA = null;
            this.zzbuB = (Double)o;
            this.zzaIF = null;
            return;
        }
        throw new IllegalArgumentException("User attribute given of un-supported type");
    }
    
    public final Object getValue() {
        if (this.zzbuz != null) {
            return this.zzbuz;
        }
        if (this.zzbuB != null) {
            return this.zzbuB;
        }
        if (this.zzaIF != null) {
            return this.zzaIF;
        }
        return null;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.name, false);
        zzd.zza(parcel, 3, this.zzbuy);
        zzd.zza(parcel, 4, this.zzbuz, false);
        zzd.zza(parcel, 5, (Float)null, false);
        zzd.zza(parcel, 6, this.zzaIF, false);
        zzd.zza(parcel, 7, this.zzbpc, false);
        zzd.zza(parcel, 8, this.zzbuB, false);
        zzd.zzI(parcel, zze);
    }
}
