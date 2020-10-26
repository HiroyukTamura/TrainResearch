// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgp extends zza
{
    public static final Parcelable$Creator<zzbgp> CREATOR;
    final String className;
    private int versionCode;
    private ArrayList<zzbgq> zzaIU;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgs();
    }
    
    zzbgp(final int versionCode, final String className, final ArrayList<zzbgq> zzaIU) {
        this.versionCode = versionCode;
        this.className = className;
        this.zzaIU = zzaIU;
    }
    
    zzbgp(final String className, final Map<String, zzbgj<?, ?>> map) {
        this.versionCode = 1;
        this.className = className;
        ArrayList<zzbgq> zzaIU;
        if (map == null) {
            zzaIU = null;
        }
        else {
            zzaIU = new ArrayList<zzbgq>();
            for (final String s : map.keySet()) {
                zzaIU.add(new zzbgq(s, map.get(s)));
            }
        }
        this.zzaIU = zzaIU;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zza(parcel, 2, this.className, false);
        zzd.zzc(parcel, 3, this.zzaIU, false);
        zzd.zzI(parcel, zze);
    }
    
    final HashMap<String, zzbgj<?, ?>> zzrS() {
        final HashMap<String, zzbgj<?, ?>> hashMap = new HashMap<String, zzbgj<?, ?>>();
        for (int size = this.zzaIU.size(), i = 0; i < size; ++i) {
            final zzbgq zzbgq = this.zzaIU.get(i);
            hashMap.put(zzbgq.key, zzbgq.zzaIV);
        }
        return hashMap;
    }
}
