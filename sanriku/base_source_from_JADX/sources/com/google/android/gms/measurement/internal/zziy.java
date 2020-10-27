package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

final class zziy implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzw zzb;
    private final /* synthetic */ zzis zzc;

    zziy(zzis zzis, zzn zzn, zzw zzw) {
        this.zzc = zzis;
        this.zza = zzn;
        this.zzb = zzw;
    }

    public final void run() {
        String str = null;
        try {
            zzer zzd = this.zzc.zzb;
            if (zzd == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
            } else {
                str = zzd.zzc(this.zza);
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzak();
            }
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } catch (Throwable th) {
            this.zzc.zzp().zza(this.zzb, (String) null);
            throw th;
        }
        this.zzc.zzp().zza(this.zzb, str);
    }
}
