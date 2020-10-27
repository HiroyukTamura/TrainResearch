package com.google.android.gms.measurement.internal;

final class zzhl implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhh zzb;

    zzhl(zzhh zzhh, long j) {
        this.zzb = zzhh;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
