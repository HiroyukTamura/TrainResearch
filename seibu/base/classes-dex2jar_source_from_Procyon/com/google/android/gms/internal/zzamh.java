// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public abstract class zzamh extends zzamg
{
    private boolean zzafK;
    
    protected zzamh(final zzamj zzamj) {
        super(zzamj);
    }
    
    public final void initialize() {
        this.zzjD();
        this.zzafK = true;
    }
    
    public final boolean isInitialized() {
        return this.zzafK;
    }
    
    protected abstract void zzjD();
    
    protected final void zzkD() {
        if (!this.isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
