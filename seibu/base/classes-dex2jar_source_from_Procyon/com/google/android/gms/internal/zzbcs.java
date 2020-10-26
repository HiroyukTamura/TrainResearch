// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbcs implements OnConnectionFailedListener
{
    private /* synthetic */ zzben zzaDP;
    
    zzbcs(final zzbcp zzbcp, final zzben zzaDP) {
        this.zzaDP = zzaDP;
    }
    
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        this.zzaDP.setResult(new Status(8));
    }
}
