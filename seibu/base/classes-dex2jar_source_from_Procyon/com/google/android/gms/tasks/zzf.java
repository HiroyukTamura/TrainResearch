// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

final class zzf implements Runnable
{
    private /* synthetic */ Task zzbLT;
    private /* synthetic */ zze zzbLX;
    
    zzf(final zze zzbLX, final Task zzbLT) {
        this.zzbLX = zzbLX;
        this.zzbLT = zzbLT;
    }
    
    @Override
    public final void run() {
        synchronized (this.zzbLX.mLock) {
            if (this.zzbLX.zzbLW != null) {
                this.zzbLX.zzbLW.onComplete(this.zzbLT);
            }
        }
    }
}
