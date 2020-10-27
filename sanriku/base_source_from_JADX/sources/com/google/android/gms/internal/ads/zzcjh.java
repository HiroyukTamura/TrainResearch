package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzcjh implements Runnable {
    private final zzciz zzfzv;
    private final zzbaj zzgaf;

    zzcjh(zzciz zzciz, zzbaj zzbaj) {
        this.zzfzv = zzciz;
        this.zzgaf = zzbaj;
    }

    public final void run() {
        zzbaj zzbaj = this.zzgaf;
        String zzwh = zzq.zzla().zzwb().zzww().zzwh();
        if (!TextUtils.isEmpty(zzwh)) {
            zzbaj.set(zzwh);
        } else {
            zzbaj.setException(new Exception());
        }
    }
}
