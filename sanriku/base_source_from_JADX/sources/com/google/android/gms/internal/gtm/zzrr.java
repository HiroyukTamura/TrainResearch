package com.google.android.gms.internal.gtm;

public class zzrr {
    private static final zzqp zzavr = zzqp.zzoq();
    private zzps zzbcb;
    private volatile zzsk zzbcc;
    private volatile zzps zzbcd;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.gtm.zzsk zzh(com.google.android.gms.internal.gtm.zzsk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.gtm.zzsk r0 = r1.zzbcc
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.gtm.zzsk r0 = r1.zzbcc     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzbcc = r2     // Catch:{ zzrk -> 0x0012 }
            com.google.android.gms.internal.gtm.zzps r0 = com.google.android.gms.internal.gtm.zzps.zzavx     // Catch:{ zzrk -> 0x0012 }
            r1.zzbcd = r0     // Catch:{ zzrk -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzbcc = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.gtm.zzps r2 = com.google.android.gms.internal.gtm.zzps.zzavx     // Catch:{ all -> 0x0019 }
            r1.zzbcd = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.gtm.zzsk r2 = r1.zzbcc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzrr.zzh(com.google.android.gms.internal.gtm.zzsk):com.google.android.gms.internal.gtm.zzsk");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrr)) {
            return false;
        }
        zzrr zzrr = (zzrr) obj;
        zzsk zzsk = this.zzbcc;
        zzsk zzsk2 = zzrr.zzbcc;
        return (zzsk == null && zzsk2 == null) ? zzmv().equals(zzrr.zzmv()) : (zzsk == null || zzsk2 == null) ? zzsk != null ? zzsk.equals(zzrr.zzh(zzsk.zzpi())) : zzh(zzsk2.zzpi()).equals(zzsk2) : zzsk.equals(zzsk2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzsk zzi(zzsk zzsk) {
        zzsk zzsk2 = this.zzbcc;
        this.zzbcb = null;
        this.zzbcd = null;
        this.zzbcc = zzsk;
        return zzsk2;
    }

    public final zzps zzmv() {
        if (this.zzbcd != null) {
            return this.zzbcd;
        }
        synchronized (this) {
            if (this.zzbcd != null) {
                zzps zzps = this.zzbcd;
                return zzps;
            }
            this.zzbcd = this.zzbcc == null ? zzps.zzavx : this.zzbcc.zzmv();
            zzps zzps2 = this.zzbcd;
            return zzps2;
        }
    }

    public final int zzpe() {
        if (this.zzbcd != null) {
            return this.zzbcd.size();
        }
        if (this.zzbcc != null) {
            return this.zzbcc.zzpe();
        }
        return 0;
    }
}
