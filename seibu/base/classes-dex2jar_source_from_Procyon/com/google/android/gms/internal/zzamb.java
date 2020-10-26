// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzamb implements Runnable
{
    private /* synthetic */ zzaly zzafD;
    private /* synthetic */ String zzafF;
    private /* synthetic */ Runnable zzafG;
    
    zzamb(final zzaly zzafD, final String zzafF, final Runnable zzafG) {
        this.zzafD = zzafD;
        this.zzafF = zzafF;
        this.zzafG = zzafG;
    }
    
    @Override
    public final void run() {
        this.zzafD.zzafB.zzbw(this.zzafF);
        if (this.zzafG != null) {
            this.zzafG.run();
        }
    }
}
