// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.zzbr;
import com.google.android.gms.common.ConnectionResult;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzctx extends zza
{
    public static final Parcelable$Creator<zzctx> CREATOR;
    private final ConnectionResult zzaBQ;
    private int zzaku;
    private final zzbr zzbCV;
    
    static {
        CREATOR = (Parcelable$Creator)new zzcty();
    }
    
    public zzctx(final int n) {
        this(new ConnectionResult(8, null), null);
    }
    
    zzctx(final int zzaku, final ConnectionResult zzaBQ, final zzbr zzbCV) {
        this.zzaku = zzaku;
        this.zzaBQ = zzaBQ;
        this.zzbCV = zzbCV;
    }
    
    private zzctx(final ConnectionResult connectionResult, final zzbr zzbr) {
        this(1, connectionResult, null);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, (Parcelable)this.zzaBQ, n, false);
        zzd.zza(parcel, 3, (Parcelable)this.zzbCV, n, false);
        zzd.zzI(parcel, zze);
    }
    
    public final zzbr zzAx() {
        return this.zzbCV;
    }
    
    public final ConnectionResult zzpz() {
        return this.zzaBQ;
    }
}
