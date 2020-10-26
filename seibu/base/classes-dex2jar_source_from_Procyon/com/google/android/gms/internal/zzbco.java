// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Collections;
import com.google.android.gms.common.api.Api;

public final class zzbco implements zzbcw
{
    private final zzbcx zzaCZ;
    
    public zzbco(final zzbcx zzaCZ) {
        this.zzaCZ = zzaCZ;
    }
    
    @Override
    public final void begin() {
        final Iterator<Api.zze> iterator = this.zzaCZ.zzaDF.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().disconnect();
        }
        this.zzaCZ.zzaCl.zzaDG = Collections.emptySet();
    }
    
    @Override
    public final void connect() {
        this.zzaCZ.zzqh();
    }
    
    @Override
    public final boolean disconnect() {
        return true;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
    }
    
    @Override
    public final void zza(final ConnectionResult connectionResult, final Api<?> api, final boolean b) {
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(final T t) {
        this.zzaCZ.zzaCl.zzaCJ.add(t);
        return t;
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(final T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
