package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzof;

final /* synthetic */ class zzhg implements Runnable {
    private final zzhh zza;
    private final Bundle zzb;

    zzhg(zzhh zzhh, Bundle bundle) {
        this.zza = zzhh;
        this.zzb = bundle;
    }

    public final void run() {
        zzhh zzhh = this.zza;
        Bundle bundle = this.zzb;
        if (zzof.zzb() && zzhh.zzt().zza(zzaq.zzcm)) {
            if (bundle == null) {
                zzhh.zzs().zzx.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzhh.zzs().zzx.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzhh.zzp();
                    if (zzkw.zza(obj)) {
                        zzhh.zzp().zza(27, (String) null, (String) null, 0);
                    }
                    zzhh.zzr().zzk().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzkw.zze(str)) {
                    zzhh.zzr().zzk().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzhh.zzp().zza("param", str, 100, obj)) {
                    zzhh.zzp().zza(zza2, str, obj);
                }
            }
            zzhh.zzp();
            if (zzkw.zza(zza2, zzhh.zzt().zze())) {
                zzhh.zzp().zza(26, (String) null, (String) null, 0);
                zzhh.zzr().zzk().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzhh.zzs().zzx.zza(zza2);
            zzhh.zzh().zza(zza2);
        }
    }
}
