// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchm implements Runnable
{
    private /* synthetic */ boolean val$enabled;
    private /* synthetic */ zzchl zzbtt;
    
    zzchm(final zzchl zzbtt, final boolean val$enabled) {
        this.zzbtt = zzbtt;
        this.val$enabled = val$enabled;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzan(this.val$enabled);
    }
}
