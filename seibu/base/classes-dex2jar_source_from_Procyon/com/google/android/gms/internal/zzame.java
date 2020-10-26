// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzame implements Runnable
{
    private /* synthetic */ zzaly zzafD;
    private /* synthetic */ zzanq zzafI;
    
    zzame(final zzaly zzafD, final zzanq zzafI) {
        this.zzafD = zzafD;
        this.zzafI = zzafI;
    }
    
    @Override
    public final void run() {
        this.zzafD.zzafB.zzb(this.zzafI);
    }
}
