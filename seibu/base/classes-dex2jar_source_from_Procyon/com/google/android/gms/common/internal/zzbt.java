// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbt extends zza
{
    public static final Parcelable$Creator<zzbt> CREATOR;
    private final int zzaIs;
    private final int zzaIt;
    @Deprecated
    private final Scope[] zzaIu;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbu();
    }
    
    zzbt(final int zzaku, final int zzaIs, final int zzaIt, final Scope[] zzaIu) {
        this.zzaku = zzaku;
        this.zzaIs = zzaIs;
        this.zzaIt = zzaIt;
        this.zzaIu = zzaIu;
    }
    
    public zzbt(final int n, final int n2, final Scope[] array) {
        this(1, n, n2, null);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zzc(parcel, 2, this.zzaIs);
        zzd.zzc(parcel, 3, this.zzaIt);
        zzd.zza(parcel, 4, this.zzaIu, n, false);
        zzd.zzI(parcel, zze);
    }
}
