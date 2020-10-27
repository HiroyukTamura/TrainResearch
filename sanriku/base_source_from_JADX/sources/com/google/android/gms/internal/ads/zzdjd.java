package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import java.util.LinkedList;

public final class zzdjd<AdT extends zzbns> {
    /* access modifiers changed from: private */
    public final zzdio zzgrx;
    private final zzdih zzgxz;
    /* access modifiers changed from: private */
    public zzdjj zzgya;
    /* access modifiers changed from: private */
    public zzdrp<zzdiv<AdT>> zzgyb;
    private zzdri<zzdiv<AdT>> zzgyc;
    /* access modifiers changed from: private */
    public int zzgyd = zzdit.zzgxl;
    /* access modifiers changed from: private */
    public final zzdjk<AdT> zzgye;
    private final LinkedList<zzdjj> zzgyf;
    private final zzdqx<zzdiv<AdT>> zzgyg = new zzdji(this);

    public zzdjd(zzdio zzdio, zzdih zzdih, zzdjk<AdT> zzdjk) {
        this.zzgrx = zzdio;
        this.zzgxz = zzdih;
        this.zzgye = zzdjk;
        this.zzgyf = new LinkedList<>();
        this.zzgxz.zza(new zzdjf(this));
    }

    private final boolean zzate() {
        zzdri<zzdiv<AdT>> zzdri = this.zzgyc;
        return zzdri == null || zzdri.isDone();
    }

    /* access modifiers changed from: private */
    public final void zzd(zzdjj zzdjj) {
        while (zzate()) {
            if (zzdjj != null || !this.zzgyf.isEmpty()) {
                if (zzdjj == null) {
                    zzdjj = this.zzgyf.remove();
                }
                if (zzdjj.zzarl() == null || !this.zzgrx.zzb(zzdjj.zzarl())) {
                    zzdjj = null;
                } else {
                    this.zzgya = zzdjj.zzarm();
                    this.zzgyb = zzdrp.zzaws();
                    zzdri<zzdiv<AdT>> zza = this.zzgye.zza(this.zzgya);
                    this.zzgyc = zza;
                    zzdqw.zza(zza, this.zzgyg, zzdjj.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdjj != null) {
            this.zzgyf.add(zzdjj);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatf() {
        synchronized (this) {
            zzd(this.zzgya);
        }
    }

    public final void zzb(zzdjj zzdjj) {
        this.zzgyf.add(zzdjj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzc(zzdiv zzdiv) throws Exception {
        zzdri zzag;
        synchronized (this) {
            zzag = zzdqw.zzag(new zzdjh(zzdiv, this.zzgya));
        }
        return zzag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzdri<com.google.android.gms.internal.ads.zzdjh<AdT>> zzc(com.google.android.gms.internal.ads.zzdjj r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzate()     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            int r0 = com.google.android.gms.internal.ads.zzdit.zzgxn     // Catch:{ all -> 0x0044 }
            r3.zzgyd = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdjj r0 = r3.zzgya     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdiy r0 = r0.zzarl()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdiy r0 = r4.zzarl()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdjj r0 = r3.zzgya     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdiy r0 = r0.zzarl()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdiy r2 = r4.zzarl()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            int r0 = com.google.android.gms.internal.ads.zzdit.zzgxm     // Catch:{ all -> 0x0044 }
            r3.zzgyd = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdrp<com.google.android.gms.internal.ads.zzdiv<AdT>> r0 = r3.zzgyb     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdjg r1 = new com.google.android.gms.internal.ads.zzdjg     // Catch:{ all -> 0x0044 }
            r1.<init>(r3)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.Executor r4 = r4.getExecutor()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdri r4 = com.google.android.gms.internal.ads.zzdqw.zzb(r0, r1, (java.util.concurrent.Executor) r4)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return r4
        L_0x0042:
            monitor-exit(r3)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdjd.zzc(com.google.android.gms.internal.ads.zzdjj):com.google.android.gms.internal.ads.zzdri");
    }
}
