// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Scope extends zza implements ReflectedParcelable
{
    public static final Parcelable$Creator<Scope> CREATOR;
    private final String zzaBl;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zze();
    }
    
    Scope(final int zzaku, final String zzaBl) {
        zzbo.zzh(zzaBl, "scopeUri must not be null or empty");
        this.zzaku = zzaku;
        this.zzaBl = zzaBl;
    }
    
    public Scope(final String s) {
        this(1, s);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return this == o || (o instanceof Scope && this.zzaBl.equals(((Scope)o).zzaBl));
    }
    
    @Override
    public final int hashCode() {
        return this.zzaBl.hashCode();
    }
    
    @Override
    public final String toString() {
        return this.zzaBl;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.zzaBl, false);
        zzd.zzI(parcel, zze);
    }
    
    public final String zzpp() {
        return this.zzaBl;
    }
}
