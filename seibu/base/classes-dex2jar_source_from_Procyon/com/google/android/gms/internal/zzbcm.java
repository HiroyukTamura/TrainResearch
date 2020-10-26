// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbcm implements ConnectionCallbacks, OnConnectionFailedListener
{
    private /* synthetic */ zzbcd zzaDp;
    
    private zzbcm(final zzbcd zzaDp) {
        this.zzaDp = zzaDp;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        this.zzaDp.zzaDh.zza(new zzbck(this.zzaDp));
    }
    
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        this.zzaDp.zzaCv.lock();
        try {
            if (this.zzaDp.zzd(connectionResult)) {
                this.zzaDp.zzpZ();
                this.zzaDp.zzpX();
            }
            else {
                this.zzaDp.zze(connectionResult);
            }
        }
        finally {
            this.zzaDp.zzaCv.unlock();
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
    }
}
