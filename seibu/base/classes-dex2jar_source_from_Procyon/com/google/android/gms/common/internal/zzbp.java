// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbp extends zza
{
    public static final Parcelable$Creator<zzbp> CREATOR;
    private final int zzaIo;
    private final GoogleSignInAccount zzaIp;
    private final Account zzajb;
    private int zzaku;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbq();
    }
    
    zzbp(final int zzaku, final Account zzajb, final int zzaIo, final GoogleSignInAccount zzaIp) {
        this.zzaku = zzaku;
        this.zzajb = zzajb;
        this.zzaIo = zzaIo;
        this.zzaIp = zzaIp;
    }
    
    public zzbp(final Account account, final int n, final GoogleSignInAccount googleSignInAccount) {
        this(2, account, n, googleSignInAccount);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, (Parcelable)this.zzajb, n, false);
        zzd.zzc(parcel, 3, this.zzaIo);
        zzd.zza(parcel, 4, (Parcelable)this.zzaIp, n, false);
        zzd.zzI(parcel, zze);
    }
}
