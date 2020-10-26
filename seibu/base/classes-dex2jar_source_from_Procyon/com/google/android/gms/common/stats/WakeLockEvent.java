// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import android.text.TextUtils;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;

public final class WakeLockEvent extends StatsEvent
{
    public static final Parcelable$Creator<WakeLockEvent> CREATOR;
    private final long mTimeout;
    private final long zzaJn;
    private int zzaJo;
    private final String zzaJp;
    private final String zzaJq;
    private final String zzaJr;
    private final int zzaJs;
    private final List<String> zzaJt;
    private final String zzaJu;
    private final long zzaJv;
    private int zzaJw;
    private final String zzaJx;
    private final float zzaJy;
    private long zzaJz;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzd();
    }
    
    WakeLockEvent(final int zzaku, final long zzaJn, final int zzaJo, final String zzaJp, final int zzaJs, final List<String> zzaJt, final String zzaJu, final long zzaJv, final int zzaJw, final String zzaJq, final String zzaJx, final float zzaJy, final long mTimeout, final String zzaJr) {
        this.zzaku = zzaku;
        this.zzaJn = zzaJn;
        this.zzaJo = zzaJo;
        this.zzaJp = zzaJp;
        this.zzaJq = zzaJq;
        this.zzaJr = zzaJr;
        this.zzaJs = zzaJs;
        this.zzaJz = -1L;
        this.zzaJt = zzaJt;
        this.zzaJu = zzaJu;
        this.zzaJv = zzaJv;
        this.zzaJw = zzaJw;
        this.zzaJx = zzaJx;
        this.zzaJy = zzaJy;
        this.mTimeout = mTimeout;
    }
    
    public WakeLockEvent(final long n, final int n2, final String s, final int n3, final List<String> list, final String s2, final long n4, final int n5, final String s3, final String s4, final float n6, final long n7, final String s5) {
        this(2, n, n2, s, n3, list, s2, n4, n5, s3, s4, n6, n7, s5);
    }
    
    @Override
    public final int getEventType() {
        return this.zzaJo;
    }
    
    @Override
    public final long getTimeMillis() {
        return this.zzaJn;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.zzaku);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzaJn);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzaJp, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 5, this.zzaJs);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 6, this.zzaJt, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzaJv);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, this.zzaJq, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 11, this.zzaJo);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 12, this.zzaJu, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 13, this.zzaJx, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 14, this.zzaJw);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 15, this.zzaJy);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 16, this.mTimeout);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 17, this.zzaJr, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzI(parcel, zze);
    }
    
    @Override
    public final long zzrV() {
        return this.zzaJz;
    }
    
    @Override
    public final String zzrW() {
        final String value = String.valueOf("\t");
        final String value2 = String.valueOf(this.zzaJp);
        final String value3 = String.valueOf("\t");
        final int zzaJs = this.zzaJs;
        final String value4 = String.valueOf("\t");
        String join;
        if (this.zzaJt == null) {
            join = "";
        }
        else {
            join = TextUtils.join((CharSequence)",", (Iterable)this.zzaJt);
        }
        final String value5 = String.valueOf("\t");
        final int zzaJw = this.zzaJw;
        final String value6 = String.valueOf("\t");
        String zzaJq;
        if (this.zzaJq == null) {
            zzaJq = "";
        }
        else {
            zzaJq = this.zzaJq;
        }
        final String value7 = String.valueOf("\t");
        String zzaJx;
        if (this.zzaJx == null) {
            zzaJx = "";
        }
        else {
            zzaJx = this.zzaJx;
        }
        final String value8 = String.valueOf("\t");
        final float zzaJy = this.zzaJy;
        final String value9 = String.valueOf("\t");
        String zzaJr;
        if (this.zzaJr == null) {
            zzaJr = "";
        }
        else {
            zzaJr = this.zzaJr;
        }
        return new StringBuilder(String.valueOf(value).length() + 37 + String.valueOf(value2).length() + String.valueOf(value3).length() + String.valueOf(value4).length() + String.valueOf(join).length() + String.valueOf(value5).length() + String.valueOf(value6).length() + String.valueOf(zzaJq).length() + String.valueOf(value7).length() + String.valueOf(zzaJx).length() + String.valueOf(value8).length() + String.valueOf(value9).length() + String.valueOf(zzaJr).length()).append(value).append(value2).append(value3).append(zzaJs).append(value4).append(join).append(value5).append(zzaJw).append(value6).append(zzaJq).append(value7).append(zzaJx).append(value8).append(zzaJy).append(value9).append(zzaJr).toString();
    }
}
