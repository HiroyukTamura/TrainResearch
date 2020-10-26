// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzaol implements zzanq
{
    final /* synthetic */ zzaoc zzadv;
    final /* synthetic */ int zzadw;
    private /* synthetic */ zzamj zzaiE;
    final /* synthetic */ zzaok zzaiF;
    
    zzaol(final zzaok zzaiF, final int zzadw, final zzamj zzaiE, final zzaoc zzadv) {
        this.zzaiF = zzaiF;
        this.zzadw = zzadw;
        this.zzaiE = zzaiE;
        this.zzadv = zzadv;
    }
    
    @Override
    public final void zzc(final Throwable t) {
        this.zzaiF.mHandler.post((Runnable)new zzaom(this));
    }
}
