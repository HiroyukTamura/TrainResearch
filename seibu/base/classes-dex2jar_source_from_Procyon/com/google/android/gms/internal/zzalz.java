// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzalz implements Runnable
{
    private /* synthetic */ int zzafC;
    private /* synthetic */ zzaly zzafD;
    
    zzalz(final zzaly zzafD, final int zzafC) {
        this.zzafD = zzafD;
        this.zzafC = zzafC;
    }
    
    @Override
    public final void run() {
        this.zzafD.zzafB.zzr(this.zzafC * 1000L);
    }
}
