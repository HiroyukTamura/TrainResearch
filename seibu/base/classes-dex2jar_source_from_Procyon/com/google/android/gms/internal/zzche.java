// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzche implements Runnable
{
    private /* synthetic */ zzceh zzbte;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ zzcji zzbtk;
    
    zzche(final zzcgq zzbtf, final zzcji zzbtk, final zzceh zzbte) {
        this.zzbtf = zzbtf;
        this.zzbtk = zzbtk;
        this.zzbte = zzbte;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zzb(this.zzbtk, this.zzbte);
    }
}
