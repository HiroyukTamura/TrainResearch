package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdah;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcyv<S extends zzdah<?>> implements zzdak<S> {
    private final ScheduledExecutorService zzfif;
    private final zzdak<S> zzgmv;
    private final long zzgnm;

    public zzcyv(zzdak<S> zzdak, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgmv = zzdak;
        this.zzgnm = j;
        this.zzfif = scheduledExecutorService;
    }

    public final zzdri<S> zzaqa() {
        zzdri<S> zzaqa = this.zzgmv.zzaqa();
        long j = this.zzgnm;
        if (j > 0) {
            zzaqa = zzdqw.zza(zzaqa, j, TimeUnit.MILLISECONDS, this.zzfif);
        }
        return zzdqw.zzb(zzaqa, Throwable.class, zzcyy.zzbly, zzbab.zzdzw);
    }
}
