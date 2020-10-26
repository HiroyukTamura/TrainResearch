// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcij implements Runnable
{
    private /* synthetic */ zzcid zzbua;
    
    zzcij(final zzcid zzbua) {
        this.zzbua = zzbua;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zzbua.zzwu().zzdV(this.zzbua.zzwF().zzyE()));
            this.zzbua.zzkP();
        }
        catch (RemoteException ex) {
            this.zzbua.zzwF().zzyx().zzj("Failed to send measurementEnabled to the service", ex);
        }
    }
}
