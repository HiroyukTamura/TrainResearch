package com.google.android.gms.measurement.internal;

final /* synthetic */ class zzhj implements Runnable {
    private final zzhh zza;

    zzhj(zzhh zzhh) {
        this.zza = zzhh;
    }

    public final void run() {
        zzhh zzhh = this.zza;
        zzhh.zzd();
        if (zzhh.zzs().zzs.zza()) {
            zzhh.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhh.zzs().zzt.zza();
        zzhh.zzs().zzt.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhh.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhh.zzs().zzs.zza(true);
            return;
        }
        zzhh.zzy.zzah();
    }
}
