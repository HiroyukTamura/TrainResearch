// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.ArrayList;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.Set;
import android.os.Bundle;
import java.util.Map;
import java.math.BigInteger;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.util.zzp;
import java.util.HashMap;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class zzbgt extends zzbgl
{
    public static final Parcelable$Creator<zzbgt> CREATOR;
    private final String mClassName;
    private final zzbgo zzaIP;
    private final Parcel zzaIW;
    private final int zzaIX;
    private int zzaIY;
    private int zzaIZ;
    private final int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgu();
    }
    
    zzbgt(final int zzaku, final Parcel parcel, final zzbgo zzaIP) {
        this.zzaku = zzaku;
        this.zzaIW = zzbo.zzu(parcel);
        this.zzaIX = 2;
        this.zzaIP = zzaIP;
        if (this.zzaIP == null) {
            this.mClassName = null;
        }
        else {
            this.mClassName = this.zzaIP.zzrR();
        }
        this.zzaIY = 2;
    }
    
    private static void zza(final StringBuilder sb, final int i, final Object obj) {
        switch (i) {
            default: {
                throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i).toString());
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                sb.append(obj);
            }
            case 7: {
                sb.append("\"").append(zzo.zzcK(obj.toString())).append("\"");
            }
            case 8: {
                sb.append("\"").append(zzc.encode((byte[])obj)).append("\"");
            }
            case 9: {
                sb.append("\"").append(zzc.zzg((byte[])obj));
                sb.append("\"");
            }
            case 10: {
                zzp.zza(sb, (HashMap<String, String>)obj);
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
        }
    }
    
    private final void zza(final StringBuilder sb, final zzbgj<?, ?> zzbgj, Parcel zzD, int i) {
        final double[] array = null;
        final BigInteger[] array2 = null;
        final int n = 0;
        final int n2 = 0;
        if (zzbgj.zzaIK) {
            sb.append("[");
            switch (zzbgj.zzaIJ) {
                default: {
                    throw new IllegalStateException("Unknown field type out.");
                }
                case 0: {
                    final int[] zzw = zzb.zzw(zzD, i);
                    int length;
                    for (length = zzw.length, i = n2; i < length; ++i) {
                        if (i != 0) {
                            sb.append(",");
                        }
                        sb.append(Integer.toString(zzw[i]));
                    }
                    break;
                }
                case 1: {
                    final int zza = zzb.zza(zzD, i);
                    final int dataPosition = zzD.dataPosition();
                    BigInteger[] array3;
                    if (zza == 0) {
                        array3 = array2;
                    }
                    else {
                        final int int1 = zzD.readInt();
                        array3 = new BigInteger[int1];
                        for (i = n; i < int1; ++i) {
                            array3[i] = new BigInteger(zzD.createByteArray());
                        }
                        zzD.setDataPosition(zza + dataPosition);
                    }
                    com.google.android.gms.common.util.zzb.zza(sb, array3);
                    break;
                }
                case 2: {
                    com.google.android.gms.common.util.zzb.zza(sb, zzb.zzx(zzD, i));
                    break;
                }
                case 3: {
                    com.google.android.gms.common.util.zzb.zza(sb, zzb.zzy(zzD, i));
                    break;
                }
                case 4: {
                    i = zzb.zza(zzD, i);
                    final int dataPosition2 = zzD.dataPosition();
                    double[] doubleArray;
                    if (i == 0) {
                        doubleArray = array;
                    }
                    else {
                        doubleArray = zzD.createDoubleArray();
                        zzD.setDataPosition(i + dataPosition2);
                    }
                    com.google.android.gms.common.util.zzb.zza(sb, doubleArray);
                    break;
                }
                case 5: {
                    com.google.android.gms.common.util.zzb.zza(sb, zzb.zzz(zzD, i));
                    break;
                }
                case 6: {
                    com.google.android.gms.common.util.zzb.zza(sb, zzb.zzv(zzD, i));
                    break;
                }
                case 7: {
                    com.google.android.gms.common.util.zzb.zza(sb, zzb.zzA(zzD, i));
                    break;
                }
                case 8:
                case 9:
                case 10: {
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                }
                case 11: {
                    final Parcel[] zzE = zzb.zzE(zzD, i);
                    int length2;
                    for (length2 = zzE.length, i = 0; i < length2; ++i) {
                        if (i > 0) {
                            sb.append(",");
                        }
                        zzE[i].setDataPosition(0);
                        this.zza(sb, zzbgj.zzrP(), zzE[i]);
                    }
                    break;
                }
            }
            sb.append("]");
            return;
        }
        switch (zzbgj.zzaIJ) {
            default: {
                throw new IllegalStateException("Unknown field type out");
            }
            case 0: {
                sb.append(zzb.zzg(zzD, i));
            }
            case 1: {
                sb.append(zzb.zzk(zzD, i));
            }
            case 2: {
                sb.append(zzb.zzi(zzD, i));
            }
            case 3: {
                sb.append(zzb.zzl(zzD, i));
            }
            case 4: {
                sb.append(zzb.zzn(zzD, i));
            }
            case 5: {
                sb.append(zzb.zzp(zzD, i));
            }
            case 6: {
                sb.append(zzb.zzc(zzD, i));
            }
            case 7: {
                sb.append("\"").append(zzo.zzcK(zzb.zzq(zzD, i))).append("\"");
            }
            case 8: {
                sb.append("\"").append(zzc.encode(zzb.zzt(zzD, i))).append("\"");
            }
            case 9: {
                sb.append("\"").append(zzc.zzg(zzb.zzt(zzD, i)));
                sb.append("\"");
            }
            case 10: {
                final Bundle zzs = zzb.zzs(zzD, i);
                final Set keySet = zzs.keySet();
                keySet.size();
                sb.append("{");
                final Iterator<String> iterator = keySet.iterator();
                i = 1;
                while (iterator.hasNext()) {
                    final String str = iterator.next();
                    if (i == 0) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzo.zzcK(zzs.getString(str))).append("\"");
                    i = 0;
                }
                sb.append("}");
            }
            case 11: {
                zzD = zzb.zzD(zzD, i);
                zzD.setDataPosition(0);
                this.zza(sb, zzbgj.zzrP(), zzD);
            }
        }
    }
    
    private final void zza(final StringBuilder sb, final Map<String, zzbgj<?, ?>> map, final Parcel parcel) {
        final SparseArray sparseArray = new SparseArray();
        for (final Map.Entry<String, zzbgj<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().zzaIM, (Object)entry);
        }
        sb.append('{');
        final int zzd = zzb.zzd(parcel);
        int n = 0;
        while (parcel.dataPosition() < zzd) {
            final int int1 = parcel.readInt();
            final Map.Entry entry2 = (Map.Entry)sparseArray.get(0xFFFF & int1);
            if (entry2 != null) {
                if (n != 0) {
                    sb.append(",");
                }
                final String str = entry2.getKey();
                final zzbgj<Object, Object> zzbgj = entry2.getValue();
                sb.append("\"").append(str).append("\":");
                if (zzbgj.zzrO()) {
                    switch (zzbgj.zzaIJ) {
                        default: {
                            throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(zzbgj.zzaIJ).toString());
                        }
                        case 0: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzg(parcel, int1)));
                            break;
                        }
                        case 1: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzk(parcel, int1)));
                            break;
                        }
                        case 2: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzi(parcel, int1)));
                            break;
                        }
                        case 3: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzl(parcel, int1)));
                            break;
                        }
                        case 4: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzn(parcel, int1)));
                            break;
                        }
                        case 5: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzp(parcel, int1)));
                            break;
                        }
                        case 6: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzc(parcel, int1)));
                            break;
                        }
                        case 7: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzq(parcel, int1)));
                            break;
                        }
                        case 8:
                        case 9: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzb.zzt(parcel, int1)));
                            break;
                        }
                        case 10: {
                            this.zzb(sb, zzbgj, zzbgi.zza(zzbgj, zzo(zzb.zzs(parcel, int1))));
                            break;
                        }
                        case 11: {
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        }
                    }
                }
                else {
                    this.zza(sb, zzbgj, parcel, int1);
                }
                n = 1;
            }
        }
        if (parcel.dataPosition() != zzd) {
            throw new com.google.android.gms.common.internal.safeparcel.zzc(new StringBuilder(37).append("Overread allowed size end=").append(zzd).toString(), parcel);
        }
        sb.append('}');
    }
    
    private final void zzb(final StringBuilder sb, final zzbgj<?, ?> zzbgj, final Object o) {
        if (zzbgj.zzaII) {
            final ArrayList list = (ArrayList)o;
            sb.append("[");
            for (int size = list.size(), i = 0; i < size; ++i) {
                if (i != 0) {
                    sb.append(",");
                }
                zza(sb, zzbgj.zzaIH, list.get(i));
            }
            sb.append("]");
            return;
        }
        zza(sb, zzbgj.zzaIH, o);
    }
    
    private static HashMap<String, String> zzo(final Bundle bundle) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final String key : bundle.keySet()) {
            hashMap.put(key, bundle.getString(key));
        }
        return hashMap;
    }
    
    private Parcel zzrT() {
        switch (this.zzaIY) {
            case 0: {
                this.zzaIZ = zzd.zze(this.zzaIW);
            }
            case 1: {
                zzd.zzI(this.zzaIW, this.zzaIZ);
                this.zzaIY = 2;
                break;
            }
        }
        return this.zzaIW;
    }
    
    @Override
    public String toString() {
        zzbo.zzb(this.zzaIP, "Cannot convert to JSON on client side.");
        final Parcel zzrT = this.zzrT();
        zzrT.setDataPosition(0);
        final StringBuilder sb = new StringBuilder(100);
        this.zza(sb, this.zzaIP.zzcJ(this.mClassName), zzrT);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int zzaIX) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.zzrT(), false);
        Object o = null;
        switch (this.zzaIX) {
            default: {
                zzaIX = this.zzaIX;
                throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(zzaIX).toString());
            }
            case 0: {
                o = null;
                break;
            }
            case 1: {
                o = this.zzaIP;
                break;
            }
            case 2: {
                o = this.zzaIP;
                break;
            }
        }
        zzd.zza(parcel, 3, (Parcelable)o, zzaIX, false);
        zzd.zzI(parcel, zze);
    }
    
    @Override
    public final Object zzcH(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    @Override
    public final boolean zzcI(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    @Override
    public final Map<String, zzbgj<?, ?>> zzrL() {
        if (this.zzaIP == null) {
            return null;
        }
        return this.zzaIP.zzcJ(this.mClassName);
    }
}
