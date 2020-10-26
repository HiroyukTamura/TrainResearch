// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzab implements zzg
{
    private /* synthetic */ GoogleApiClient.OnConnectionFailedListener zzaHD;
    
    zzab(final GoogleApiClient.OnConnectionFailedListener zzaHD) {
        this.zzaHD = zzaHD;
    }
    
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        this.zzaHD.onConnectionFailed(connectionResult);
    }
}
