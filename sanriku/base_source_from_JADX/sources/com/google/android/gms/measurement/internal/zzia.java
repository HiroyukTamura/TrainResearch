package com.google.android.gms.measurement.internal;

final class zzia implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhh zzb;

    zzia(zzhh zzhh, long j) {
        this.zzb = zzhh;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzk.zza(this.zza);
        this.zzb.zzr().zzw().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
