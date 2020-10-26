// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbx;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Api;
import android.os.Bundle;
import java.util.Iterator;
import com.google.android.gms.common.ConnectionResult;

public final class zzbca implements zzbcw
{
    private final zzbcx zzaCZ;
    private boolean zzaDa;
    
    public zzbca(final zzbcx zzaCZ) {
        this.zzaDa = false;
        this.zzaCZ = zzaCZ;
    }
    
    @Override
    public final void begin() {
    }
    
    @Override
    public final void connect() {
        if (this.zzaDa) {
            this.zzaDa = false;
            this.zzaCZ.zza(new zzbcc(this, this));
        }
    }
    
    @Override
    public final boolean disconnect() {
        if (this.zzaDa) {
            return false;
        }
        if (this.zzaCZ.zzaCl.zzqf()) {
            this.zzaDa = true;
            final Iterator<zzbes> iterator = this.zzaCZ.zzaCl.zzaDK.iterator();
            while (iterator.hasNext()) {
                iterator.next().zzqK();
            }
            return false;
        }
        this.zzaCZ.zzg(null);
        return true;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.zzaCZ.zzg(null);
        this.zzaCZ.zzaDY.zze(n, this.zzaDa);
    }
    
    @Override
    public final void zza(final ConnectionResult connectionResult, final Api<?> api, final boolean b) {
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(final T t) {
        return this.zze(t);
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(final T t) {
        try {
            this.zzaCZ.zzaCl.zzaDL.zzb(t);
            final Api.zze zze = this.zzaCZ.zzaCl.zzaDF.get(t.zzpd());
            zzbo.zzb(zze, "Appropriate Api was not requested.");
            if (!zze.isConnected() && this.zzaCZ.zzaDU.containsKey(t.zzpd())) {
                t.zzr(new Status(17));
                return t;
            }
            Api.zzb zzb = zze;
            if (zze instanceof zzbx) {
                final zzbx zzbx = (zzbx)zze;
                zzb = null;
            }
            ((zzbay<R, A>)t).zzb((A)zzb);
            return t;
        }
        catch (DeadObjectException ex) {
            this.zzaCZ.zza(new zzbcb(this, this));
            return t;
        }
    }
    
    final void zzpU() {
        if (this.zzaDa) {
            this.zzaDa = false;
            this.zzaCZ.zzaCl.zzaDL.release();
            this.disconnect();
        }
    }
}
