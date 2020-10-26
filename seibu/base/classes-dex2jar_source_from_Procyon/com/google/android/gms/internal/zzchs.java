// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchs implements Runnable
{
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ long zzbtx;
    
    zzchs(final zzchl zzbtt, final long zzbtx) {
        this.zzbtt = zzbtt;
        this.zzbtx = zzbtx;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzwG().zzbry.set(this.zzbtx);
        this.zzbtt.zzwF().zzyC().zzj("Session timeout duration set", this.zzbtx);
    }
}
