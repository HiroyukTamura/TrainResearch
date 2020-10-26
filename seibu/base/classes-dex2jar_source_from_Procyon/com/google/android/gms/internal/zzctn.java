// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import android.content.Intent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzctn extends zza implements Result
{
    public static final Parcelable$Creator<zzctn> CREATOR;
    private int zzaku;
    private int zzbCR;
    private Intent zzbCS;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcto();
    }
    
    public zzctn() {
        this(0, null);
    }
    
    zzctn(final int zzaku, final int zzbCR, final Intent zzbCS) {
        this.zzaku = zzaku;
        this.zzbCR = zzbCR;
        this.zzbCS = zzbCS;
    }
    
    private zzctn(final int n, final Intent intent) {
        this(2, 0, null);
    }
    
    @Override
    public final Status getStatus() {
        if (this.zzbCR == 0) {
            return Status.zzaBm;
        }
        return Status.zzaBq;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zzc(parcel, 2, this.zzbCR);
        zzd.zza(parcel, 3, (Parcelable)this.zzbCS, n, false);
        zzd.zzI(parcel, zze);
    }
}
