// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

final class zzj implements Runnable
{
    private /* synthetic */ Task zzbLT;
    private /* synthetic */ zzi zzbMb;
    
    zzj(final zzi zzbMb, final Task zzbLT) {
        this.zzbMb = zzbMb;
        this.zzbLT = zzbLT;
    }
    
    @Override
    public final void run() {
        synchronized (this.zzbMb.mLock) {
            if (this.zzbMb.zzbMa != null) {
                this.zzbMb.zzbMa.onSuccess(this.zzbLT.getResult());
            }
        }
    }
}
