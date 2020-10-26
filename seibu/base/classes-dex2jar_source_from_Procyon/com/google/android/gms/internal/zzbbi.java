// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzbbi implements ConnectionCallbacks, OnConnectionFailedListener
{
    private final boolean zzaCj;
    private zzbbj zzaCk;
    public final Api<?> zzayW;
    
    public zzbbi(final Api<?> zzayW, final boolean zzaCj) {
        this.zzayW = zzayW;
        this.zzaCj = zzaCj;
    }
    
    private final void zzpD() {
        zzbo.zzb(this.zzaCk, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
    
    @Override
    public final void onConnected(@Nullable final Bundle bundle) {
        this.zzpD();
        ((GoogleApiClient.ConnectionCallbacks)this.zzaCk).onConnected(bundle);
    }
    
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        this.zzpD();
        this.zzaCk.zza(connectionResult, this.zzayW, this.zzaCj);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.zzpD();
        ((GoogleApiClient.ConnectionCallbacks)this.zzaCk).onConnectionSuspended(n);
    }
    
    public final void zza(final zzbbj zzaCk) {
        this.zzaCk = zzaCk;
    }
}
