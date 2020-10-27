package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

public final class zzjw extends zzg {
    protected final zzke zza = new zzke(this);
    protected final zzkc zzb = new zzkc(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private final zzkb zzd = new zzkb(this);

    zzjw(zzgd zzgd) {
        super(zzgd);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzab() {
        zzd();
        if (this.zzc == null) {
            this.zzc = new zzq(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j) {
        zzd();
        zzab();
        zzr().zzx().zza("Activity resumed, time", Long.valueOf(j));
        if (zzt().zza(zzaq.zzcc)) {
            if (zzt().zzj().booleanValue() || zzs().zzr.zza()) {
                this.zzb.zza(j);
            }
            this.zzd.zza();
        } else {
            this.zzd.zza();
            if (zzt().zzj().booleanValue()) {
                this.zzb.zza(j);
            }
        }
        zzke zzke = this.zza;
        zzke.zza.zzd();
        if (zzke.zza.zzy.zzab()) {
            if (!zzke.zza.zzt().zza(zzaq.zzcc)) {
                zzke.zza.zzs().zzr.zza(false);
            }
            zzke.zza(zzke.zza.zzm().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(long j) {
        zzd();
        zzab();
        zzr().zzx().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zza(j);
        if (zzt().zzj().booleanValue()) {
            this.zzb.zzb(j);
        }
        zzke zzke = this.zza;
        if (!zzke.zza.zzt().zza(zzaq.zzcc)) {
            zzke.zza.zzs().zzr.zza(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza(long j) {
        return this.zzb.zzc(j);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
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

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
