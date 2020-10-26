// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcee implements Runnable
{
    private /* synthetic */ long zzbot;
    private /* synthetic */ zzcec zzbou;
    private /* synthetic */ String zztD;
    
    zzcee(final zzcec zzbou, final String zztD, final long zzbot) {
        this.zzbou = zzbou;
        this.zztD = zztD;
        this.zzbot = zzbot;
    }
    
    @Override
    public final void run() {
        this.zzbou.zze(this.zztD, this.zzbot);
    }
}
