// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

abstract class zzchj extends zzchi
{
    private boolean zzafK;
    
    zzchj(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzboe.zzb(this);
    }
    
    public final void initialize() {
        if (this.zzafK) {
            throw new IllegalStateException("Can't initialize twice");
        }
        this.zzjD();
        this.zzboe.zzzd();
        this.zzafK = true;
    }
    
    final boolean isInitialized() {
        return this.zzafK;
    }
    
    protected abstract void zzjD();
    
    protected final void zzkD() {
        if (!this.isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
