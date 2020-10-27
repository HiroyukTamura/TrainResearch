package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

final class zzjc implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzw zzc;
    private final /* synthetic */ zzis zzd;

    zzjc(zzis zzis, zzao zzao, String str, zzw zzw) {
        this.zzd = zzis;
        this.zza = zzao;
        this.zzb = str;
        this.zzc = zzw;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzer zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
            } else {
                bArr = zzd2.zza(this.zza, this.zzb);
                this.zzd.zzak();
            }
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } catch (Throwable th) {
            this.zzd.zzp().zza(this.zzc, bArr);
            throw th;
        }
        this.zzd.zzp().zza(this.zzc, bArr);
    }
}
