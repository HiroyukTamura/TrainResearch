package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzja implements Runnable {
    private final /* synthetic */ zzik zza;
    private final /* synthetic */ zzis zzb;

    zzja(zzis zzis, zzik zzik) {
        this.zzb = zzis;
        this.zza = zzik;
    }

    public final void run() {
        long j;
        String str;
        String str2;
        String packageName;
        zzer zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzb.zzn().getPackageName();
            } else {
                j = this.zza.zzc;
                str = this.zza.zza;
                str2 = this.zza.zzb;
                packageName = this.zzb.zzn().getPackageName();
            }
            zzd.zza(j, str, str2, packageName);
            this.zzb.zzak();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
