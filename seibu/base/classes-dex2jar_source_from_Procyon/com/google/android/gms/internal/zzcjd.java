// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcjd implements Runnable
{
    private /* synthetic */ long zzbot;
    private /* synthetic */ zzcja zzbuu;
    
    zzcjd(final zzcja zzbuu, final long zzbot) {
        this.zzbuu = zzbuu;
        this.zzbot = zzbot;
    }
    
    @Override
    public final void run() {
        this.zzbuu.zzae(this.zzbot);
    }
}
