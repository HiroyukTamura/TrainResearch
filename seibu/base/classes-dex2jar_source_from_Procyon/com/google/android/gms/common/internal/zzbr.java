// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbr extends zza
{
    public static final Parcelable$Creator<zzbr> CREATOR;
    private ConnectionResult zzaBQ;
    private boolean zzaDm;
    private IBinder zzaIq;
    private boolean zzaIr;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbs();
    }
    
    zzbr(final int zzaku, final IBinder zzaIq, final ConnectionResult zzaBQ, final boolean zzaDm, final boolean zzaIr) {
        this.zzaku = zzaku;
        this.zzaIq = zzaIq;
        this.zzaBQ = zzaBQ;
        this.zzaDm = zzaDm;
        this.zzaIr = zzaIr;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof zzbr)) {
                return false;
            }
            final zzbr zzbr = (zzbr)o;
            if (!this.zzaBQ.equals(zzbr.zzaBQ) || !this.zzrH().equals(zzbr.zzrH())) {
                return false;
            }
        }
        return true;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.zzaIq, false);
        zzd.zza(parcel, 3, (Parcelable)this.zzaBQ, n, false);
        zzd.zza(parcel, 4, this.zzaDm);
        zzd.zza(parcel, 5, this.zzaIr);
        zzd.zzI(parcel, zze);
    }
    
    public final ConnectionResult zzpz() {
        return this.zzaBQ;
    }
    
    public final zzal zzrH() {
        final IBinder zzaIq = this.zzaIq;
        if (zzaIq == null) {
            return null;
        }
        final IInterface queryLocalInterface = zzaIq.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        if (queryLocalInterface instanceof zzal) {
            return (zzal)queryLocalInterface;
        }
        return new zzan(zzaIq);
    }
    
    public final boolean zzrI() {
        return this.zzaDm;
    }
    
    public final boolean zzrJ() {
        return this.zzaIr;
    }
}
