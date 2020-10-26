// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzama implements Runnable
{
    private /* synthetic */ zzaly zzafD;
    private /* synthetic */ boolean zzafE;
    
    zzama(final zzaly zzafD, final boolean zzafE) {
        this.zzafD = zzafD;
        this.zzafE = zzafE;
    }
    
    @Override
    public final void run() {
        this.zzafD.zzafB.zzld();
    }
}
