// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcgs implements Runnable
{
    private /* synthetic */ zzceh zzbte;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcek zzbtg;
    
    zzcgs(final zzcgq zzbtf, final zzcek zzbtg, final zzceh zzbte) {
        this.zzbtf = zzbtf;
        this.zzbtg = zzbtg;
        this.zzbte = zzbte;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzc(this.zzbtg, this.zzbte);
    }
}
