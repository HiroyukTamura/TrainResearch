package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdah;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcxg<S extends zzdah<?>> implements zzdak<S> {
    private final Clock zzbnt;
    private final AtomicReference<zzcxf<S>> zzgmu = new AtomicReference<>();
    private final zzdak<S> zzgmv;
    private final long zzgmw;

    public zzcxg(zzdak<S> zzdak, long j, Clock clock) {
        this.zzbnt = clock;
        this.zzgmv = zzdak;
        this.zzgmw = j;
    }

    public final zzdri<S> zzaqa() {
        zzcxf zzcxf = this.zzgmu.get();
        if (zzcxf == null || zzcxf.hasExpired()) {
            zzcxf = new zzcxf(this.zzgmv.zzaqa(), this.zzgmw, this.zzbnt);
            this.zzgmu.set(zzcxf);
        }
        return zzcxf.zzgms;
    }
}
