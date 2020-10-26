// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaa implements zzf
{
    private /* synthetic */ GoogleApiClient.ConnectionCallbacks zzaHC;
    
    zzaa(final GoogleApiClient.ConnectionCallbacks zzaHC) {
        this.zzaHC = zzaHC;
    }
    
    @Override
    public final void onConnected(@Nullable final Bundle bundle) {
        this.zzaHC.onConnected(bundle);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.zzaHC.onConnectionSuspended(n);
    }
}
