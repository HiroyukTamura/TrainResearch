package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzns;
import java.util.concurrent.atomic.AtomicReference;

final class zzhp implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhh zzb;

    zzhp(zzhh zzhh, long j) {
        this.zzb = zzhh;
        this.zza = j;
    }

    public final void run() {
        zzhh zzhh = this.zzb;
        long j = this.zza;
        zzhh.zzd();
        zzhh.zzb();
        zzhh.zzw();
        zzhh.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjw zzk = zzhh.zzk();
        zzk.zzd();
        zzk.zzb.zza();
        boolean zzab = zzhh.zzy.zzab();
        zzfl zzs = zzhh.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzu.zza())) {
            zzs.zzu.zza((String) null);
        }
        if (zzns.zzb() && zzs.zzt().zza(zzaq.zzbv)) {
            zzs.zzp.zza(0);
        }
        if (!zzs.zzt().zzh()) {
            zzs.zzc(!zzab);
        }
        zzs.zzv.zza((String) null);
        zzs.zzw.zza(0);
        zzs.zzx.zza((Bundle) null);
        zzhh.zzh().zzad();
        if (zzns.zzb() && zzhh.zzt().zza(zzaq.zzbv)) {
            zzhh.zzk().zza.zza();
        }
        zzhh.zzc = !zzab;
        this.zzb.zzh().zza((AtomicReference<String>) new AtomicReference());
    }
}
