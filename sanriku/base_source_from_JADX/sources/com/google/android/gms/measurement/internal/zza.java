package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

public final class zza extends zzd {
    private final Map<String, Long> zza = new ArrayMap();
    private final Map<String, Integer> zzb = new ArrayMap();
    private long zzc;

    public zza(zzgd zzgd) {
        super(zzgd);
    }

    @WorkerThread
    private final void zza(long j, zzik zzik) {
        if (zzik == null) {
            zzr().zzx().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzr().zzx().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzin.zza(zzik, bundle, true);
            zzf().zza("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zza(String str, long j, zzik zzik) {
        if (zzik == null) {
            zzr().zzx().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzr().zzx().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzin.zza(zzik, bundle, true);
            zzf().zza("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzb.isEmpty()) {
            this.zzc = j;
        }
        Integer num = this.zzb.get(str);
        if (num != null) {
            this.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzb.size() >= 100) {
            zzr().zzi().zza("Too many ads visible");
        } else {
            this.zzb.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        Integer num = this.zzb.get(str);
        if (num != null) {
            zzik zza2 = zzi().zza(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzb.remove(str);
                Long l = this.zza.get(str);
                if (l == null) {
                    zzr().zzf().zza("First ad unit exposure time was never set");
                } else {
                    this.zza.remove(str);
                    zza(str, j - l.longValue(), zza2);
                }
                if (this.zzb.isEmpty()) {
                    long j2 = this.zzc;
                    if (j2 == 0) {
                        zzr().zzf().zza("First ad exposure time was never set");
                        return;
                    }
                    zza(j - j2, zza2);
                    this.zzc = 0;
                    return;
                }
                return;
            }
            this.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzr().zzf().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @WorkerThread
    public final void zza(long j) {
        zzik zza2 = zzi().zza(false);
        for (String next : this.zza.keySet()) {
            zza(next, j - this.zza.get(next).longValue(), zza2);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zza2);
        }
        zzb(j);
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza((Runnable) new zzc(this, str, j));
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza((Runnable) new zzb(this, str, j));
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
