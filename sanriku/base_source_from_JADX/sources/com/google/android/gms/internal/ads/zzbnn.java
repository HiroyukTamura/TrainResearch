package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbnn implements zzbsm, zzpz {
    private final zzdgo zzfgk;
    private final zzbro zzfki;
    private final zzbsq zzfkj;
    private final AtomicBoolean zzfkk = new AtomicBoolean();
    private final AtomicBoolean zzfkl = new AtomicBoolean();

    public zzbnn(zzdgo zzdgo, zzbro zzbro, zzbsq zzbsq) {
        this.zzfgk = zzdgo;
        this.zzfki = zzbro;
        this.zzfkj = zzbsq;
    }

    private final void zzahx() {
        if (this.zzfkk.compareAndSet(false, true)) {
            this.zzfki.onAdImpression();
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzfgk.zzgtm != 1) {
            zzahx();
        }
    }

    public final void zza(zzqa zzqa) {
        if (this.zzfgk.zzgtm == 1 && zzqa.zzbot) {
            zzahx();
        }
        if (zzqa.zzbot && this.zzfkl.compareAndSet(false, true)) {
            this.zzfkj.zzait();
        }
    }
}
