// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

final class zzh implements Runnable
{
    private /* synthetic */ Task zzbLT;
    private /* synthetic */ zzg zzbLZ;
    
    zzh(final zzg zzbLZ, final Task zzbLT) {
        this.zzbLZ = zzbLZ;
        this.zzbLT = zzbLT;
    }
    
    @Override
    public final void run() {
        synchronized (this.zzbLZ.mLock) {
            if (this.zzbLZ.zzbLY != null) {
                this.zzbLZ.zzbLY.onFailure(this.zzbLT.getException());
            }
        }
    }
}
