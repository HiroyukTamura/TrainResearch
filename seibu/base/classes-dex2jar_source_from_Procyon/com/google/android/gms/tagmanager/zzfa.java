// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ee;

final class zzfa implements Runnable
{
    private /* synthetic */ zzey zzbGc;
    private /* synthetic */ ee zzbGd;
    
    zzfa(final zzey zzbGc, final ee zzbGd) {
        this.zzbGc = zzbGc;
        this.zzbGd = zzbGd;
    }
    
    @Override
    public final void run() {
        this.zzbGc.zzb(this.zzbGd);
    }
}
