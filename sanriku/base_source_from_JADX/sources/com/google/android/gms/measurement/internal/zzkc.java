package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zznt;

final class zzkc {
    @VisibleForTesting
    private long zza;
    @VisibleForTesting
    private long zzb;
    private final zzag zzc = new zzkf(this, this.zzd.zzy);
    private final /* synthetic */ zzjw zzd;

    public zzkc(zzjw zzjw) {
        this.zzd = zzjw;
        long elapsedRealtime = zzjw.zzm().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    @WorkerThread
    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zznh.zzb() || !this.zzd.zzt().zza(zzaq.zzbz)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzns.zzb() || !this.zzd.zzt().zza(zzaq.zzbv) || this.zzd.zzy.zzab()) {
            this.zzd.zzs().zzp.zza(this.zzd.zzm().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (this.zzd.zzt().zza(zzaq.zzat) && !z2) {
                j2 = (!zznt.zzb() || !this.zzd.zzt().zza(zzaq.zzav) || !zznh.zzb() || !this.zzd.zzt().zza(zzaq.zzbz)) ? zzb() : zzc(j);
            }
            this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzin.zza(this.zzd.zzi().zza(!this.zzd.zzt().zzj().booleanValue()), bundle, true);
            if (this.zzd.zzt().zza(zzaq.zzat) && !this.zzd.zzt().zza(zzaq.zzau) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzd.zzt().zza(zzaq.zzau) || !z2) {
                this.zzd.zzf().zza("auto", "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(3600000);
            return true;
        }
        this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(long j) {
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }
}
