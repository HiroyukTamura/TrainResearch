package com.google.android.gms.internal.fitness;

public class zzgt {
    private static final zzfx zzre = zzfx.zzba();
    private zzff zzws;
    private volatile zzho zzwt;
    private volatile zzff zzwu;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.fitness.zzho zzg(com.google.android.gms.internal.fitness.zzho r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.fitness.zzho r0 = r1.zzwt
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.fitness.zzho r0 = r1.zzwt     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzwt = r2     // Catch:{ zzgo -> 0x0012 }
            com.google.android.gms.internal.fitness.zzff r0 = com.google.android.gms.internal.fitness.zzff.zzri     // Catch:{ zzgo -> 0x0012 }
            r1.zzwu = r0     // Catch:{ zzgo -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzwt = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.fitness.zzff r2 = com.google.android.gms.internal.fitness.zzff.zzri     // Catch:{ all -> 0x0019 }
            r1.zzwu = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.fitness.zzho r2 = r1.zzwt
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzgt.zzg(com.google.android.gms.internal.fitness.zzho):com.google.android.gms.internal.fitness.zzho");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgt = (zzgt) obj;
        zzho zzho = this.zzwt;
        zzho zzho2 = zzgt.zzwt;
        return (zzho == null && zzho2 == null) ? zzag().equals(zzgt.zzag()) : (zzho == null || zzho2 == null) ? zzho != null ? zzho.equals(zzgt.zzg(zzho.zzbm())) : zzg(zzho2.zzbm()).equals(zzho2) : zzho.equals(zzho2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzff zzag() {
        if (this.zzwu != null) {
            return this.zzwu;
        }
        synchronized (this) {
            if (this.zzwu != null) {
                zzff zzff = this.zzwu;
                return zzff;
            }
            this.zzwu = this.zzwt == null ? zzff.zzri : this.zzwt.zzag();
            zzff zzff2 = this.zzwu;
            return zzff2;
        }
    }

    public final int zzbk() {
        if (this.zzwu != null) {
            return this.zzwu.size();
        }
        if (this.zzwt != null) {
            return this.zzwt.zzbk();
        }
        return 0;
    }

    public final zzho zzh(zzho zzho) {
        zzho zzho2 = this.zzwt;
        this.zzws = null;
        this.zzwu = null;
        this.zzwt = zzho;
        return zzho2;
    }
}
