package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwq implements zzdak<zzcwn> {
    private final Executor executor;
    private final ScheduledExecutorService zzfky;
    private final Context zzvf;

    public zzcwq(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzvf = context;
        this.zzfky = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdri<zzcwn> zzaqa() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcte)).booleanValue()) {
            return zzdqw.zzag(null);
        }
        zzbaj zzbaj = new zzbaj();
        try {
            new zzcwp(zzbaj).zzbm(false);
        } catch (Throwable unused) {
            zzazw.zzfa("ArCoreApk is not ready.");
            zzbaj.set(false);
        }
        return zzdqw.zzb(zzdqw.zzb(zzdqw.zza(zzbaj, 200, TimeUnit.MILLISECONDS, this.zzfky), new zzcws(this), this.executor), Throwable.class, zzcwr.zzbly, this.executor);
    }
}
