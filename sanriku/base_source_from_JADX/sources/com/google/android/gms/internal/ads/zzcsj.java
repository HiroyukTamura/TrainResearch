package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzcsj<AdT> implements zzcnj<AdT> {
    private final zzdku zzflm;
    private final zzdrh zzghr;
    @Nullable
    private final zzaas zzghx;
    /* access modifiers changed from: private */
    public final zzcsk<AdT> zzgig;

    public zzcsj(zzdku zzdku, zzdrh zzdrh, @Nullable zzaas zzaas, zzcsk<AdT> zzcsk) {
        this.zzflm = zzdku;
        this.zzghr = zzdrh;
        this.zzghx = zzaas;
        this.zzgig = zzcsk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzgtr;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzdha r1, com.google.android.gms.internal.ads.zzdgo r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzaas r1 = r0.zzghx
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzdgs r1 = r2.zzgtr
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zzdkw
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcsj.zza(com.google.android.gms.internal.ads.zzdha, com.google.android.gms.internal.ads.zzdgo):boolean");
    }

    public final zzdri<AdT> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzbaj zzbaj = new zzbaj();
        zzcsr zzcsr = new zzcsr();
        zzcsr.zza(new zzcsl(this, zzbaj, zzdha, zzdgo, zzcsr));
        zzdgs zzdgs = zzdgo.zzgtr;
        return this.zzflm.zzu(zzdkr.CUSTOM_RENDER_SYN).zza((zzdke) new zzcsi(this, new zzaap(zzcsr, zzdgs.zzdku, zzdgs.zzdkw)), this.zzghr).zzw(zzdkr.CUSTOM_RENDER_ACK).zze(zzbaj).zzaud();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzaap zzaap) throws Exception {
        this.zzghx.zza(zzaap);
    }
}
