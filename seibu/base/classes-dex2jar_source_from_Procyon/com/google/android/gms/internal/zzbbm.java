// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;

final class zzbbm implements zzbdq
{
    private /* synthetic */ zzbbk zzaCx;
    
    private zzbbm(final zzbbk zzaCx) {
        this.zzaCx = zzaCx;
    }
    
    @Override
    public final void zzc(@NonNull final ConnectionResult connectionResult) {
        this.zzaCx.zzaCv.lock();
        try {
            this.zzaCx.zzaCs = connectionResult;
            this.zzaCx.zzpF();
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zze(final int n, final boolean b) {
        this.zzaCx.zzaCv.lock();
        try {
            if (this.zzaCx.zzaCu || this.zzaCx.zzaCt == null || !this.zzaCx.zzaCt.isSuccess()) {
                this.zzaCx.zzaCu = false;
                this.zzaCx.zzd(n, b);
                return;
            }
            this.zzaCx.zzaCu = true;
            this.zzaCx.zzaCn.onConnectionSuspended(n);
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zzm(@Nullable final Bundle bundle) {
        this.zzaCx.zzaCv.lock();
        try {
            this.zzaCx.zzl(bundle);
            this.zzaCx.zzaCs = ConnectionResult.zzazX;
            this.zzaCx.zzpF();
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
}
