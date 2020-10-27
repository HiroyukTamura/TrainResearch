package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdck implements zzdak<zzdch> {
    private ScheduledExecutorService zzfky;
    private zzapo zzgpy;
    private Context zzvf;

    public zzdck(zzapo zzapo, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgpy = zzapo;
        this.zzfky = scheduledExecutorService;
        this.zzvf = context;
    }

    public final zzdri<zzdch> zzaqa() {
        return zzdqw.zzb(zzdqw.zza(this.zzgpy.zzq(this.zzvf), ((Long) zzvj.zzpv().zzd(zzzz.zzcpo)).longValue(), TimeUnit.MILLISECONDS, this.zzfky), zzdcj.zzdsc, (Executor) zzbab.zzdzr);
    }
}
