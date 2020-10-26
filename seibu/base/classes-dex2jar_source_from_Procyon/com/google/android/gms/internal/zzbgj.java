// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.Map;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbe;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgj<I, O> extends zza
{
    public static final zzbgm CREATOR;
    protected final int zzaIH;
    protected final boolean zzaII;
    protected final int zzaIJ;
    protected final boolean zzaIK;
    protected final String zzaIL;
    protected final int zzaIM;
    protected final Class<? extends zzbgi> zzaIN;
    private String zzaIO;
    private zzbgo zzaIP;
    private zzbgk<I, O> zzaIQ;
    private final int zzaku;
    
    static {
        CREATOR = new zzbgm();
    }
    
    zzbgj(final int zzaku, final int zzaIH, final boolean zzaII, final int zzaIJ, final boolean zzaIK, final String zzaIL, final int zzaIM, final String zzaIO, final zzbgc zzbgc) {
        this.zzaku = zzaku;
        this.zzaIH = zzaIH;
        this.zzaII = zzaII;
        this.zzaIJ = zzaIJ;
        this.zzaIK = zzaIK;
        this.zzaIL = zzaIL;
        this.zzaIM = zzaIM;
        if (zzaIO == null) {
            this.zzaIN = null;
            this.zzaIO = null;
        }
        else {
            this.zzaIN = zzbgt.class;
            this.zzaIO = zzaIO;
        }
        if (zzbgc == null) {
            this.zzaIQ = null;
            return;
        }
        this.zzaIQ = (zzbgk<I, O>)zzbgc.zzrK();
    }
    
    private zzbgj(final int zzaIH, final boolean zzaII, final int zzaIJ, final boolean zzaIK, final String zzaIL, final int zzaIM, final Class<? extends zzbgi> zzaIN, final zzbgk<I, O> zzaIQ) {
        this.zzaku = 1;
        this.zzaIH = zzaIH;
        this.zzaII = zzaII;
        this.zzaIJ = zzaIJ;
        this.zzaIK = zzaIK;
        this.zzaIL = zzaIL;
        this.zzaIM = zzaIM;
        this.zzaIN = zzaIN;
        if (zzaIN == null) {
            this.zzaIO = null;
        }
        else {
            this.zzaIO = zzaIN.getCanonicalName();
        }
        this.zzaIQ = zzaIQ;
    }
    
    public static zzbgj zza(final String s, final int n, final zzbgk<?, ?> zzbgk, final boolean b) {
        return new zzbgj(7, false, 0, false, s, n, null, (zzbgk<I, O>)zzbgk);
    }
    
    public static <T extends zzbgi> zzbgj<T, T> zza(final String s, final int n, final Class<T> clazz) {
        return new zzbgj<T, T>(11, false, 11, false, s, n, clazz, null);
    }
    
    public static <T extends zzbgi> zzbgj<ArrayList<T>, ArrayList<T>> zzb(final String s, final int n, final Class<T> clazz) {
        return new zzbgj<ArrayList<T>, ArrayList<T>>(11, true, 11, true, s, n, clazz, null);
    }
    
    public static zzbgj<Integer, Integer> zzj(final String s, final int n) {
        return new zzbgj<Integer, Integer>(0, false, 0, false, s, n, null, null);
    }
    
    public static zzbgj<Boolean, Boolean> zzk(final String s, final int n) {
        return new zzbgj<Boolean, Boolean>(6, false, 6, false, s, n, null, null);
    }
    
    public static zzbgj<String, String> zzl(final String s, final int n) {
        return new zzbgj<String, String>(7, false, 7, false, s, n, null, null);
    }
    
    private String zzrN() {
        if (this.zzaIO == null) {
            return null;
        }
        return this.zzaIO;
    }
    
    public final I convertBack(final O o) {
        return this.zzaIQ.convertBack(o);
    }
    
    @Override
    public final String toString() {
        final zzbg zzg = zzbe.zzt(this).zzg("versionCode", this.zzaku).zzg("typeIn", this.zzaIH).zzg("typeInArray", this.zzaII).zzg("typeOut", this.zzaIJ).zzg("typeOutArray", this.zzaIK).zzg("outputFieldName", this.zzaIL).zzg("safeParcelFieldId", this.zzaIM).zzg("concreteTypeName", this.zzrN());
        final Class<? extends zzbgi> zzaIN = this.zzaIN;
        if (zzaIN != null) {
            zzg.zzg("concreteType.class", zzaIN.getCanonicalName());
        }
        if (this.zzaIQ != null) {
            zzg.zzg("converterName", this.zzaIQ.getClass().getCanonicalName());
        }
        return zzg.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zzc(parcel, 2, this.zzaIH);
        zzd.zza(parcel, 3, this.zzaII);
        zzd.zzc(parcel, 4, this.zzaIJ);
        zzd.zza(parcel, 5, this.zzaIK);
        zzd.zza(parcel, 6, this.zzaIL, false);
        zzd.zzc(parcel, 7, this.zzaIM);
        zzd.zza(parcel, 8, this.zzrN(), false);
        Object zza;
        if (this.zzaIQ == null) {
            zza = null;
        }
        else {
            zza = zzbgc.zza(this.zzaIQ);
        }
        zzd.zza(parcel, 9, (Parcelable)zza, n, false);
        zzd.zzI(parcel, zze);
    }
    
    public final void zza(final zzbgo zzaIP) {
        this.zzaIP = zzaIP;
    }
    
    public final int zzrM() {
        return this.zzaIM;
    }
    
    public final boolean zzrO() {
        return this.zzaIQ != null;
    }
    
    public final Map<String, zzbgj<?, ?>> zzrP() {
        zzbo.zzu(this.zzaIO);
        zzbo.zzu(this.zzaIP);
        return this.zzaIP.zzcJ(this.zzaIO);
    }
}
