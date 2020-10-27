package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

final class zzjk implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzw zze;
    private final /* synthetic */ zzis zzf;

    zzjk(zzis zzis, String str, String str2, boolean z, zzn zzn, zzw zzw) {
        this.zzf = zzis;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
        this.zze = zzw;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzer zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
            } else {
                bundle = zzkw.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
                this.zzf.zzak();
            }
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
        } catch (Throwable th) {
            this.zzf.zzp().zza(this.zze, bundle);
            throw th;
        }
        this.zzf.zzp().zza(this.zze, bundle);
    }
}
