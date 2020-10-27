package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcse implements zze {
    private final zzbvx zzfjc;
    private final zzbro zzfqc;
    private final zzbqw zzfqd;
    private final zzbkp zzfqe;
    private final zzbvs zzfqg;
    private AtomicBoolean zzgic = new AtomicBoolean(false);

    zzcse(zzbqw zzbqw, zzbro zzbro, zzbvx zzbvx, zzbvs zzbvs, zzbkp zzbkp) {
        this.zzfqd = zzbqw;
        this.zzfqc = zzbro;
        this.zzfjc = zzbvx;
        this.zzfqg = zzbvs;
        this.zzfqe = zzbkp;
    }

    public final synchronized void zzh(View view) {
        if (this.zzgic.compareAndSet(false, true)) {
            this.zzfqe.onAdImpression();
            this.zzfqg.zzu(view);
        }
    }

    public final void zzjy() {
        if (this.zzgic.get()) {
            this.zzfqd.onAdClicked();
        }
    }

    public final void zzjz() {
        if (this.zzgic.get()) {
            this.zzfqc.onAdImpression();
            this.zzfjc.zzajr();
        }
    }
}
