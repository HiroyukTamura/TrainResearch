// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbp;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzctv extends zza
{
    public static final Parcelable$Creator<zzctv> CREATOR;
    private int zzaku;
    private zzbp zzbCU;
    
    static {
        CREATOR = (Parcelable$Creator)new zzctw();
    }
    
    zzctv(final int zzaku, final zzbp zzbCU) {
        this.zzaku = zzaku;
        this.zzbCU = zzbCU;
    }
    
    public zzctv(final zzbp zzbp) {
        this(1, zzbp);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, (Parcelable)this.zzbCU, n, false);
        zzd.zzI(parcel, zze);
    }
}
