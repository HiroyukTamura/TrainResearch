package com.google.android.gms.internal.ads;

final class zzajm implements Runnable {
    private final /* synthetic */ zzajw zzdcw;
    private final /* synthetic */ zzais zzdcx;
    private final /* synthetic */ zzajf zzdcy;

    zzajm(zzajf zzajf, zzajw zzajw, zzais zzais) {
        this.zzdcy = zzajf;
        this.zzdcw = zzajw;
        this.zzdcx = zzais;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzajf r0 = r3.zzdcy
            java.lang.Object r0 = r0.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzajw r1 = r3.zzdcw     // Catch:{ all -> 0x0036 }
            int r1 = r1.getStatus()     // Catch:{ all -> 0x0036 }
            r2 = -1
            if (r1 == r2) goto L_0x0034
            com.google.android.gms.internal.ads.zzajw r1 = r3.zzdcw     // Catch:{ all -> 0x0036 }
            int r1 = r1.getStatus()     // Catch:{ all -> 0x0036 }
            r2 = 1
            if (r1 != r2) goto L_0x001a
            goto L_0x0034
        L_0x001a:
            com.google.android.gms.internal.ads.zzajw r1 = r3.zzdcw     // Catch:{ all -> 0x0036 }
            r1.reject()     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzdrh r1 = com.google.android.gms.internal.ads.zzbab.zzdzv     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzais r2 = r3.zzdcx     // Catch:{ all -> 0x0036 }
            r2.getClass()     // Catch:{ all -> 0x0036 }
            java.lang.Runnable r2 = com.google.android.gms.internal.ads.zzajp.zzb(r2)     // Catch:{ all -> 0x0036 }
            r1.execute(r2)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzawr.zzeg(r1)     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajm.run():void");
    }
}
