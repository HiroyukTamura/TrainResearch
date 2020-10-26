// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.common.zze;
import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import android.os.IBinder;
import com.google.android.gms.common.zzc;
import android.accounts.Account;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzx extends zza
{
    public static final Parcelable$Creator<zzx> CREATOR;
    private int version;
    Account zzaHA;
    zzc[] zzaHB;
    private int zzaHu;
    private int zzaHv;
    String zzaHw;
    IBinder zzaHx;
    Scope[] zzaHy;
    Bundle zzaHz;
    
    static {
        CREATOR = (Parcelable$Creator)new zzy();
    }
    
    public zzx(final int zzaHu) {
        this.version = 3;
        this.zzaHv = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzaHu = zzaHu;
    }
    
    zzx(final int version, final int zzaHu, final int zzaHv, final String s, final IBinder zzaHx, final Scope[] zzaHy, final Bundle zzaHz, final Account zzaHA, final zzc[] zzaHB) {
        final Account account = null;
        final zzal zzal = null;
        this.version = version;
        this.zzaHu = zzaHu;
        this.zzaHv = zzaHv;
        if ("com.google.android.gms".equals(s)) {
            this.zzaHw = "com.google.android.gms";
        }
        else {
            this.zzaHw = s;
        }
        if (version < 2) {
            Account zza = account;
            if (zzaHx != null) {
                zzal zzal2;
                if (zzaHx == null) {
                    zzal2 = zzal;
                }
                else {
                    final IInterface queryLocalInterface = zzaHx.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    if (queryLocalInterface instanceof zzal) {
                        zzal2 = (zzal)queryLocalInterface;
                    }
                    else {
                        zzal2 = new zzan(zzaHx);
                    }
                }
                zza = com.google.android.gms.common.internal.zza.zza(zzal2);
            }
            this.zzaHA = zza;
        }
        else {
            this.zzaHx = zzaHx;
            this.zzaHA = zzaHA;
        }
        this.zzaHy = zzaHy;
        this.zzaHz = zzaHz;
        this.zzaHB = zzaHB;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.version);
        zzd.zzc(parcel, 2, this.zzaHu);
        zzd.zzc(parcel, 3, this.zzaHv);
        zzd.zza(parcel, 4, this.zzaHw, false);
        zzd.zza(parcel, 5, this.zzaHx, false);
        zzd.zza(parcel, 6, this.zzaHy, n, false);
        zzd.zza(parcel, 7, this.zzaHz, false);
        zzd.zza(parcel, 8, (Parcelable)this.zzaHA, n, false);
        zzd.zza(parcel, 10, this.zzaHB, n, false);
        zzd.zzI(parcel, zze);
    }
}
