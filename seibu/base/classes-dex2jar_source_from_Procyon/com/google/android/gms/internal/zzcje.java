// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcje implements Runnable
{
    private /* synthetic */ long zzbot;
    private /* synthetic */ zzcja zzbuu;
    
    zzcje(final zzcja zzbuu, final long zzbot) {
        this.zzbuu = zzbuu;
        this.zzbot = zzbot;
    }
    
    @Override
    public final void run() {
        this.zzbuu.zzaf(this.zzbot);
    }
}
