// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzbek implements Runnable
{
    private /* synthetic */ zzctx zzaDx;
    private /* synthetic */ zzbej zzaEY;
    
    zzbek(final zzbej zzaEY, final zzctx zzaDx) {
        this.zzaEY = zzaEY;
        this.zzaDx = zzaDx;
    }
    
    @Override
    public final void run() {
        this.zzaEY.zzc(this.zzaDx);
    }
}
