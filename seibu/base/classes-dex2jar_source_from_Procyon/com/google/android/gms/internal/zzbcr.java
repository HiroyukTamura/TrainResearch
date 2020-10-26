// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbcr implements ConnectionCallbacks
{
    private /* synthetic */ zzbcp zzaDN;
    private /* synthetic */ AtomicReference zzaDO;
    private /* synthetic */ zzben zzaDP;
    
    zzbcr(final zzbcp zzaDN, final AtomicReference zzaDO, final zzben zzaDP) {
        this.zzaDN = zzaDN;
        this.zzaDO = zzaDO;
        this.zzaDP = zzaDP;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        zzbcp.zza(this.zzaDN, this.zzaDO.get(), this.zzaDP, true);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
    }
}
