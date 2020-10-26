// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.util.Base64;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzcqn extends zza
{
    public static final Parcelable$Creator<zzcqn> CREATOR;
    private static byte[][] zzazi;
    private static zzcqn zzbAc;
    private static final zzcqs zzbAl;
    private static final zzcqs zzbAm;
    private static final zzcqs zzbAn;
    private static final zzcqs zzbAo;
    private String zzbAd;
    private byte[] zzbAe;
    private byte[][] zzbAf;
    private byte[][] zzbAg;
    private byte[][] zzbAh;
    private byte[][] zzbAi;
    private int[] zzbAj;
    private byte[][] zzbAk;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcqt();
        zzcqn.zzazi = new byte[0][];
        zzcqn.zzbAc = new zzcqn("", null, zzcqn.zzazi, zzcqn.zzazi, zzcqn.zzazi, zzcqn.zzazi, null, null);
        zzbAl = (zzcqs)new zzcqo();
        zzbAm = (zzcqs)new zzcqp();
        zzbAn = (zzcqs)new zzcqq();
        zzbAo = (zzcqs)new zzcqr();
    }
    
    public zzcqn(final String zzbAd, final byte[] zzbAe, final byte[][] zzbAf, final byte[][] zzbAg, final byte[][] zzbAh, final byte[][] zzbAi, final int[] zzbAj, final byte[][] zzbAk) {
        this.zzbAd = zzbAd;
        this.zzbAe = zzbAe;
        this.zzbAf = zzbAf;
        this.zzbAg = zzbAg;
        this.zzbAh = zzbAh;
        this.zzbAi = zzbAi;
        this.zzbAj = zzbAj;
        this.zzbAk = zzbAk;
    }
    
    private static void zza(final StringBuilder sb, final String str, final int[] array) {
        sb.append(str);
        sb.append("=");
        if (array == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        final int length = array.length;
        int n = 1;
        for (int i = 0; i < length; ++i, n = 0) {
            final int j = array[i];
            if (n == 0) {
                sb.append(", ");
            }
            sb.append(j);
        }
        sb.append(")");
    }
    
    private static void zza(final StringBuilder sb, final String str, final byte[][] array) {
        sb.append(str);
        sb.append("=");
        if (array == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        final int length = array.length;
        int n = 1;
        for (int i = 0; i < length; ++i, n = 0) {
            final byte[] array2 = array[i];
            if (n == 0) {
                sb.append(", ");
            }
            sb.append("'");
            sb.append(Base64.encodeToString(array2, 3));
            sb.append("'");
        }
        sb.append(")");
    }
    
    private static List<String> zzb(final byte[][] array) {
        if (array == null) {
            return Collections.emptyList();
        }
        final ArrayList<Comparable> list = new ArrayList<Comparable>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(Base64.encodeToString(array[i], 3));
        }
        Collections.sort(list);
        return (List<String>)list;
    }
    
    private static List<Integer> zzc(final int[] array) {
        if (array == null) {
            return Collections.emptyList();
        }
        final ArrayList<Comparable> list = new ArrayList<Comparable>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort(list);
        return (List<Integer>)list;
    }
    
    @Override
    public final boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof zzcqn) {
            final zzcqn zzcqn = (zzcqn)o;
            b2 = b;
            if (zzcqu.equals(this.zzbAd, zzcqn.zzbAd)) {
                b2 = b;
                if (Arrays.equals(this.zzbAe, zzcqn.zzbAe)) {
                    b2 = b;
                    if (zzcqu.equals(zzb(this.zzbAf), zzb(zzcqn.zzbAf))) {
                        b2 = b;
                        if (zzcqu.equals(zzb(this.zzbAg), zzb(zzcqn.zzbAg))) {
                            b2 = b;
                            if (zzcqu.equals(zzb(this.zzbAh), zzb(zzcqn.zzbAh))) {
                                b2 = b;
                                if (zzcqu.equals(zzb(this.zzbAi), zzb(zzcqn.zzbAi))) {
                                    b2 = b;
                                    if (zzcqu.equals(zzc(this.zzbAj), zzc(zzcqn.zzbAj))) {
                                        b2 = b;
                                        if (zzcqu.equals(zzb(this.zzbAk), zzb(zzcqn.zzbAk))) {
                                            b2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String string;
        if (this.zzbAd == null) {
            string = "null";
        }
        else {
            final String value = String.valueOf("'");
            final String zzbAd = this.zzbAd;
            final String value2 = String.valueOf("'");
            string = new StringBuilder(String.valueOf(value).length() + String.valueOf(zzbAd).length() + String.valueOf(value2).length()).append(value).append(zzbAd).append(value2).toString();
        }
        sb.append(string);
        sb.append(", ");
        final byte[] zzbAe = this.zzbAe;
        sb.append("direct");
        sb.append("=");
        if (zzbAe == null) {
            sb.append("null");
        }
        else {
            sb.append("'");
            sb.append(Base64.encodeToString(zzbAe, 3));
            sb.append("'");
        }
        sb.append(", ");
        zza(sb, "GAIA", this.zzbAf);
        sb.append(", ");
        zza(sb, "PSEUDO", this.zzbAg);
        sb.append(", ");
        zza(sb, "ALWAYS", this.zzbAh);
        sb.append(", ");
        zza(sb, "OTHER", this.zzbAi);
        sb.append(", ");
        zza(sb, "weak", this.zzbAj);
        sb.append(", ");
        zza(sb, "directs", this.zzbAk);
        sb.append(")");
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.zzbAd, false);
        zzd.zza(parcel, 3, this.zzbAe, false);
        zzd.zza(parcel, 4, this.zzbAf, false);
        zzd.zza(parcel, 5, this.zzbAg, false);
        zzd.zza(parcel, 6, this.zzbAh, false);
        zzd.zza(parcel, 7, this.zzbAi, false);
        zzd.zza(parcel, 8, this.zzbAj, false);
        zzd.zza(parcel, 9, this.zzbAk, false);
        zzd.zzI(parcel, zze);
    }
}
