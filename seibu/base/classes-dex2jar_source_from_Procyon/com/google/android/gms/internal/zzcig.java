// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.zza;

final class zzcig implements Runnable
{
    private /* synthetic */ zzcid zzbua;
    
    zzcig(final zzcid zzbua) {
        this.zzbua = zzbua;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zzbua.zzwu().zzdV(this.zzbua.zzwF().zzyE()));
            this.zzbua.zza(zzd, null);
            this.zzbua.zzkP();
        }
        catch (RemoteException ex) {
            this.zzbua.zzwF().zzyx().zzj("Failed to send app launch to the service", ex);
        }
    }
}
