package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class zzaj {
    private static final Comparator<byte[]> zzbt = new zzam();
    private final List<byte[]> zzbp = new ArrayList();
    private final List<byte[]> zzbq = new ArrayList(64);
    private int zzbr = 0;
    private final int zzbs = 4096;

    public zzaj(int i) {
    }

    private final synchronized void zzn() {
        while (this.zzbr > this.zzbs) {
            byte[] remove = this.zzbp.remove(0);
            this.zzbq.remove(remove);
            this.zzbr -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.zzbs     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.zzbp     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.zzbq     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = zzbt     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.zzbq     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.zzbr     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.zzbr = r0     // Catch:{ all -> 0x002b }
            r2.zzn()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaj.zza(byte[]):void");
    }

    public final synchronized byte[] zzc(int i) {
        for (int i2 = 0; i2 < this.zzbq.size(); i2++) {
            byte[] bArr = this.zzbq.get(i2);
            if (bArr.length >= i) {
                this.zzbr -= bArr.length;
                this.zzbq.remove(i2);
                this.zzbp.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
