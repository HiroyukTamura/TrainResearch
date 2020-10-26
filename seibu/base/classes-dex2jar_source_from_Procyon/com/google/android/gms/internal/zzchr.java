// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchr implements Runnable
{
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ long zzbtx;
    
    zzchr(final zzchl zzbtt, final long zzbtx) {
        this.zzbtt = zzbtt;
        this.zzbtx = zzbtx;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzwG().zzbrx.set(this.zzbtx);
        this.zzbtt.zzwF().zzyC().zzj("Minimum session duration set", this.zzbtx);
    }
}
