// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import android.support.annotation.WorkerThread;
import java.util.Iterator;
import android.support.v4.util.ArrayMap;
import java.util.Map;

public final class zzcec extends zzchi
{
    private final Map<String, Long> zzboq;
    private final Map<String, Integer> zzbor;
    private long zzbos;
    
    public zzcec(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbor = new ArrayMap<String, Integer>();
        this.zzboq = new ArrayMap<String, Long>();
    }
    
    @WorkerThread
    private final void zzK(final long n) {
        final Iterator<String> iterator = this.zzboq.keySet().iterator();
        while (iterator.hasNext()) {
            this.zzboq.put(iterator.next(), n);
        }
        if (!this.zzboq.isEmpty()) {
            this.zzbos = n;
        }
    }
    
    @WorkerThread
    private final void zza(final long l, final AppMeasurement.zzb zzb) {
        if (zzb == null) {
            super.zzwF().zzyD().log("Not logging ad exposure. No active activity");
            return;
        }
        if (l < 1000L) {
            super.zzwF().zzyD().zzj("Not logging ad exposure. Less than 1000 ms. exposure", l);
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putLong("_xt", l);
        zzchz.zza(zzb, bundle);
        super.zzwt().zzd("am", "_xa", bundle);
    }
    
    @WorkerThread
    private final void zza(final String s, final long l, final AppMeasurement.zzb zzb) {
        if (zzb == null) {
            super.zzwF().zzyD().log("Not logging ad unit exposure. No active activity");
            return;
        }
        if (l < 1000L) {
            super.zzwF().zzyD().zzj("Not logging ad unit exposure. Less than 1000 ms. exposure", l);
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("_ai", s);
        bundle.putLong("_xt", l);
        zzchz.zza(zzb, bundle);
        super.zzwt().zzd("am", "_xu", bundle);
    }
    
    @WorkerThread
    private final void zzd(final String s, final long n) {
        super.zzwp();
        super.zzjC();
        zzbo.zzcF(s);
        if (this.zzbor.isEmpty()) {
            this.zzbos = n;
        }
        final Integer n2 = this.zzbor.get(s);
        if (n2 != null) {
            this.zzbor.put(s, n2 + 1);
            return;
        }
        if (this.zzbor.size() >= 100) {
            super.zzwF().zzyz().log("Too many ads visible");
            return;
        }
        this.zzbor.put(s, 1);
        this.zzboq.put(s, n);
    }
    
    @WorkerThread
    private final void zze(final String s, final long n) {
        super.zzwp();
        super.zzjC();
        zzbo.zzcF(s);
        final Integer n2 = this.zzbor.get(s);
        if (n2 == null) {
            super.zzwF().zzyx().zzj("Call to endAdUnitExposure for unknown ad unit id", s);
            return;
        }
        final zzcic zzzh = super.zzwx().zzzh();
        final int i = n2 - 1;
        if (i == 0) {
            this.zzbor.remove(s);
            final Long n3 = this.zzboq.get(s);
            if (n3 == null) {
                super.zzwF().zzyx().log("First ad unit exposure time was never set");
            }
            else {
                final long longValue = n3;
                this.zzboq.remove(s);
                this.zza(s, n - longValue, zzzh);
            }
            if (this.zzbor.isEmpty()) {
                if (this.zzbos != 0L) {
                    this.zza(n - this.zzbos, zzzh);
                    this.zzbos = 0L;
                    return;
                }
                super.zzwF().zzyx().log("First ad exposure time was never set");
            }
            return;
        }
        this.zzbor.put(s, i);
    }
    
    public final void beginAdUnitExposure(final String s) {
        if (s == null || s.length() == 0) {
            super.zzwF().zzyx().log("Ad unit id must be a non-empty string");
            return;
        }
        super.zzwE().zzj(new zzced(this, s, super.zzkq().elapsedRealtime()));
    }
    
    public final void endAdUnitExposure(final String s) {
        if (s == null || s.length() == 0) {
            super.zzwF().zzyx().log("Ad unit id must be a non-empty string");
            return;
        }
        super.zzwE().zzj(new zzcee(this, s, super.zzkq().elapsedRealtime()));
    }
    
    @WorkerThread
    public final void zzJ(final long n) {
        final zzcic zzzh = super.zzwx().zzzh();
        for (final String s : this.zzboq.keySet()) {
            this.zza(s, n - this.zzboq.get(s), zzzh);
        }
        if (!this.zzboq.isEmpty()) {
            this.zza(n - this.zzbos, zzzh);
        }
        this.zzK(n);
    }
    
    public final void zzwn() {
        super.zzwE().zzj(new zzcef(this, super.zzkq().elapsedRealtime()));
    }
}
