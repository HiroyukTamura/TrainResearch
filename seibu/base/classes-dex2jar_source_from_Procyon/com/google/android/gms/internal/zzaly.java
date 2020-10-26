// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import com.google.android.gms.analytics.zzl;
import com.google.android.gms.common.internal.zzbo;

public final class zzaly extends zzamh
{
    private final zzamv zzafB;
    
    public zzaly(final zzamj zzamj, final zzaml zzaml) {
        super(zzamj);
        zzbo.zzu(zzaml);
        this.zzafB = new zzamv(zzamj, zzaml);
    }
    
    final void onServiceConnected() {
        zzl.zzjC();
        this.zzafB.onServiceConnected();
    }
    
    public final void setLocalDispatchPeriod(final int i) {
        this.zzkD();
        this.zzb("setLocalDispatchPeriod (sec)", i);
        this.zzkt().zzf(new zzalz(this, i));
    }
    
    public final void start() {
        this.zzafB.start();
    }
    
    public final long zza(final zzamm zzamm) {
        this.zzkD();
        zzbo.zzu(zzamm);
        zzl.zzjC();
        final long zza = this.zzafB.zza(zzamm, true);
        if (zza == 0L) {
            this.zzafB.zzb(zzamm);
        }
        return zza;
    }
    
    public final void zza(final zzanq zzanq) {
        this.zzkD();
        this.zzkt().zzf(new zzame(this, zzanq));
    }
    
    public final void zza(final zzanx zzanx) {
        zzbo.zzu(zzanx);
        this.zzkD();
        this.zzb("Hit delivery requested", zzanx);
        this.zzkt().zzf(new zzamc(this, zzanx));
    }
    
    public final void zza(final String s, final Runnable runnable) {
        zzbo.zzh(s, "campaign param can't be empty");
        this.zzkt().zzf(new zzamb(this, s, runnable));
    }
    
    @Override
    protected final void zzjD() {
        this.zzafB.initialize();
    }
    
    public final void zzkk() {
        this.zzkD();
        this.zzkt().zzf(new zzamd(this));
    }
    
    public final void zzkl() {
        this.zzkD();
        final Context context = this.getContext();
        if (zzaoj.zzac(context) && zzaok.zzad(context)) {
            final Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            context.startService(intent);
            return;
        }
        this.zza((zzanq)null);
    }
    
    public final boolean zzkm() {
        this.zzkD();
        final Future<Object> zzd = this.zzkt().zzd((Callable<Object>)new zzamf(this));
        try {
            zzd.get(4L, TimeUnit.SECONDS);
            return true;
        }
        catch (InterruptedException ex) {
            this.zzd("syncDispatchLocalHits interrupted", ex);
            return false;
        }
        catch (ExecutionException ex2) {
            this.zze("syncDispatchLocalHits failed", ex2);
            return false;
        }
        catch (TimeoutException ex3) {
            this.zzd("syncDispatchLocalHits timed out", ex3);
            return false;
        }
    }
    
    public final void zzkn() {
        this.zzkD();
        zzl.zzjC();
        final zzamv zzafB = this.zzafB;
        zzl.zzjC();
        zzafB.zzkD();
        zzafB.zzbo("Service disconnected");
    }
    
    final void zzko() {
        zzl.zzjC();
        this.zzafB.zzko();
    }
}
