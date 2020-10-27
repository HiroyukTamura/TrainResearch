package com.google.android.gms.internal.ads;

public class zzect {
    private static final zzebq zzhsw = zzebq.zzbec();
    private zzeaq zzhzh;
    private volatile zzedo zzhzi;
    private volatile zzeaq zzhzj;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzedo zzm(com.google.android.gms.internal.ads.zzedo r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzedo r0 = r1.zzhzi
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzedo r0 = r1.zzhzi     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzhzi = r2     // Catch:{ zzeco -> 0x0012 }
            com.google.android.gms.internal.ads.zzeaq r0 = com.google.android.gms.internal.ads.zzeaq.zzhtf     // Catch:{ zzeco -> 0x0012 }
            r1.zzhzj = r0     // Catch:{ zzeco -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzhzi = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.ads.zzeaq r2 = com.google.android.gms.internal.ads.zzeaq.zzhtf     // Catch:{ all -> 0x0019 }
            r1.zzhzj = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.ads.zzedo r2 = r1.zzhzi
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzect.zzm(com.google.android.gms.internal.ads.zzedo):com.google.android.gms.internal.ads.zzedo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzect)) {
            return false;
        }
        zzect zzect = (zzect) obj;
        zzedo zzedo = this.zzhzi;
        zzedo zzedo2 = zzect.zzhzi;
        return (zzedo == null && zzedo2 == null) ? zzbce().equals(zzect.zzbce()) : (zzedo == null || zzedo2 == null) ? zzedo != null ? zzedo.equals(zzect.zzm(zzedo.zzbeu())) : zzm(zzedo2.zzbeu()).equals(zzedo2) : zzedo.equals(zzedo2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeaq zzbce() {
        if (this.zzhzj != null) {
            return this.zzhzj;
        }
        synchronized (this) {
            if (this.zzhzj != null) {
                zzeaq zzeaq = this.zzhzj;
                return zzeaq;
            }
            this.zzhzj = this.zzhzi == null ? zzeaq.zzhtf : this.zzhzi.zzbce();
            zzeaq zzeaq2 = this.zzhzj;
            return zzeaq2;
        }
    }

    public final int zzbex() {
        if (this.zzhzj != null) {
            return this.zzhzj.size();
        }
        if (this.zzhzi != null) {
            return this.zzhzi.zzbex();
        }
        return 0;
    }

    public final zzedo zzn(zzedo zzedo) {
        zzedo zzedo2 = this.zzhzi;
        this.zzhzh = null;
        this.zzhzj = null;
        this.zzhzi = zzedo;
        return zzedo2;
    }
}
