// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;

public final class zzm implements zzj
{
    private /* synthetic */ zzd zzaHe;
    
    public zzm(final zzd zzaHe) {
        this.zzaHe = zzaHe;
    }
    
    @Override
    public final void zzf(@NonNull final ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.zzaHe.zza(null, this.zzaHe.zzrh());
        }
        else if (this.zzaHe.zzaGW != null) {
            this.zzaHe.zzaGW.onConnectionFailed(connectionResult);
        }
    }
}
