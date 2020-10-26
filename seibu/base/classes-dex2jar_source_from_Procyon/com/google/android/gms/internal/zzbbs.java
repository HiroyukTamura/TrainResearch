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

final class zzbbs implements OnCompleteListener<Void>
{
    private /* synthetic */ zzbbp zzaCP;
    private zzbei zzaCQ;
    
    zzbbs(final zzbbp zzaCP, final zzbei zzaCQ) {
        this.zzaCP = zzaCP;
        this.zzaCQ = zzaCQ;
    }
    
    final void cancel() {
        this.zzaCQ.zzmF();
    }
    
    @Override
    public final void onComplete(@NonNull final Task<Void> task) {
        this.zzaCP.zzaCv.lock();
        Label_0330: {
            try {
                if (!this.zzaCP.zzaCK) {
                    this.zzaCQ.zzmF();
                    return;
                }
                if (task.isSuccessful()) {
                    this.zzaCP.zzaCM = (Map<zzbat<?>, ConnectionResult>)new ArrayMap(this.zzaCP.zzaCC.size());
                    final Iterator<zzbbo> iterator = this.zzaCP.zzaCC.values().iterator();
                    while (iterator.hasNext()) {
                        this.zzaCP.zzaCM.put(iterator.next().zzph(), ConnectionResult.zzazX);
                    }
                    break Label_0330;
                }
            }
            finally {
                this.zzaCP.zzaCv.unlock();
            }
            final Task task2;
            if (task2.getException() instanceof zza) {
                final zza zza = (zza)task2.getException();
                if (this.zzaCP.zzaCI) {
                    this.zzaCP.zzaCM = (Map<zzbat<?>, ConnectionResult>)new ArrayMap(this.zzaCP.zzaCC.size());
                    for (final zzbbo<? extends Api.ApiOptions> zzbbo : this.zzaCP.zzaCC.values()) {
                        final zzbat<Api.ApiOptions> zzph = zzbbo.zzph();
                        final ConnectionResult zza2 = zza.zza(zzbbo);
                        if (this.zzaCP.zza(zzbbo, zza2)) {
                            this.zzaCP.zzaCM.put(zzph, new ConnectionResult(16));
                        }
                        else {
                            this.zzaCP.zzaCM.put(zzph, zza2);
                        }
                    }
                }
                else {
                    this.zzaCP.zzaCM = zza.zzpf();
                }
            }
            else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", (Throwable)task2.getException());
                this.zzaCP.zzaCM = (Map<zzbat<?>, ConnectionResult>)Collections.emptyMap();
            }
        }
        if (this.zzaCP.isConnected()) {
            this.zzaCP.zzaCL.putAll(this.zzaCP.zzaCM);
            if (this.zzaCP.zzpN() == null) {
                this.zzaCP.zzpL();
                this.zzaCP.zzpM();
                this.zzaCP.zzaCG.signalAll();
            }
        }
        this.zzaCQ.zzmF();
        this.zzaCP.zzaCv.unlock();
    }
}
