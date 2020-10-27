package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zziw implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzis zzb;

    zziw(zzis zzis, zzn zzn) {
        this.zzb = zzis;
        this.zza = zzn;
    }

    public final void run() {
        zzer zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzak();
    }
}
