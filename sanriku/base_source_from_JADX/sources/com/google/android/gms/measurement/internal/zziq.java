package com.google.android.gms.measurement.internal;

final class zziq implements Runnable {
    private final /* synthetic */ zzik zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzin zzc;

    zziq(zzin zzin, zzik zzik, long j) {
        this.zzc = zzin;
        this.zza = zzik;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzin zzin = this.zzc;
        zzin.zza = null;
        zzin.zzh().zza((zzik) null);
    }
}
