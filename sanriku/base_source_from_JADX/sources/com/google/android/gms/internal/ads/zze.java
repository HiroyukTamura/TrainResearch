package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zze implements zzs {
    private final Map<String, List<zzq<?>>> zzn = new HashMap();
    private final zzc zzo;

    zze(zzc zzc) {
        this.zzo = zzc;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.internal.ads.zzq<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.zze()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzb((java.lang.String) r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r6 = r5.zzn     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m294d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.zza((com.google.android.gms.internal.ads.zzs) r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m294d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zze.zzb(com.google.android.gms.internal.ads.zzq):boolean");
    }

    public final synchronized void zza(zzq<?> zzq) {
        String zze = zzq.zze();
        List remove = this.zzn.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzag.DEBUG) {
                zzag.m296v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzq zzq2 = (zzq) remove.remove(0);
            this.zzn.put(zze, remove);
            zzq2.zza((zzs) this);
            try {
                this.zzo.zzb.put(zzq2);
            } catch (InterruptedException e) {
                zzag.m295e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzo.quit();
            }
        }
    }

    public final void zza(zzq<?> zzq, zzz<?> zzz) {
        List<zzq> remove;
        zzd zzd = zzz.zzbh;
        if (zzd == null || zzd.zza()) {
            zza(zzq);
            return;
        }
        String zze = zzq.zze();
        synchronized (this) {
            remove = this.zzn.remove(zze);
        }
        if (remove != null) {
            if (zzag.DEBUG) {
                zzag.m296v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzq zzb : remove) {
                this.zzo.zzd.zzb(zzb, zzz);
            }
        }
    }
}
