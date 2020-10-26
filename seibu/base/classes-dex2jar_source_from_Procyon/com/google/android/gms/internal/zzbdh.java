// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzj;

final class zzbdh implements zzj, zzbel
{
    private final zzbat<?> zzaAK;
    private final Api.zze zzaCy;
    private zzal zzaDl;
    final /* synthetic */ zzbdb zzaEm;
    private boolean zzaEx;
    private Set<Scope> zzame;
    
    public zzbdh(final zzbdb zzaEm, final Api.zze zzaCy, final zzbat<?> zzaAK) {
        this.zzaEm = zzaEm;
        this.zzaDl = null;
        this.zzame = null;
        this.zzaEx = false;
        this.zzaCy = zzaCy;
        this.zzaAK = zzaAK;
    }
    
    @WorkerThread
    private final void zzqz() {
        if (this.zzaEx && this.zzaDl != null) {
            this.zzaCy.zza(this.zzaDl, this.zzame);
        }
    }
    
    @WorkerThread
    @Override
    public final void zzb(final zzal zzaDl, final Set<Scope> zzame) {
        if (zzaDl == null || zzame == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", (Throwable)new Exception());
            this.zzh(new ConnectionResult(4));
            return;
        }
        this.zzaDl = zzaDl;
        this.zzame = zzame;
        this.zzqz();
    }
    
    @Override
    public final void zzf(@NonNull final ConnectionResult connectionResult) {
        this.zzaEm.mHandler.post((Runnable)new zzbdi(this, connectionResult));
    }
    
    @WorkerThread
    @Override
    public final void zzh(final ConnectionResult connectionResult) {
        this.zzaEm.zzaCB.get(this.zzaAK).zzh(connectionResult);
    }
}
