package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class zzbaq<T> {
    private final zzbaj<T> zzeae = new zzbaj<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzeaf = new AtomicInteger(0);

    public zzbaq() {
        zzdqw.zza(this.zzeae, new zzbap(this), zzbab.zzdzw);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzeaf.get();
    }

    @Deprecated
    public final void reject() {
        this.zzeae.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzban<T> zzban, zzbal zzbal) {
        zzdqw.zza(this.zzeae, new zzbas(this, zzban, zzbal), zzbab.zzdzw);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzeae.set(t);
    }
}
