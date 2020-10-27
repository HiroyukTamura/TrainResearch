package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class zzqm {
    private final Object lock = new Object();
    @VisibleForTesting
    private int zzbqe;
    private List<zzqj> zzbqf = new LinkedList();

    public final boolean zza(zzqj zzqj) {
        synchronized (this.lock) {
            return this.zzbqf.contains(zzqj);
        }
    }

    public final boolean zzb(zzqj zzqj) {
        synchronized (this.lock) {
            Iterator<zzqj> it = this.zzbqf.iterator();
            while (it.hasNext()) {
                zzqj next = it.next();
                if (!zzq.zzla().zzwb().zzwq()) {
                    if (zzqj != next && next.zzly().equals(zzqj.zzly())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzq.zzla().zzwb().zzws() && zzqj != next && next.zzma().equals(zzqj.zzma())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzqj zzqj) {
        synchronized (this.lock) {
            if (this.zzbqf.size() >= 10) {
                int size = this.zzbqf.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzazw.zzed(sb.toString());
                this.zzbqf.remove(0);
            }
            int i = this.zzbqe;
            this.zzbqe = i + 1;
            zzqj.zzbq(i);
            zzqj.zzme();
            this.zzbqf.add(zzqj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        return r1;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzqj zzo(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzqj> r1 = r7.zzbqf     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r8 = "Queue empty"
            com.google.android.gms.internal.ads.zzazw.zzed(r8)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzqj> r1 = r7.zzbqf     // Catch:{ all -> 0x005a }
            int r1 = r1.size()     // Catch:{ all -> 0x005a }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x0045
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.List<com.google.android.gms.internal.ads.zzqj> r1 = r7.zzbqf     // Catch:{ all -> 0x005a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005a }
            r3 = 0
        L_0x0026:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x003e
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzqj r5 = (com.google.android.gms.internal.ads.zzqj) r5     // Catch:{ all -> 0x005a }
            int r6 = r5.getScore()     // Catch:{ all -> 0x005a }
            if (r6 <= r8) goto L_0x003b
            r4 = r3
            r2 = r5
            r8 = r6
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x003e:
            java.util.List<com.google.android.gms.internal.ads.zzqj> r8 = r7.zzbqf     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x0045:
            java.util.List<com.google.android.gms.internal.ads.zzqj> r1 = r7.zzbqf     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzqj r1 = (com.google.android.gms.internal.ads.zzqj) r1     // Catch:{ all -> 0x005a }
            if (r8 == 0) goto L_0x0055
            java.util.List<com.google.android.gms.internal.ads.zzqj> r8 = r7.zzbqf     // Catch:{ all -> 0x005a }
            r8.remove(r4)     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0055:
            r1.zzmb()     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r1
        L_0x005a:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005d:
            throw r8
        L_0x005e:
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqm.zzo(boolean):com.google.android.gms.internal.ads.zzqj");
    }
}
