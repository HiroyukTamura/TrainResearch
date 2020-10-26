// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

final class zzbet implements Runnable
{
    private /* synthetic */ Result zzaFh;
    private /* synthetic */ zzbes zzaFi;
    
    zzbet(final zzbes zzaFi, final Result zzaFh) {
        this.zzaFi = zzaFi;
        this.zzaFh = zzaFh;
    }
    
    @WorkerThread
    @Override
    public final void run() {
        try {
            zzbbe.zzaBV.set(true);
            this.zzaFi.zzaFf.sendMessage(this.zzaFi.zzaFf.obtainMessage(0, (Object)this.zzaFi.zzaFa.onSuccess(this.zzaFh)));
        }
        catch (RuntimeException ex) {
            this.zzaFi.zzaFf.sendMessage(this.zzaFi.zzaFf.obtainMessage(1, (Object)ex));
        }
        finally {
            zzbbe.zzaBV.set(false);
            zzbes.zza(this.zzaFi, this.zzaFh);
            final GoogleApiClient googleApiClient = (GoogleApiClient)this.zzaFi.zzaBY.get();
            if (googleApiClient != null) {
                googleApiClient.zzb(this.zzaFi);
            }
        }
    }
}
