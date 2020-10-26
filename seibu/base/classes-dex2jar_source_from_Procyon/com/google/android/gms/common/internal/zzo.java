// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import android.support.annotation.BinderThread;
import android.os.Bundle;
import android.support.annotation.Nullable;

public final class zzo extends zze
{
    private /* synthetic */ zzd zzaHe;
    
    @BinderThread
    public zzo(final zzd zzaHe, @Nullable final int n, final Bundle bundle) {
        this.zzaHe = zzaHe;
        super(zzaHe, n, null);
    }
    
    @Override
    protected final void zzj(final ConnectionResult connectionResult) {
        this.zzaHe.zzaGQ.zzf(connectionResult);
        this.zzaHe.onConnectionFailed(connectionResult);
    }
    
    @Override
    protected final boolean zzrj() {
        this.zzaHe.zzaGQ.zzf(ConnectionResult.zzazX);
        return true;
    }
}
