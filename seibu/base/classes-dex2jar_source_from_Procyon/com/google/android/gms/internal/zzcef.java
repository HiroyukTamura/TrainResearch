// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcef implements Runnable
{
    private /* synthetic */ long zzbot;
    private /* synthetic */ zzcec zzbou;
    
    zzcef(final zzcec zzbou, final long zzbot) {
        this.zzbou = zzbou;
        this.zzbot = zzbot;
    }
    
    @Override
    public final void run() {
        this.zzbou.zzK(this.zzbot);
    }
}
