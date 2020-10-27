package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzjx;

public final class zzjt<T extends Context & zzjx> {
    private final T zza;

    public zzjt(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    private final void zza(Runnable runnable) {
        zzkk zza2 = zzkk.zza((Context) this.zza);
        zza2.zzq().zza((Runnable) new zzju(this, zza2, runnable));
    }

    private final zzez zzc() {
        return zzgd.zza(this.zza, (zzae) null, (Long) null).zzr();
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzgd zza2 = zzgd.zza(this.zza, (zzae) null, (Long) null);
        zzez zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza((Runnable) new zzjs(this, i2, zzr, intent));
        }
        return 2;
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzge(zzkk.zza((Context) this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void zza() {
        zzgd zza2 = zzgd.zza(this.zza, (zzae) null, (Long) null);
        zzez zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzez zzez, Intent intent) {
        if (((zzjx) this.zza).zza(i)) {
            zzez.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            ((zzjx) this.zza).zza(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzez zzez, JobParameters jobParameters) {
        zzez.zzx().zza("AppMeasurementJobService processed last upload request.");
        ((zzjx) this.zza).zza(jobParameters, false);
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzgd zza2 = zzgd.zza(this.zza, (zzae) null, (Long) null);
        zzez zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza((Runnable) new zzjv(this, zzr, jobParameters));
        return true;
    }

    @MainThread
    public final void zzb() {
        zzgd zza2 = zzgd.zza(this.zza, (zzae) null, (Long) null);
        zzez zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }
}
