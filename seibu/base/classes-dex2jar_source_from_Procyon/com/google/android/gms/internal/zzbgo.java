// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.Iterator;
import com.google.android.gms.common.internal.zzbo;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbgo extends zza
{
    public static final Parcelable$Creator<zzbgo> CREATOR;
    private final HashMap<String, Map<String, zzbgj<?, ?>>> zzaIR;
    private final ArrayList<zzbgp> zzaIS;
    private final String zzaIT;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgr();
    }
    
    zzbgo(int i, final ArrayList<zzbgp> list, final String s) {
        this.zzaku = i;
        this.zzaIS = null;
        final HashMap<String, Map<String, zzbgj<?, ?>>> zzaIR = new HashMap<String, Map<String, zzbgj<?, ?>>>();
        int size;
        zzbgp zzbgp;
        for (size = list.size(), i = 0; i < size; ++i) {
            zzbgp = list.get(i);
            zzaIR.put(zzbgp.className, zzbgp.zzrS());
        }
        this.zzaIR = zzaIR;
        this.zzaIT = zzbo.zzu(s);
        this.zzrQ();
    }
    
    private final void zzrQ() {
        final Iterator<String> iterator = this.zzaIR.keySet().iterator();
        while (iterator.hasNext()) {
            final Map<String, zzbgj<?, ?>> map = this.zzaIR.get(iterator.next());
            final Iterator<String> iterator2 = map.keySet().iterator();
            while (iterator2.hasNext()) {
                map.get(iterator2.next()).zza(this);
            }
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String s : this.zzaIR.keySet()) {
            sb.append(s).append(":\n");
            final Map<String, zzbgj<?, ?>> map = this.zzaIR.get(s);
            for (final String str : map.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        final ArrayList<Parcelable> list = new ArrayList<Parcelable>();
        for (final String key : this.zzaIR.keySet()) {
            list.add((Parcelable)new zzbgp(key, this.zzaIR.get(key)));
        }
        zzd.zzc(parcel, 2, list, false);
        zzd.zza(parcel, 3, this.zzaIT, false);
        zzd.zzI(parcel, zze);
    }
    
    public final Map<String, zzbgj<?, ?>> zzcJ(final String key) {
        return this.zzaIR.get(key);
    }
    
    public final String zzrR() {
        return this.zzaIT;
    }
}
