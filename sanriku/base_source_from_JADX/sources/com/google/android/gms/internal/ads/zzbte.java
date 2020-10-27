package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzbte extends zzbui<zzbti> {
    private final Clock zzbnt;
    private boolean zzfhr = false;
    private final ScheduledExecutorService zzfif;
    private long zzfih = -1;
    private long zzfii = -1;
    @Nullable
    private ScheduledFuture<?> zzfnn;

    public zzbte(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfif = scheduledExecutorService;
        this.zzbnt = clock;
    }

    /* access modifiers changed from: private */
    public final void zzaiw() {
        zza(zzbtd.zzfnf);
    }

    private final synchronized void zzfe(long j) {
        if (this.zzfnn != null && !this.zzfnn.isDone()) {
            this.zzfnn.cancel(true);
        }
        this.zzfih = this.zzbnt.elapsedRealtime() + j;
        this.zzfnn = this.zzfif.schedule(new zzbtf(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfhr) {
            if (this.zzfnn == null || this.zzfnn.isCancelled()) {
                this.zzfii = -1;
            } else {
                this.zzfnn.cancel(true);
                this.zzfii = this.zzfih - this.zzbnt.elapsedRealtime();
            }
            this.zzfhr = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfhr) {
            if (this.zzfii > 0 && this.zzfnn.isCancelled()) {
                zzfe(this.zzfii);
            }
            this.zzfhr = false;
        }
    }

    public final synchronized void zzaiv() {
        this.zzfhr = false;
        zzfe(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdp(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0043 }
            long r1 = (long) r7     // Catch:{ all -> 0x0043 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.zzfhr     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfii     // Catch:{ all -> 0x0043 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfii     // Catch:{ all -> 0x0043 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfii     // Catch:{ all -> 0x0043 }
        L_0x0021:
            r6.zzfii = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbnt     // Catch:{ all -> 0x0043 }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r4 = r6.zzfih     // Catch:{ all -> 0x0043 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            long r2 = r6.zzfih     // Catch:{ all -> 0x0043 }
            com.google.android.gms.common.util.Clock r7 = r6.zzbnt     // Catch:{ all -> 0x0043 }
            long r4 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
        L_0x003e:
            r6.zzfe(r0)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r6)
            return
        L_0x0043:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbte.zzdp(int):void");
    }
}
