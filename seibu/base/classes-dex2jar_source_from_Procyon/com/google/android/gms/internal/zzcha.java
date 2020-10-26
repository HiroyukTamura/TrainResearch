// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcha implements Runnable
{
    private /* synthetic */ zzceh zzbte;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcez zzbtj;
    
    zzcha(final zzcgq zzbtf, final zzcez zzbtj, final zzceh zzbte) {
        this.zzbtf = zzbtf;
        this.zzbtj = zzbtj;
        this.zzbte = zzbte;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzb(this.zzbtj, this.zzbte);
    }
}
