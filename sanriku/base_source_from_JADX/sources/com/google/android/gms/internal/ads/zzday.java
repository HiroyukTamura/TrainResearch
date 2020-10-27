package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzday implements zzdak<zzdav> {
    private final Executor executor;
    private final ScheduledExecutorService zzfky;
    private final zzavz zzgpa;
    private final Context zzvf;

    public zzday(zzavz zzavz, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzgpa = zzavz;
        this.zzvf = context;
        this.zzfky = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdri<zzdav> zzaqa() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzclq)).booleanValue()) {
            return zzdqw.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdqr.zzg(this.zzgpa.zzak(this.zzvf)).zza(zzdax.zzdsc, this.executor).zza(((Long) zzvj.zzpv().zzd(zzzz.zzclr)).longValue(), TimeUnit.MILLISECONDS, this.zzfky).zza(Throwable.class, new zzdba(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdav zze(Throwable th) {
        zzvj.zzpr();
        return new zzdav((AdvertisingIdClient.Info) null, zzazm.zzbl(this.zzvf));
    }
}
