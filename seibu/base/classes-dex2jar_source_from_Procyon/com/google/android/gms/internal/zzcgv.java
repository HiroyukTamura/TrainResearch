// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcgv implements Runnable
{
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcek zzbtg;
    
    zzcgv(final zzcgq zzbtf, final zzcek zzbtg) {
        this.zzbtf = zzbtf;
        this.zzbtg = zzbtg;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzd(this.zzbtg);
    }
}
