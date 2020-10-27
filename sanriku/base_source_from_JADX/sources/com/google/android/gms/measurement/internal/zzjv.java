package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zzjv implements Runnable {
    private final zzjt zza;
    private final zzez zzb;
    private final JobParameters zzc;

    zzjv(zzjt zzjt, zzez zzez, JobParameters jobParameters) {
        this.zza = zzjt;
        this.zzb = zzez;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
