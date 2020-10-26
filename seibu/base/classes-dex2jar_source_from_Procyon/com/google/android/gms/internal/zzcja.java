// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;
import android.os.Bundle;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.os.Handler;

public final class zzcja extends zzchj
{
    private Handler mHandler;
    private long zzbur;
    private final zzcer zzbus;
    private final zzcer zzbut;
    
    zzcja(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbus = new zzcjb(this, this.zzboe);
        this.zzbut = new zzcjc(this, this.zzboe);
        this.zzbur = super.zzkq().elapsedRealtime();
    }
    
    @WorkerThread
    private final void zzae(final long n) {
        super.zzjC();
        this.zzzn();
        this.zzbus.cancel();
        this.zzbut.cancel();
        super.zzwF().zzyD().zzj("Activity resumed, time", n);
        this.zzbur = n;
        if (super.zzkq().currentTimeMillis() - super.zzwG().zzbry.get() > super.zzwG().zzbrA.get()) {
            super.zzwG().zzbrz.set(true);
            super.zzwG().zzbrB.set(0L);
        }
        if (super.zzwG().zzbrz.get()) {
            this.zzbus.zzs(Math.max(0L, super.zzwG().zzbrx.get() - super.zzwG().zzbrB.get()));
            return;
        }
        this.zzbut.zzs(Math.max(0L, 3600000L - super.zzwG().zzbrB.get()));
    }
    
    @WorkerThread
    private final void zzaf(final long l) {
        super.zzjC();
        this.zzzn();
        this.zzbus.cancel();
        this.zzbut.cancel();
        super.zzwF().zzyD().zzj("Activity paused, time", l);
        if (this.zzbur != 0L) {
            super.zzwG().zzbrB.set(super.zzwG().zzbrB.get() + (l - this.zzbur));
        }
    }
    
    private final void zzzn() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }
    
    @WorkerThread
    private final void zzzp() {
        super.zzjC();
        this.zzap(false);
        super.zzwr().zzJ(super.zzkq().elapsedRealtime());
    }
    
    @WorkerThread
    public final boolean zzap(final boolean b) {
        super.zzjC();
        this.zzkD();
        final long elapsedRealtime = super.zzkq().elapsedRealtime();
        super.zzwG().zzbrA.set(super.zzkq().currentTimeMillis());
        final long n = elapsedRealtime - this.zzbur;
        if (!b && n < 1000L) {
            super.zzwF().zzyD().zzj("Screen exposed for less than 1000 ms. Event not sent. time", n);
            return false;
        }
        super.zzwG().zzbrB.set(n);
        super.zzwF().zzyD().zzj("Recording user engagement, ms", n);
        final Bundle bundle = new Bundle();
        bundle.putLong("_et", n);
        zzchz.zza(super.zzwx().zzzh(), bundle);
        super.zzwt().zzd("auto", "_e", bundle);
        this.zzbur = elapsedRealtime;
        this.zzbut.cancel();
        this.zzbut.zzs(Math.max(0L, 3600000L - super.zzwG().zzbrB.get()));
        return true;
    }
    
    @Override
    protected final void zzjD() {
    }
    
    @WorkerThread
    protected final void zzzo() {
        super.zzjC();
        super.zzwF().zzyD().zzj("Session started, time", super.zzkq().elapsedRealtime());
        super.zzwG().zzbrz.set(false);
        super.zzwt().zzd("auto", "_s", new Bundle());
        super.zzwG().zzbrA.set(super.zzkq().currentTimeMillis());
    }
}
