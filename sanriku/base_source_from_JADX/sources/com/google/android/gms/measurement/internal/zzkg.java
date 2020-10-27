package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

public final class zzkg extends zzkl {
    private final AlarmManager zzb = ((AlarmManager) zzn().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private final zzag zzc;
    private Integer zzd;

    protected zzkg(zzkk zzkk) {
        super(zzkk);
        this.zzc = new zzkj(this, zzkk.zzs(), zzkk);
    }

    @TargetApi(24)
    private final void zzk() {
        ((JobScheduler) zzn().getSystemService("jobscheduler")).cancel(zzv());
    }

    private final int zzv() {
        if (this.zzd == null) {
            String valueOf = String.valueOf(zzn().getPackageName());
            this.zzd = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    private final PendingIntent zzw() {
        Context zzn = zzn();
        return PendingIntent.getBroadcast(zzn, 0, new Intent().setClassName(zzn, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    /* renamed from: e_ */
    public final /* bridge */ /* synthetic */ zzo mo24432e_() {
        return super.mo24432e_();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(long j) {
        zzak();
        zzu();
        Context zzn = zzn();
        if (!zzfv.zza(zzn)) {
            zzr().zzw().zza("Receiver not registered/enabled");
        }
        if (!zzkw.zza(zzn, false)) {
            zzr().zzw().zza("Service not registered/enabled");
        }
        zzf();
        zzr().zzx().zza("Scheduling upload, millis", Long.valueOf(j));
        long elapsedRealtime = zzm().elapsedRealtime() + j;
        if (j < Math.max(0, zzaq.zzw.zza(null).longValue()) && !this.zzc.zzb()) {
            this.zzc.zza(j);
        }
        zzu();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzn2 = zzn();
            ComponentName componentName = new ComponentName(zzn2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzv = zzv();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            zzh.zza(zzn2, new JobInfo.Builder(zzv, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        this.zzb.setInexactRepeating(2, elapsedRealtime, Math.max(zzaq.zzr.zza(null).longValue(), j), zzw());
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

    /* access modifiers changed from: protected */
    public final boolean zze() {
        this.zzb.cancel(zzw());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzk();
        return false;
    }

    public final void zzf() {
        zzak();
        zzr().zzx().zza("Unscheduling upload");
        this.zzb.cancel(zzw());
        this.zzc.zzc();
        if (Build.VERSION.SDK_INT >= 24) {
            zzk();
        }
    }

    public final /* bridge */ /* synthetic */ zzks zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzad zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfx zzj() {
        return super.zzj();
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
