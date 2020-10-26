// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import android.accounts.Account;
import com.google.android.gms.internal.zzbas;
import com.google.android.gms.common.internal.zzbo;
import android.os.Looper;
import com.google.android.gms.internal.zzbem;

public final class zzd
{
    private zzbem zzaAM;
    private Looper zzrM;
    
    public final zzd zza(final Looper zzrM) {
        zzbo.zzb(zzrM, "Looper must not be null.");
        this.zzrM = zzrM;
        return this;
    }
    
    public final zzd zza(final zzbem zzaAM) {
        zzbo.zzb(zzaAM, "StatusExceptionMapper must not be null.");
        this.zzaAM = zzaAM;
        return this;
    }
    
    public final GoogleApi.zza zzpj() {
        if (this.zzaAM == null) {
            this.zzaAM = new zzbas();
        }
        if (this.zzrM == null) {
            if (Looper.myLooper() != null) {
                this.zzrM = Looper.myLooper();
            }
            else {
                this.zzrM = Looper.getMainLooper();
            }
        }
        return new GoogleApi.zza(this.zzaAM, null, this.zzrM, null);
    }
}
