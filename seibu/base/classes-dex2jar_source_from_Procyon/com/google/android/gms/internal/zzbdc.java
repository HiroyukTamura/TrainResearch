// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzbdc implements zzbax
{
    private /* synthetic */ zzbdb zzaEm;
    
    zzbdc(final zzbdb zzaEm) {
        this.zzaEm = zzaEm;
    }
    
    @Override
    public final void zzac(final boolean b) {
        this.zzaEm.mHandler.sendMessage(this.zzaEm.mHandler.obtainMessage(1, (Object)b));
    }
}
