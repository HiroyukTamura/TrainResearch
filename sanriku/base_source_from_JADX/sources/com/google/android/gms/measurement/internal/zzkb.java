package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

final class zzkb {
    final /* synthetic */ zzjw zza;
    private zzka zzb;

    zzkb(zzjw zzjw) {
        this.zza = zzjw;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza() {
        this.zza.zzd();
        if (this.zza.zzt().zza(zzaq.zzbo) && this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        if (this.zza.zzt().zza(zzaq.zzcc)) {
            this.zza.zzs().zzr.zza(false);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(long j) {
        if (this.zza.zzt().zza(zzaq.zzbo)) {
            this.zzb = new zzka(this, this.zza.zzm().currentTimeMillis(), j);
            this.zza.zzc.postDelayed(this.zzb, 2000);
        }
    }
}
