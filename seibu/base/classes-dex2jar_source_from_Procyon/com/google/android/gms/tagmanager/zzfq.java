// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzfq implements Runnable
{
    private /* synthetic */ zzfo zzbGP;
    
    zzfq(final zzfo zzbGP) {
        this.zzbGP = zzbGP;
    }
    
    @Override
    public final void run() {
        this.zzbGP.zzbGE.dispatch();
    }
}
