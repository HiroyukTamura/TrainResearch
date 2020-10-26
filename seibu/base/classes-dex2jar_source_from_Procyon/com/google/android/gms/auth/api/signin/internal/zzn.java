// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzn extends zza
{
    public static final Parcelable$Creator<zzn> CREATOR;
    private Bundle mBundle;
    private int versionCode;
    private int zzamr;
    
    static {
        CREATOR = (Parcelable$Creator)new zzm();
    }
    
    zzn(final int versionCode, final int zzamr, final Bundle mBundle) {
        this.versionCode = versionCode;
        this.zzamr = zzamr;
        this.mBundle = mBundle;
    }
    
    public zzn(final GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        this(1, 1, googleSignInOptionsExtension.toBundle());
    }
    
    public final int getType() {
        return this.zzamr;
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.versionCode);
        zzd.zzc(parcel, 2, this.zzamr);
        zzd.zza(parcel, 3, this.mBundle, false);
        zzd.zzI(parcel, zze);
    }
}
