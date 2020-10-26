// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchg implements Runnable
{
    private /* synthetic */ zzceh zzbte;
    private /* synthetic */ zzcgq zzbtf;
    
    zzchg(final zzcgq zzbtf, final zzceh zzbte) {
        this.zzbtf = zzbtf;
        this.zzbte = zzbte;
    }
    
    @Override
    public final void run() {
        this.zzbtf.zzboe.zzze();
        this.zzbtf.zzboe.zze(this.zzbte);
    }
}
