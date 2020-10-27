package com.google.android.gms.internal.measurement;

public class zzis {
    private static final zzho zza = zzho.zza();
    private zzgt zzb;
    private volatile zzjj zzc;
    private volatile zzgt zzd;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzjj zzb(com.google.android.gms.internal.measurement.zzjj r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzjj r0 = r1.zzc
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzjj r0 = r1.zzc     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzij -> 0x0012 }
            com.google.android.gms.internal.measurement.zzgt r0 = com.google.android.gms.internal.measurement.zzgt.zza     // Catch:{ zzij -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzij -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.measurement.zzgt r2 = com.google.android.gms.internal.measurement.zzgt.zza     // Catch:{ all -> 0x0019 }
            r1.zzd = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.measurement.zzjj r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzis.zzb(com.google.android.gms.internal.measurement.zzjj):com.google.android.gms.internal.measurement.zzjj");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzis = (zzis) obj;
        zzjj zzjj = this.zzc;
        zzjj zzjj2 = zzis.zzc;
        return (zzjj == null && zzjj2 == null) ? zzc().equals(zzis.zzc()) : (zzjj == null || zzjj2 == null) ? zzjj != null ? zzjj.equals(zzis.zzb(zzjj.mo22644h_())) : zzb(zzjj2.mo22644h_()).equals(zzjj2) : zzjj.equals(zzjj2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjj zza(zzjj zzjj) {
        zzjj zzjj2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjj;
        return zzjj2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbm();
        }
        return 0;
    }

    public final zzgt zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgt zzgt = this.zzd;
                return zzgt;
            }
            this.zzd = this.zzc == null ? zzgt.zza : this.zzc.zzbh();
            zzgt zzgt2 = this.zzd;
            return zzgt2;
        }
    }
}
