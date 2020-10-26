// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;

final class zzbbn implements zzbdq
{
    private /* synthetic */ zzbbk zzaCx;
    
    private zzbbn(final zzbbk zzaCx) {
        this.zzaCx = zzaCx;
    }
    
    @Override
    public final void zzc(@NonNull final ConnectionResult connectionResult) {
        this.zzaCx.zzaCv.lock();
        try {
            this.zzaCx.zzaCt = connectionResult;
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
            if (this.zzaCx.zzaCu) {
                this.zzaCx.zzaCu = false;
                this.zzaCx.zzd(n, b);
                return;
            }
            this.zzaCx.zzaCu = true;
            this.zzaCx.zzaCm.onConnectionSuspended(n);
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zzm(@Nullable final Bundle bundle) {
        this.zzaCx.zzaCv.lock();
        try {
            this.zzaCx.zzaCt = ConnectionResult.zzazX;
            this.zzaCx.zzpF();
        }
        finally {
            this.zzaCx.zzaCv.unlock();
        }
    }
}
