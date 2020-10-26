// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcih implements Runnable
{
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ AppMeasurement.zzb zzbuc;
    
    zzcih(final zzcid zzbua, final AppMeasurement.zzb zzbuc) {
        this.zzbua = zzbua;
        this.zzbuc = zzbuc;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Failed to send current screen to service");
            return;
        }
        while (true) {
            while (true) {
                try {
                    if (this.zzbuc == null) {
                        zzd.zza(0L, null, null, this.zzbua.getContext().getPackageName());
                        this.zzbua.zzkP();
                        return;
                    }
                }
                catch (RemoteException ex) {
                    this.zzbua.zzwF().zzyx().zzj("Failed to send current screen to the service", ex);
                    return;
                }
                zzd.zza(this.zzbuc.zzbol, this.zzbuc.zzboj, this.zzbuc.zzbok, this.zzbua.getContext().getPackageName());
                continue;
            }
        }
    }
}
