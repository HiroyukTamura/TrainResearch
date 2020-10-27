package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class zzkd implements Runnable {
    private final zzka zza;

    zzkd(zzka zzka) {
        this.zza = zzka;
    }

    public final void run() {
        zzka zzka = this.zza;
        zzkb zzkb = zzka.zzc;
        long j = zzka.zza;
        long j2 = zzka.zzb;
        zzkb.zza.zzd();
        zzkb.zza.zzr().zzw().zza("Application going to the background");
        boolean z = true;
        if (zzkb.zza.zzt().zza(zzaq.zzcc)) {
            zzkb.zza.zzs().zzr.zza(true);
        }
        Bundle bundle = new Bundle();
        if (!zzkb.zza.zzt().zzj().booleanValue()) {
            zzkb.zza.zzb.zzb(j2);
            if (zzkb.zza.zzt().zza(zzaq.zzbr)) {
                bundle.putLong("_et", zzkb.zza.zza(j2));
                zzin.zza(zzkb.zza.zzi().zza(true), bundle, true);
            } else {
                z = false;
            }
            zzkb.zza.zza(false, z, j2);
        }
        zzkb.zza.zzf().zza("auto", "_ab", j, bundle);
    }
}
