// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;

abstract class zzbcn implements Runnable
{
    private /* synthetic */ zzbcd zzaDp;
    
    private zzbcn(final zzbcd zzaDp) {
        this.zzaDp = zzaDp;
    }
    
    @WorkerThread
    @Override
    public void run() {
        this.zzaDp.zzaCv.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            this.zzpV();
        }
        catch (RuntimeException ex) {
            this.zzaDp.zzaCZ.zza(ex);
        }
        finally {
            this.zzaDp.zzaCv.unlock();
        }
    }
    
    @WorkerThread
    protected abstract void zzpV();
}
