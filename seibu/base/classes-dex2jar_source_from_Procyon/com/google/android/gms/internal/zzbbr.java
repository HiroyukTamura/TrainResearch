// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Collections;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.ConnectionResult;
import java.util.Map;
import android.support.v4.util.ArrayMap;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

final class zzbbr implements OnCompleteListener<Void>
{
    private /* synthetic */ zzbbp zzaCP;
    
    private zzbbr(final zzbbp zzaCP) {
        this.zzaCP = zzaCP;
    }
    
    @Override
    public final void onComplete(@NonNull final Task<Void> task) {
        this.zzaCP.zzaCv.lock();
        Label_0342: {
            try {
                if (!this.zzaCP.zzaCK) {
                    return;
                }
                if (task.isSuccessful()) {
                    this.zzaCP.zzaCL = (Map<zzbat<?>, ConnectionResult>)new ArrayMap(this.zzaCP.zzaCB.size());
                    final Iterator<zzbbo> iterator = this.zzaCP.zzaCB.values().iterator();
                    while (iterator.hasNext()) {
                        this.zzaCP.zzaCL.put(iterator.next().zzph(), ConnectionResult.zzazX);
                    }
                    break Label_0342;
                }
            }
            finally {
                this.zzaCP.zzaCv.unlock();
            }
            final Task task2;
            if (task2.getException() instanceof zza) {
                final zza zza = (zza)task2.getException();
                if (this.zzaCP.zzaCI) {
                    this.zzaCP.zzaCL = (Map<zzbat<?>, ConnectionResult>)new ArrayMap(this.zzaCP.zzaCB.size());
                    for (final zzbbo<? extends Api.ApiOptions> zzbbo : this.zzaCP.zzaCB.values()) {
                        final zzbat<Api.ApiOptions> zzph = zzbbo.zzph();
                        final ConnectionResult zza2 = zza.zza(zzbbo);
                        if (this.zzaCP.zza(zzbbo, zza2)) {
                            this.zzaCP.zzaCL.put(zzph, new ConnectionResult(16));
                        }
                        else {
                            this.zzaCP.zzaCL.put(zzph, zza2);
                        }
                    }
                }
                else {
                    this.zzaCP.zzaCL = zza.zzpf();
                }
                this.zzaCP.zzaCO = this.zzaCP.zzpN();
            }
            else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", (Throwable)task2.getException());
                this.zzaCP.zzaCL = (Map<zzbat<?>, ConnectionResult>)Collections.emptyMap();
                this.zzaCP.zzaCO = new ConnectionResult(8);
            }
        }
        if (this.zzaCP.zzaCM != null) {
            this.zzaCP.zzaCL.putAll(this.zzaCP.zzaCM);
            this.zzaCP.zzaCO = this.zzaCP.zzpN();
        }
        if (this.zzaCP.zzaCO == null) {
            this.zzaCP.zzpL();
            this.zzaCP.zzpM();
        }
        else {
            zzbbp.zza(this.zzaCP, false);
            this.zzaCP.zzaCE.zzc(this.zzaCP.zzaCO);
        }
        this.zzaCP.zzaCG.signalAll();
        this.zzaCP.zzaCv.unlock();
    }
}
