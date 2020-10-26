// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzamc implements Runnable
{
    private /* synthetic */ zzaly zzafD;
    private /* synthetic */ zzanx zzafH;
    
    zzamc(final zzaly zzafD, final zzanx zzafH) {
        this.zzafD = zzafD;
        this.zzafH = zzafH;
    }
    
    @Override
    public final void run() {
        this.zzafD.zzafB.zza(this.zzafH);
    }
}
