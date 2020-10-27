package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdbm implements zzdak<zzdbj> {
    private final Executor executor;
    private final zzawd zzbnp;
    private final ScheduledExecutorService zzfky;
    private final zzavz zzgpa;
    private final int zzgpk;
    private final Context zzvf;

    public zzdbm(zzavz zzavz, int i, Context context, zzawd zzawd, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzgpa = zzavz;
        this.zzgpk = i;
        this.zzvf = context;
        this.zzbnp = zzawd;
        this.zzfky = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdri<zzdbj> zzaqa() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcsl)).booleanValue()) {
            return zzdqw.zzag(null);
        }
        return zzdqr.zzg(zzdqw.zza(new zzdbl(this), this.executor)).zza(zzdbo.zzdsc, this.executor).zza(((Long) zzvj.zzpv().zzd(zzzz.zzclr)).longValue(), TimeUnit.MILLISECONDS, this.zzfky).zza(Exception.class, new zzdbn(this), zzdrk.zzawr());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzaqu() throws Exception {
        return this.zzgpa.zza(this.zzvf, this.zzgpk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdbj zzb(Exception exc) {
        this.zzbnp.zza(exc, "ATTESTATION_TOKEN_FETCH");
        return null;
    }
}
