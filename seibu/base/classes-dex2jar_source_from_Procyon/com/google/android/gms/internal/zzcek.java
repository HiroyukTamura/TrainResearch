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

public final class zzcek extends zza
{
    public static final Parcelable$Creator<zzcek> CREATOR;
    public String packageName;
    private int versionCode;
    public String zzbpc;
    public zzcji zzbpd;
    public long zzbpe;
    public boolean zzbpf;
    public String zzbpg;
    public zzcez zzbph;
    public long zzbpi;
    public zzcez zzbpj;
    public long zzbpk;
    public zzcez zzbpl;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcel();
    }
    
    zzcek(final int versionCode, final String packageName, final String zzbpc, final zzcji zzbpd, final long zzbpe, final boolean zzbpf, final String zzbpg, final zzcez zzbph, final long zzbpi, final zzcez zzbpj, final long zzbpk, final zzcez zzbpl) {
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.zzbpc = zzbpc;
        this.zzbpd = zzbpd;
        this.zzbpe = zzbpe;
        this.zzbpf = zzbpf;
        this.zzbpg = zzbpg;
        this.zzbph = zzbph;
        this.zzbpi = zzbpi;
        this.zzbpj = zzbpj;
        this.zzbpk = zzbpk;
        this.zzbpl = zzbpl;
    }
    
    zzcek(final zzcek zzcek) {
        this.versionCode = 1;
        zzbo.zzu(zzcek);
        this.packageName = zzcek.packageName;
        this.zzbpc = zzcek.zzbpc;
        this.zzbpd = zzcek.zzbpd;
        this.zzbpe = zzcek.zzbpe;
        this.zzbpf = zzcek.zzbpf;
        this.zzbpg = zzcek.zzbpg;
        this.zzbph = zzcek.zzbph;
        this.zzbpi = zzcek.zzbpi;
        this.zzbpj = zzcek.zzbpj;
        this.zzbpk = zzcek.zzbpk;
        this.zzbpl = zzcek.zzbpl;
    }
    
    zzcek(final String packageName, final String zzbpc, final zzcji zzbpd, final long zzbpe, final boolean zzbpf, final String zzbpg, final zzcez zzbph, final long zzbpi, final zzcez zzbpj, final long zzbpk, final zzcez zzbpl) {
        this.versionCode = 1;
        this.packageName = packageName;
        this.zzbpc = zzbpc;
        this.zzbpd = zzbpd;
        this.zzbpe = zzbpe;
        this.zzbpf = zzbpf;
        this.zzbpg = zzbpg;
        this.zzbph = zzbph;
        this.zzbpi = zzbpi;
        this.zzbpj = zzbpj;
        this.zzbpk = zzbpk;
        this.zzbpl = zzbpl;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.packageName, false);
        zzd.zza(parcel, 3, this.zzbpc, false);
        zzd.zza(parcel, 4, (Parcelable)this.zzbpd, n, false);
        zzd.zza(parcel, 5, this.zzbpe);
        zzd.zza(parcel, 6, this.zzbpf);
        zzd.zza(parcel, 7, this.zzbpg, false);
        zzd.zza(parcel, 8, (Parcelable)this.zzbph, n, false);
        zzd.zza(parcel, 9, this.zzbpi);
        zzd.zza(parcel, 10, (Parcelable)this.zzbpj, n, false);
        zzd.zza(parcel, 11, this.zzbpk);
        zzd.zza(parcel, 12, (Parcelable)this.zzbpl, n, false);
        zzd.zzI(parcel, zze);
    }
}
