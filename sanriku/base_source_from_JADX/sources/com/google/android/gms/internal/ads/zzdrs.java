package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdrs<V> extends zzdqq<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdri<V> zzhin;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzhio;

    private zzdrs(zzdri<V> zzdri) {
        this.zzhin = (zzdri) zzdoj.checkNotNull(zzdri);
    }

    static <V> zzdri<V> zzb(zzdri<V> zzdri, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdrs zzdrs = new zzdrs(zzdri);
        zzdru zzdru = new zzdru(zzdrs);
        zzdrs.zzhio = scheduledExecutorService.schedule(zzdru, j, timeUnit);
        zzdri.addListener(zzdru, zzdqp.INSTANCE);
        return zzdrs;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhin);
        ScheduledFuture<?> scheduledFuture = this.zzhio;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhin = null;
        this.zzhio = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdri<V> zzdri = this.zzhin;
        ScheduledFuture<?> scheduledFuture = this.zzhio;
        if (zzdri == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdri);
        String a = C0681a.m313a(valueOf.length() + 14, "inputFuture=[", valueOf, "]");
        if (scheduledFuture == null) {
            return a;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return a;
        }
        String valueOf2 = String.valueOf(a);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 43);
        sb.append(valueOf2);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }
}
