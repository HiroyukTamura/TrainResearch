// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.job.JobInfo;
import android.os.PersistableBundle;
import android.app.job.JobInfo$Builder;
import android.content.ComponentName;
import com.google.android.gms.common.util.zze;
import android.os.Build$VERSION;
import android.annotation.TargetApi;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;

public final class zzcjg extends zzchj
{
    private final AlarmManager zzahd;
    private final zzcer zzbuv;
    private Integer zzbuw;
    
    protected zzcjg(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzahd = (AlarmManager)super.getContext().getSystemService("alarm");
        this.zzbuv = new zzcjh(this, zzcgl);
    }
    
    private final int getJobId() {
        if (this.zzbuw == null) {
            final String value = String.valueOf(super.getContext().getPackageName());
            String concat;
            if (value.length() != 0) {
                concat = "measurement".concat(value);
            }
            else {
                concat = new String("measurement");
            }
            this.zzbuw = concat.hashCode();
        }
        return this.zzbuw;
    }
    
    private final PendingIntent zzlD() {
        final Intent intent = new Intent();
        final Context context = super.getContext();
        zzcem.zzxE();
        final Intent setClassName = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        setClassName.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(super.getContext(), 0, setClassName, 0);
    }
    
    @TargetApi(24)
    private final void zzzq() {
        final JobScheduler jobScheduler = (JobScheduler)super.getContext().getSystemService("jobscheduler");
        super.zzwF().zzyD().zzj("Cancelling job. JobID", this.getJobId());
        jobScheduler.cancel(this.getJobId());
    }
    
    private final void zzzr() {
        final Intent intent = new Intent();
        final Context context = super.getContext();
        zzcem.zzxE();
        final Intent setClassName = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        setClassName.setAction("com.google.android.gms.measurement.UPLOAD");
        super.getContext().sendBroadcast(setClassName);
    }
    
    public final void cancel() {
        this.zzkD();
        this.zzahd.cancel(this.zzlD());
        this.zzbuv.cancel();
        if (Build$VERSION.SDK_INT >= 24) {
            this.zzzq();
        }
    }
    
    @Override
    protected final void zzjD() {
        this.zzahd.cancel(this.zzlD());
        if (Build$VERSION.SDK_INT >= 24) {
            this.zzzq();
        }
    }
    
    public final void zzs(final long n) {
        this.zzkD();
        zzcem.zzxE();
        if (!zzcgc.zzj(super.getContext(), false)) {
            super.zzwF().zzyC().log("Receiver not registered/enabled");
        }
        zzcem.zzxE();
        if (!zzciw.zzk(super.getContext(), false)) {
            super.zzwF().zzyC().log("Service not registered/enabled");
        }
        this.cancel();
        final long elapsedRealtime = super.zzkq().elapsedRealtime();
        if (n < zzcem.zzxV() && !this.zzbuv.zzbo()) {
            super.zzwF().zzyD().log("Scheduling upload with DelayedRunnable");
            this.zzbuv.zzs(n);
        }
        zzcem.zzxE();
        if (Build$VERSION.SDK_INT >= 24) {
            super.zzwF().zzyD().log("Scheduling upload with JobScheduler");
            final ComponentName componentName = new ComponentName(super.getContext(), "com.google.android.gms.measurement.AppMeasurementJobService");
            final JobScheduler jobScheduler = (JobScheduler)super.getContext().getSystemService("jobscheduler");
            final JobInfo$Builder jobInfo$Builder = new JobInfo$Builder(this.getJobId(), componentName);
            jobInfo$Builder.setMinimumLatency(n);
            jobInfo$Builder.setOverrideDeadline(n << 1);
            final PersistableBundle extras = new PersistableBundle();
            extras.putString("action", "com.google.android.gms.measurement.UPLOAD");
            jobInfo$Builder.setExtras(extras);
            final JobInfo build = jobInfo$Builder.build();
            super.zzwF().zzyD().zzj("Scheduling job. JobID", this.getJobId());
            jobScheduler.schedule(build);
            return;
        }
        super.zzwF().zzyD().log("Scheduling upload with AlarmManager");
        this.zzahd.setInexactRepeating(2, elapsedRealtime + n, Math.max(zzcem.zzxW(), n), this.zzlD());
    }
}
