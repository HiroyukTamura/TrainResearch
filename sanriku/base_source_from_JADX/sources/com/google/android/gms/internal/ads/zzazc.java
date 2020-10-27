package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

public final class zzazc {
    private final Object lock = new Object();
    private long zzdyj;
    private long zzdyk = Long.MIN_VALUE;

    public zzazc(long j) {
        this.zzdyj = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzq.zzld().elapsedRealtime();
            if (this.zzdyk + this.zzdyj > elapsedRealtime) {
                return false;
            }
            this.zzdyk = elapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzdyj = j;
        }
    }
}
