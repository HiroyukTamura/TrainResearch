// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchd implements Runnable
{
    private /* synthetic */ zzceh zzbte;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcji zzbtk;
    
    zzchd(final zzcgq zzbtf, final zzcji zzbtk, final zzceh zzbte) {
        this.zzbtf = zzbtf;
        this.zzbtk = zzbtk;
        this.zzbte = zzbte;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzc(this.zzbtk, this.zzbte);
    }
}
