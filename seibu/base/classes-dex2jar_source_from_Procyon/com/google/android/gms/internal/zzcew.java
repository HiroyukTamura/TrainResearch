// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzcew extends zza implements Iterable<String>
{
    public static final Parcelable$Creator<zzcew> CREATOR;
    private final Bundle zzbpJ;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcey();
    }
    
    zzcew(final Bundle zzbpJ) {
        this.zzbpJ = zzbpJ;
    }
    
    final Object get(final String s) {
        return this.zzbpJ.get(s);
    }
    
    @Override
    public final Iterator<String> iterator() {
        return new zzcex(this);
    }
    
    public final int size() {
        return this.zzbpJ.size();
    }
    
    @Override
    public final String toString() {
        return this.zzbpJ.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.zzyt(), false);
        zzd.zzI(parcel, zze);
    }
    
    public final Bundle zzyt() {
        return new Bundle(this.zzbpJ);
    }
}
