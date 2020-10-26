// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzced implements Runnable
{
    private /* synthetic */ long zzbot;
    private /* synthetic */ zzcec zzbou;
    private /* synthetic */ String zztD;
    
    zzced(final zzcec zzbou, final String zztD, final long zzbot) {
        this.zzbou = zzbou;
        this.zztD = zztD;
        this.zzbot = zzbot;
    }
    
    @Override
    public final void run() {
        this.zzbou.zzd(this.zztD, this.zzbot);
    }
}
