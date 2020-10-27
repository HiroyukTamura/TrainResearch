package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzaur implements zzpz {
    private final Object lock;
    private String zzbsc;
    private final Context zzciq;
    private boolean zzdsl;

    public zzaur(Context context, String str) {
        this.zzciq = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbsc = str;
        this.zzdsl = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbsc;
    }

    public final void zza(zzqa zzqa) {
        zzam(zzqa.zzbot);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzam(boolean r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzauu r0 = com.google.android.gms.ads.internal.zzq.zzlu()
            android.content.Context r1 = r3.zzciq
            boolean r0 = r0.zzab(r1)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            boolean r1 = r3.zzdsl     // Catch:{ all -> 0x003f }
            if (r1 != r4) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0016:
            r3.zzdsl = r4     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r3.zzbsc     // Catch:{ all -> 0x003f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0022
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0022:
            boolean r4 = r3.zzdsl     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzauu r4 = com.google.android.gms.ads.internal.zzq.zzlu()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zzciq     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzbsc     // Catch:{ all -> 0x003f }
            r4.zze(r1, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0032:
            com.google.android.gms.internal.ads.zzauu r4 = com.google.android.gms.ads.internal.zzq.zzlu()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zzciq     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzbsc     // Catch:{ all -> 0x003f }
            r4.zzf(r1, r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaur.zzam(boolean):void");
    }
}
