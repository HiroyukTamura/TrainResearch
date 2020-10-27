package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

public final class zzcsa implements zzcnj<zzblx> {
    private final zzdku zzflm;
    private final zzbmt zzgeq;
    private final zzdrh zzghr;
    private final Context zzghw;
    @Nullable
    private final zzaas zzghx;

    public zzcsa(Context context, zzbmt zzbmt, zzdku zzdku, zzdrh zzdrh, @Nullable zzaas zzaas) {
        this.zzghw = context;
        this.zzgeq = zzbmt;
        this.zzflm = zzdku;
        this.zzghr = zzdrh;
        this.zzghx = zzaas;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaap zzaap) throws Exception {
        this.zzghx.zza(zzaap);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcsa.zza(com.google.android.gms.internal.ads.zzdha, com.google.android.gms.internal.ads.zzdgo):boolean");
    }

    public final zzdri<zzblx> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzblw zza = this.zzgeq.zza(new zzboi(zzdha, zzdgo, (String) null), (zzbma) new zzcsf(this, new View(this.zzghw), (zzbek) null, zzcsd.zzgib, zzdgo.zzgtt.get(0)));
        zzcse zzafl = zza.zzafl();
        zzdgs zzdgs = zzdgo.zzgtr;
        return this.zzflm.zzu(zzdkr.CUSTOM_RENDER_SYN).zza((zzdke) new zzcsc(this, new zzaap(zzafl, zzdgs.zzdku, zzdgs.zzdkw)), this.zzghr).zzw(zzdkr.CUSTOM_RENDER_ACK).zze(zzdqw.zzag(zza.zzafj())).zzaud();
    }
}
