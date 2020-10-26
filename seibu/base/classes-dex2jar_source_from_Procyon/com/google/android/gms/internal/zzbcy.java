// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

abstract class zzbcy
{
    private final zzbcw zzaDZ;
    
    protected zzbcy(final zzbcw zzaDZ) {
        this.zzaDZ = zzaDZ;
    }
    
    public final void zzc(final zzbcx zzbcx) {
        zzbcx.zzaCv.lock();
        try {
            if (zzbcx.zzaDV != this.zzaDZ) {
                return;
            }
            this.zzpV();
        }
        finally {
            zzbcx.zzaCv.unlock();
        }
    }
    
    protected abstract void zzpV();
}
