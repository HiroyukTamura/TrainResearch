// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.ArrayList;
import android.util.SparseArray;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbge extends zza implements zzbgk<String, Integer>
{
    public static final Parcelable$Creator<zzbge> CREATOR;
    private final HashMap<String, Integer> zzaIC;
    private final SparseArray<String> zzaID;
    private final ArrayList<zzbgf> zzaIE;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbgg();
    }
    
    public zzbge() {
        this.zzaku = 1;
        this.zzaIC = new HashMap<String, Integer>();
        this.zzaID = (SparseArray<String>)new SparseArray();
        this.zzaIE = null;
    }
    
    zzbge(final int zzaku, final ArrayList<zzbgf> list) {
        this.zzaku = zzaku;
        this.zzaIC = new HashMap<String, Integer>();
        this.zzaID = (SparseArray<String>)new SparseArray();
        this.zzaIE = null;
        this.zzd(list);
    }
    
    private final void zzd(final ArrayList<zzbgf> list) {
        final ArrayList<zzbgf> list2 = list;
        final int size = list2.size();
        int i = 0;
        while (i < size) {
            final zzbgf value = list2.get(i);
            ++i;
            final zzbgf zzbgf = value;
            this.zzi(zzbgf.zzaIF, zzbgf.zzaIG);
        }
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        final ArrayList<Parcelable> list = new ArrayList<Parcelable>();
        for (final String key : this.zzaIC.keySet()) {
            list.add((Parcelable)new zzbgf(key, this.zzaIC.get(key)));
        }
        zzd.zzc(parcel, 2, list, false);
        zzd.zzI(parcel, zze);
    }
    
    public final zzbge zzi(final String key, final int i) {
        this.zzaIC.put(key, i);
        this.zzaID.put(i, (Object)key);
        return this;
    }
}
