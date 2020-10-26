// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zza;

final class zzcio implements Runnable
{
    private /* synthetic */ zzcji zzbtk;
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ boolean zzbue;
    
    zzcio(final zzcid zzbua, final boolean zzbue, final zzcji zzbtk) {
        this.zzbua = zzbua;
        this.zzbue = zzbue;
        this.zzbtk = zzbtk;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Discarding data. Failed to set user attribute");
            return;
        }
        final zzcid zzbua = this.zzbua;
        zza zzbtk;
        if (this.zzbue) {
            zzbtk = null;
        }
        else {
            zzbtk = this.zzbtk;
        }
        zzbua.zza(zzd, zzbtk);
        this.zzbua.zzkP();
    }
}
