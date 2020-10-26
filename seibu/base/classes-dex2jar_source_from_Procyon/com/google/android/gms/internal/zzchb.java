// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchb implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcez zzbtj;
    
    zzchb(final zzcgq zzbtf, final zzcez zzbtj, final String zzbjh) {
        this.zzbtf = zzbtf;
        this.zzbtj = zzbtj;
        this.zzbjh = zzbjh;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzb(this.zzbtj, this.zzbjh);
    }
}
